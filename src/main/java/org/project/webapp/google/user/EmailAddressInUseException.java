package org.project.webapp.google.user;

public class EmailAddressInUseException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public EmailAddressInUseException(String s) {
    super(s);
  }
}
