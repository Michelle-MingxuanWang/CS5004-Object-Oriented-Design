package lab02;

/**
 * This class represents a pay check of an employee. The pay check includes information about 
 * the employee's name, pay rate, worked hours and total pay.
 *
 */
class PayCheck {
  private String name;
  private double rate;
  private double hours;
  private double totalPay;
  
  
  /**
   * Constructs a PayCheck object that takes the employee name, pay rate, worked hours 
   * as parameters. Initialize and calculate total pay.
   * 
   * @param name name of the pay check
   * @param hours worked hours of the pay check
   * @param rate pay rate of the pay check
   */
  public PayCheck(String name, double hours, double rate) {
    this.name = name;
    this.hours = hours;
    this.rate = rate;
    if (this.hours <= 40) {
      this.totalPay = this.rate * this.hours;
    } else {
      this.totalPay = this.rate * 40 + 1.5 * this.rate * (this.hours - 40);
    }
  }
  
  /**
   * get the name of this pay check.
   * 
   * @return the name of the paycheck
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * get the worked hours of this pay check.
   * 
   * @return the worked hours of this pay check
   */
  public double getHours() {
    return this.hours;
  }
  
  /**
   * get the pay rate of this pay check.
   * 
   * @return the pay rate of this pay check
   */
  public double getRate() {
    return this.rate;
  }
  
  /**
   * get the total pay of the week of this paycheck. 
   * 
   * @return the total pay of the week.
   */
  public double getTotalPay() {
    return this.totalPay;
  }
  
  /**
   * return the string of the total pay of the paycheck.
   * 
   * @return the string of the total pay of the week.
   */
  public String toString() {
    return String.format("$%.2f", this.totalPay);
  }
  
}