package lab02;

/**
 * This class represents a employee. The employee contains information of their name, 
 * worked hours and pay rate.
 *
 */
class Employee {
  private String name;
  private double hours;
  private double rate;
  
  
  /**
   * Construct an Employee object that takes a name and pay rate as parameters. 
   * Initialize worked hours to 0.
   * @param name name of the employee
   * @param hours worked hours in a week of the employee
   * @param rate pay rate of an employee
   */
  public Employee(String name, double hours, double rate) {
    this.name = name;
    this.hours = 0;
    this.rate = rate;
  }
  
  /**
   * return the hours worked of this employee.
   * 
   * @return the hours worked of this employee
   */
  public double getHoursWorked() {
    return this.hours;
  }
  
  /**
   * Adds the value of addedHours to the current worked hours this week for the Employee.
   * 
   * @param addedHours the hours that needs to be added 
   */
  public void addHoursWorked(double addedHours) {
    this.hours = this.hours + addedHours;
  }
  
  /**
   * Resets the employee’s hours worked for the week to zero.
   * 
   */
  public void resetHoursWorked() {
    this.hours = 0;
  }
  
  /**
   * Return a new PayCheck object according to the current employee.
   * 
   * @return a new PayCheck object initialized to the current Employee name, rate and hours worked
   */
  public PayCheck getWeeklyCheck() {
    return new PayCheck(this.name, this.hours, this.rate);
    
  }
  
  /**
   * Return the string of employee name.
   * 
   * @return the string of employee name.
   */
  public String toString() {
    return String.format(this.name);
  }
  
}