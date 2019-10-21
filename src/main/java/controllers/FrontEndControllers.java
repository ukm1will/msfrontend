package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontEndControllers {
    @RequestMapping(method = RequestMethod.GET, value = "/golfer")
    public ModelAndView getURIs() {
        Foobar foobar = new Foobar("bolux");
        ModelAndView mv = new ModelAndView("stableford.jsp");
        System.out.println(foobar.getTitle());
        mv.addObject(foobar);
        return mv;
    }
}