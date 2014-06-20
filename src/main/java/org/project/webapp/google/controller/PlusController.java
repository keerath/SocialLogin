package org.project.webapp.google.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.Google;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/plus", method = GET)
public class PlusController {

  private final Google google;

  @Autowired
  public PlusController(Google google) {
    this.google = google;
  }

  @ResponseBody
  @RequestMapping("/welcome")
  public ModelAndView welcome() {
    return new ModelAndView("home", "msg", google.plusOperations()
        .getGoogleProfile().getGivenName());
  }
}
