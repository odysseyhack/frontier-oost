package nl.frontieroost.darkEnergy.services;

import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import nl.frontieroost.darkEnergy.contract.MyGvo;
import nl.frontieroost.darkEnergy.model.MgvoObject;
import nl.frontieroost.darkEnergy.repositories.MgvoRepository;

@Service
@Getter
@Slf4j
public class MyGvoServiceImpl implements MyGvoService
{
    private final static Logger logger = LoggerFactory.getLogger(MyGvoService.class);

    private MyGvo myGvoContract;

    private MyGvoService myGvoService;

    private MgvoRepository mgvoRepository;

    @Autowired
    public void setMgvoRepository(MgvoRepository mgvoRepository)
    {
        this.mgvoRepository = mgvoRepository;
    }

    @Autowired
    public void setMyGvoService(MyGvoService myGvoService)
    {
        this.myGvoService = myGvoService;
    }

    @Override
    public void setMyGvoContract(MyGvo myGvoContract)
    {
        this.myGvoContract = myGvoContract;
    }


    @Override
    public int getTotalSupply()
    {
        try
        {
            return myGvoContract.totalSupply().send().intValue();
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    @Override
    public boolean mint(String to, int tokenId) throws Exception
    {
        return myGvoContract.mint(to, BigInteger.valueOf(tokenId)).send().isStatusOK();
    }

    @Override
    public boolean mintToZipCodeAddress(String zipCode, int tokenId) throws Exception
    {
        return myGvoContract.mintToZipCode(zipCode, BigInteger.valueOf(tokenId)).send().isStatusOK();
    }

    @Override
    public boolean burn(int tokenId) throws Exception
    {
        return myGvoContract.burn(BigInteger.valueOf(tokenId)).send().isStatusOK();
    }

    @Override
    public String ownerOf(int tokenId) throws Exception
    {
        return myGvoContract.ownerOf(BigInteger.valueOf(tokenId)).send();
    }

    @Override
    public int balanceOf(String owner) throws Exception
    {
        return myGvoContract.balanceOf(owner).send().intValue();
    }

    @Override
    public boolean transferFrom(String from, String to, int tokenId) throws Exception
    {
        return myGvoContract.transferFrom(from, to, BigInteger.valueOf(tokenId)).send().isStatusOK();
    }

    @Override
    public int loadMGvoTokens() throws Exception
    {
        int totalSupply = getTotalSupply();
        int counter = 0;
        if (totalSupply != -1)
        {
            for (int i = 0; i < totalSupply; i++) {
                final int tokenid = getTokenByIndex(i);
                if (tokenid >= 0) {
                    final Optional<MgvoObject> mgvoObjectOptional = getTokenByTokenId(tokenid);
                    if (!mgvoObjectOptional.isPresent()) {
                        final MgvoObject mgvoObject = new MgvoObject();
                        mgvoObject.setTokenId(tokenid);
                        mgvoRepository.save(mgvoObject);
                        counter++;
                        logger.info("Added new MyGvo object with tokenId: {}", mgvoObject.tokenId);
                    }
                }
            }
        }
        return counter;
    }

    @Override
    public int getTokenByIndex(int index) throws Exception
    {
        return myGvoContract.tokenByIndex(BigInteger.valueOf(index)).send().intValue();
    }

    @Override
    public Optional<MgvoObject> getTokenByTokenId(int tokenId)
    {
        return mgvoRepository.findByTokenId(tokenId);
    }
}
