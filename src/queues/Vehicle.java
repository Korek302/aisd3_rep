package queues;

public class Vehicle
{
	public String model;
	public int age;
	
	public Vehicle(String model, int age)
	{
		this.model = model;
		this.age = age;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return (String)(model+age);
	}
}
