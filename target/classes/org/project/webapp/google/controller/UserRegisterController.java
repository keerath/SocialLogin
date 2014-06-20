package org.project.webapp.google.controller;



import org.project.webapp.google.user.EmailAddressInUseException;
import org.project.webapp.google.user.InsertNewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegisterController {

  private InsertNewUser newUser;

  @Autowired
  public UserRegisterController(InsertNewUser newUser) {
    this.newUser = newUser;
  }

  @RequestMapping(value = "/signin/reg", method = RequestMethod.GET)
  public ModelAndView reg() {
    return new ModelAndView("reg");
  }

  @RequestMapping(value = "/signin/reg/confirm", method = RequestMethod.POST)
  public String redirect(@RequestParam("email") String email,
      @RequestParam("password") String password)
      throws EmailAddressInUseException {
    newUser.insert(email, password);
    return "redirect:/signin";
  }
}
