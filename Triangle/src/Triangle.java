public abstract class Triangle
{
  private String type;
  private double side;

  public Triangle(String aType, double a)
  {
    type = aType;
    side = a;
  }

  public double getPerimeter()
  {
    if ("equilateral".equals(type))
      return 3 * side;
    else if ("right".equals(type))
      return (2 + Math.sqrt(2.0)) * side;
    else
      return -1;
  }

  public double getArea()
  {
    if ("equilateral".equals(type))
      return Math.sqrt(3) / 4 * side * side;
    else if ("right".equals(type))
      return side * side / 2;
    else
      return -1;
  }
  
  public double getRatio()
  {
    return getArea()/getPerimeter();
  }
}  
