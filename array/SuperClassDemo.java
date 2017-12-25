class Father{

	private String name;
	private int age;
	private int height;
	private int weight;

	private Father(){}

	 Father(String name, int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public void printInfo(){
		System.out.print(name+", "+age+", "+weight+", "+height);
	}
}

class Son extends Father{

	Son(String name, int age, int height, int weight){
		super(name, age, height, weight);
	}

}


class SuperClassDemo{

	public static void main(String args[]){
		Son son = new Son("haha",21,21,21);

		son.printInfo();
	}

}