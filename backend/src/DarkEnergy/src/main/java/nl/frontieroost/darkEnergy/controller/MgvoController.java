package nl.frontieroost.darkEnergy.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/myGvo/mint/tokenId", method = RequestMethod.POST)
    public boolean mintMyGvoToken(@RequestParam String to, @RequestParam Integer tokenId) {
        if (tokenId >= 0) {
            try
            {
                return myGvoService.mint(to, tokenId);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

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
