//This class is a demo for basic OOP

/**
Demonstrating a car with color and number of wheels

Defining the car's run function to print the car's color and number of wheels.
*/


class Car{

	int wheelNumber;
	String color;

	void run(){

		System.out.println("The running "+color+" car has "+wheelNumber+" wheels");
	
	}

}

class CarDemo{

	public static void main(String[] args){

		Car car1 = new Car();
		car1.wheelNumber = 4;
		car1.color = "Red";

		car1.run();
	}
}