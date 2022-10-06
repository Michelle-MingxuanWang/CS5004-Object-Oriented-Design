package lab01;

/**
 * This class represents the email address of a person. The email address contains
 * an user name and a domain. 
 */
class EmailAddress {
  private String username;
  private String domain;

  /**
   * Constructs a EmailAddress object and initializes it to the user name and domain.
   *
   * @param username    the user name of this person's email
   * @param domain the domain of this person's email
   */

  public EmailAddress(String username, String domain) { //constructor
    this.username = username;
    this.domain = domain;
  }

  /**
  * Return the user name of the email of this person.
  *
  * @return the user name of the email of this person
  */
  public String getUsername() {
    return this.username;
  }

  /**
  * Return the domain of the email of this person.
  *
  * @return the domain of the email of this person
  */
  public String getDomain() {
    return this.domain;
  }
}
