package org.project.webapp.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.Google;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  private final Google google;

  @Autowired
  public HomeController(Google google) {
    this.google = google;
  }

  @ResponseBody
  @RequestMapping("/")
  public ModelAndView welcome() {
    return new ModelAndView("home", "msg", google.plusOperations()
        .getGoogleProfile().getGivenName());
  }
}
