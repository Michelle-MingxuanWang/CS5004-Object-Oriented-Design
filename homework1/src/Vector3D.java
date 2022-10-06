/**
 * This class represents a 3D vector. The vector contains components x, y, z.
 */

class Vector3D {
  private double x;
  private double y;
  private double z;
  
  /**
   * Constructs a Vector3D object and initialize it to the given x, y, and z.
   * @param x the x component of the vector
   * @param y the y component of the vector
   * @param z the z component of the vector
   */
  
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  /**
   * Get the value of the x component.
   * 
   * @return the value of the x component
   */
  public double getX() {
    return this.x;
  }
  
  /**
   * Get the value of the y component.
   * 
   * @return the value of the y component
   */
  public double getY() {
    return this.y;
  }
  
  /**
   * Get the value of the z component.
   * 
   * @return the value of the z component
   */
  public double getZ() {
    return this.z;
  }
  
  /**
   * Return a string describing the vector.
   * 
   * @return string describing the vector
   */
  public String toString() {
    return String.format("(%.2f,%.2f,%.2f)", this.x, this.y, this.z);
  }
  
  /**
   * Return the magnitude of the vector.
   * 
   * @return value of the magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }
  
  /**
   * Return a normalized version of this vector.
   * 
   * @return normalized version of this vector
   * @throws IllegalStateException if the denominator is 0
   */
  public Vector3D normalize() throws IllegalStateException {
    if (this.getMagnitude() == 0) {
      throw new IllegalStateException("Denominator cannot be zero");
    }
    Vector3D normalizedVector = new Vector3D(this.x / this.getMagnitude(), 
        this.y / this.getMagnitude(), this.z / this.getMagnitude());
    return normalizedVector;
  }
  
  /**
   * Return the result vector of adding a vector to another.
   * 
   * @param other another vector that is added to
   * @return the added vector
   */
  public Vector3D add(Vector3D other) {
    return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
  }
  
  /**
   * Return the vector obtained by multiply each of its component by the provided constant.
   * 
   * @param c the provided constant
   * @return the multiplied vector
   */
  public Vector3D multiply(double c) {
    return new Vector3D(this.x * c, this.y * c, this.z * c);
  }
  
  /**
   * Return the dot product of two vectors.
   * 
   * @param other the other vector that used to calculate the dot product
   * @return dot product of two vectors
   */
  public double dotProduct(Vector3D other) {
    return this.x * other.x + this.y * other.y + this.z * other.z;
  }
  
  /**
   * Return the angle between two vectors.
   * 
   * @param other the other vector that used to calculate the angle
   * @return angle between two vectors
   * @throws IllegalStateException if the denominator is 0
   */
  public double angleBetween(Vector3D other) throws IllegalStateException {
    if (this.getMagnitude() * other.getMagnitude() == 0) {
      throw new IllegalStateException("Denominator cannot be zero");
    }
    double cosValue = this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude());
    
    return Math.acos(cosValue) * 180 / Math.PI;
  }
}

