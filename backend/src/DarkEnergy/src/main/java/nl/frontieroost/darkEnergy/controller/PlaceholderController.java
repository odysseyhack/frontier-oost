package nl.frontieroost.darkEnergy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Wely
 */
@Controller
public class PlaceholderController
{
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "index";
    }
}
