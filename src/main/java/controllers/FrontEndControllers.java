package controllers;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import models.CompetitionMetadata;
import models.Golfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontEndControllers {

    @RequestMapping(method = RequestMethod.GET, value = "/url")
    public ModelAndView getURIs() {
        ModelAndView mv = new ModelAndView();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://msbackend.wkftwqs2fz.eu-west-2.elasticbeanstalk.com/url";
        String json = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<CompetitionMetadata>>() {
        }.getType();
        List<CompetitionMetadata> urls = gson.fromJson(json, listType);
        mv.setViewName("url.jsp");
        mv.addObject("urls", urls);
        return mv;
    }

    @RequestMapping("/view")
    public ModelAndView viewFromURL(HttpServletRequest request) {

        int viewId = Integer.parseInt(request.getParameter("viewId"));
        String dateOfCompetition = request.getParameter("dateOfCompetition");
        String competitionTitle = request.getParameter("competitionTitle");

        ModelAndView mv = new ModelAndView();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://msbackend.wkftwqs2fz.eu-west-2.elasticbeanstalk.com/view/" + viewId;
        String json = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Golfer>>() {
        }.getType();
        List<Golfer> golfers = gson.fromJson(json, listType);

        if (IsMedalCompetition(golfers.get(0)))
            mv.setViewName("medal.jsp");
        else
            mv.setViewName("stableford.jsp");

        mv.addObject("golfers", golfers);
        mv.addObject("competitionTitle", competitionTitle);
        mv.addObject("dateOfCompetition", dateOfCompetition);
        return mv;
    }


    @RequestMapping("/viewalt")
    public ModelAndView viewFromResult(HttpServletRequest request) {

        String dateOfCompetition = request.getParameter("dateOfCompetition");
        String competitionTitle = request.getParameter("competitionTitle");

        ModelAndView mv = new ModelAndView();

        String golfers = request.getParameter("golfers");

        mv.setViewName("stableford.jsp");
        mv.addObject("golfers", golfers);
        mv.addObject("competitionTitle", competitionTitle);
        mv.addObject("dateOfCompetition", dateOfCompetition);
        return mv;
    }

    private boolean IsMedalCompetition(Golfer golfer) {
        return golfer.getPts() == -1;
    }
}




