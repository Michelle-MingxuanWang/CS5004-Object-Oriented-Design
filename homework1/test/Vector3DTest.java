

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Vector3D class.
 */
public class Vector3DTest {
  
  private Vector3D vector;
  
  @Before
  public void setUp() {
    vector = new Vector3D(1.52,2.84,4.79);
  }
  
  @Test
  public void testX() {
    assertEquals(1.52, vector.getX(), 0.01);
  }
  
  @Test
  public void testY() {
    assertEquals(2.84, vector.getY(), 0.01);
  }
  
  @Test
  public void testZ() {
    assertEquals(4.79, vector.getZ(), 0.01);
  }
  
  @Test
  public void testToString() {
    assertEquals("(1.52,2.84,4.79)", vector.toString());
  }
  
  @Test
  public void testToString1Decimal() {
    Vector3D vector1Decimal = new Vector3D(1.5,2,3.5);
    assertEquals("(1.50,2.00,3.50)", vector1Decimal.toString());
  }
  
  @Test
  public void testToString3Decimal() {
    Vector3D vector3Decimal = new Vector3D(1.528,2.174,4.284);
    assertEquals("(1.53,2.17,4.28)", vector3Decimal.toString());
  }
  
  @Test
  public void testGetMagnitude() {
    assertEquals(5.77, vector.getMagnitude(), 0.01);
  }
  
  @Test
  public void testGetMagnitudeZero() {
    Vector3D vector0 = new Vector3D(0,0,0);
    assertEquals(0, vector0.getMagnitude(), 0.01);
  }
  
  @Test
  public void testNormalize() {
    Vector3D normalizedVector = vector.normalize();
    assertEquals("(0.26,0.49,0.83)", normalizedVector.toString());
  }
    
  @Test(expected = IllegalStateException.class)
  public void testIllegalNormalize() {
    Vector3D invalidVector = new Vector3D(0,0,0);
    invalidVector.normalize();
  }

  @Test
  public void testAdd() {
    Vector3D other = new Vector3D(3.65,2.85,5.73);
    assertEquals("(5.17,5.69,10.52)", vector.add(other).toString());
  }
  
  @Test
  public void testAddZero() {
    Vector3D vectorZero = new Vector3D(0,0,0);
    assertEquals("(1.52,2.84,4.79)", vector.add(vectorZero).toString());
  }
  
  @Test
  public void testAddNegative() {
    Vector3D vectorNegative = new Vector3D(-1.52,-2.84,-4.79);
    assertEquals("(0.00,0.00,0.00)", vector.add(vectorNegative).toString());
  }
  
  @Test
  public void testMultiply() {
    Vector3D multipliedVector = vector.multiply(1.55);
    assertEquals("(2.36,4.40,7.42)", multipliedVector.toString());
  }
  
  @Test
  public void testMultiplyZero() {
    Vector3D multipliedVectorZero = vector.multiply(0);
    assertEquals("(0.00,0.00,0.00)", multipliedVectorZero.toString());
  }
  
  @Test
  public void testDotProduct() {
    Vector3D other = new Vector3D(3.65,2.85,5.73);
    double result = 41.09;
    assertEquals(result, vector.dotProduct(other), 0.01);
  }
  
  @Test
  public void testAngleBetweenOpposite() {
    Vector3D vector1 = new Vector3D(0,0,1);
    Vector3D vector2 = new Vector3D(0,0,-1);
    assertEquals(180, vector1.angleBetween(vector2), 0.01);
    
  }
  
  @Test
  public void testAngleBetweenAcute() {
    Vector3D otherAcute = new Vector3D(3.65,2.85,5.73);
    assertEquals(14.94, vector.angleBetween(otherAcute), 0.01);
  }
  
  @Test
  public void testAngleBetweenObtuse() {
    Vector3D otherObtuse = new Vector3D(9.52,-8.25,-29.43);
    assertEquals(144.23, vector.angleBetween(otherObtuse), 0.01);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testIllegalAngleBetweenCurrent() {
    Vector3D invalidVector = new Vector3D(0,0,0);
    invalidVector.angleBetween(vector);
  }
  
  @Test(expected = IllegalStateException.class)
  public void testIllegalAngleBetweenPara() {
    Vector3D invalidVector = new Vector3D(0,0,0);
    vector.angleBetween(invalidVector);
  }
}

