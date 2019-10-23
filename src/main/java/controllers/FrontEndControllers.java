package controllers;

import gherkin.deps.com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontEndControllers {
    @RequestMapping(method = RequestMethod.GET, value = "/golfer")
    public ModelAndView getURIs() {
        ModelAndView mv = new ModelAndView("stableford.jsp");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.michaelangela.org.uk/hello";
        String str = restTemplate.getForObject(url, String.class);
        TestObject testObject = new TestObject(str);
        mv.addObject(testObject);
        return mv;
    }
}




