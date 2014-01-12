package test.guilingwang.github;

public class Employee {
	public Employee(String n, String c) {
		name = n;
		dept = c;
	}
	
	public String getname(){
		return name;
	}
	
	public String getcountry(){
		return dept;
	}
	
	public String name;
	public String dept;

}
