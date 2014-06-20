package org.project.webapp.google.controller;

import org.project.webapp.google.user.AuthenticateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signin/login")
public class LoginController {

  private AuthenticateUser user;

  @Autowired
  public LoginController(AuthenticateUser user) {
    this.user = user;
  }

  @RequestMapping(method = RequestMethod.POST)
  public String login(@RequestParam("email") String email,
      @RequestParam("password") String password, ModelMap model) {

    if (user.authenticate(email, password) == true) {
      model.addAttribute("msg", email);
      System.out.println("authenticated");
      return "home";

    } else {
      model.addAttribute("msg", "Username or Password is Wrong !");
      System.out.println("failed");
      return "signin";

    }
  }

}
