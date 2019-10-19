package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontEndControllers {

    @RequestMapping(method = RequestMethod.GET, value = "/golfer")
    public ModelAndView getURIs() {
        ModelAndView mv = new ModelAndView("stableford.jsp");
        return mv;
    }
}
