package nl.frontieroost.darkEnergy.controller;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.frontieroost.darkEnergy.model.MgvoObject;
import nl.frontieroost.darkEnergy.repositories.MgvoRepository;
import nl.frontieroost.darkEnergy.services.MyGvoService;

/**
 * @author Wely
 */
@RestController
public class MgvoController
{
    @Autowired
    public MgvoRepository mgvoRepository;

    @Autowired
    public MyGvoService myGvoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getAllMyGvos", method = RequestMethod.GET)
    public Iterable<MgvoObject> getAllMgvoObjects() {
        return mgvoRepository.findAll();
    }

    @RequestMapping(value = "/myGvo/tokenId/{tokenId}", method = RequestMethod.GET)
    public MgvoObject getMyGvoById(@PathVariable Integer tokenId) {
        if (tokenId >= 0) {
            Optional<MgvoObject> mgvoObject = mgvoRepository.findByTokenId(tokenId);
            return mgvoObject.orElse(null);
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/myGvo/payout/zipCodeAddress", method = RequestMethod.POST)
    public boolean mintMyGvoToken(@RequestParam String zipCodeAddress, @RequestParam String tokenId) {
        int randomNum = ThreadLocalRandom.current().nextInt(12, 5000 + 1);
        if (randomNum >= 0) {
            try
            {
                for (int i = 0; i < 2; i++)
                {
                    randomNum = ThreadLocalRandom.current().nextInt(12, 5000 + 1);
                    myGvoService.mintToZipCodeAddress(zipCodeAddress, randomNum);
                }
                return true;

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/loadMyGvosFromSmartContract", method = RequestMethod.GET)
    public Iterable<MgvoObject> loadTokensFromSmartContract() {
        try
        {
            int counter = myGvoService.loadMGvoTokens();
            if (counter > 0) {
                return mgvoRepository.findAll();
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }
}
