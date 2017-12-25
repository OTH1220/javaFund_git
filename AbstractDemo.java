abstract class Employee{
	private String name;
	public String employeeNumber;
	public double salary;


	public Employee(String name, String employeeNumber, double salary){
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.salary = salary;

	}

	public abstract void workContent();
	public abstract void printInfo();
}


class Programmer extends Employee{

	public Programmer(String name, String employeeNumber, double salary){
		super(name, employeeNumber, salary);

	}

	public void workContent(){

		System.out.println("I do Programmer's job");
	}

	public void printInfo(){
		//System.out.println("Name: "+name+" Number: "+employeeNumber+" Salary: "+salary);	
	}

}

class ProgramManager extends Employee{

	private double bonus;

	public ProgramManager(String name, String employeeNumber, double salary, double bonus){
		super(name, employeeNumber, salary);
		this.bonus = bonus;
	}

	public void workContent(){
		System.out.println("I do manager's job");
	}

	public void printInfo(){
		//System.out.println("Name: "+name+" Number: "+employeeNumber+" Salary: "+salary+" Bonus: "+bonus);	
	}
}

class AbstractDemo{

	public static void main(String[] args){

		Programmer prgorammer1 = new Programmer("Tom", "003689", 2031.87);
		ProgramManager pm1 = new ProgramManager("Peter", "002149", 3564.80, 600);

		prgorammer1.workContent();
		prgorammer1.printInfo();

		pm1.workContent();
		pm1.printInfo();

	}

}