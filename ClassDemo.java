class Father{
	int number = 9;
	{
		System.out.println("Father");
	}

	Father(){
		super();
		show();
	}

	void show(){
		System.out.println("Father show"+number);
	}
}

class Son extends Father{
	int number = 8;
	{
		System.out.println("Son");
	}
	Son(){
		super();
		show();
	}
	void show(){
		System.out.println("Son Show"+number);
	}
}

class ClassDemo{

	public static void main(String[] args){
		new Son();
	}
}