package nl.frontieroost.darkEnergy.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import nl.frontieroost.darkEnergy.contract.MyGvo;
import nl.frontieroost.darkEnergy.model.MgvoObject;

@Service
public interface MyGvoService
{
    void setMyGvoContract(MyGvo myGvoContract);

    int getTotalSupply();

    boolean mint(String to, int tokenId) throws Exception;

    boolean burn(int tokenId) throws Exception;

    String ownerOf(int tokenId) throws Exception;

    int balanceOf(String owner) throws Exception;

    boolean transferFrom(String from, String to, int tokenId) throws Exception;

    int loadMGvoTokens() throws Exception;

    int getTokenByIndex(int index) throws Exception;

    Optional<MgvoObject> getTokenByTokenId(int tokenId);
}
