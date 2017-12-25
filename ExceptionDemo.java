/*
	Bus driver drives bus.
*/

class FlameoutException extends Exception{

			FlameoutException(String msg){
				 super(msg);
			}
}

class OutOfFuelException extends Exception{
	OutOfFuelException(String msg){
		 super(msg);
	}
}

class BusHaltException extends Exception{
	BusHaltException(String msg){
		 super(msg);
	}
}

class Bus{

	// private String busName;
	// private String busColor;

	// Bus(String name, String color){
	// 	this.busName = name;
	// 	this.busColor = color;
	// }
	private int busState = 2;

	Bus(){	}

	public void startEngine() throws FlameoutException{
			if(busState == 0)
					System.out.println("Bus Started");
			else
					throw new FlameoutException("The bus is flameout");
	}

	public void restartEngine() throws OutOfFuelException{
		if(busState == 1){
			 System.out.println("Bus engine restarted, we can move on...");
		}else if(busState == 2){
			 throw new OutOfFuelException("The bus is out of fuel...");
		}
	}

}

class Driver{

		private String driverName;
		private int age;
		private Bus bus;

		Driver(String name, int age){
				this.driverName = name;
				this.age = age;
				bus = new Bus();
		}

		public void drive() throws BusHaltException{
				try{
					bus.startEngine();
					System.out.println("Engine started, now you can drive.");
				}
				catch(FlameoutException e){
						 try{
							 bus.restartEngine();
						 }catch(OutOfFuelException ex){
							 	System.out.println(ex.toString()+".....");
								throw new BusHaltException("Bus halted"+ex.toString());
						 }
				}


		}

}

class ExceptionDemo{

	public static void main(String[] args){
			Driver driver1 = new Driver("Jhon",36);
			try{
				driver1.drive();
			}catch(BusHaltException e){
				 System.out.println(e.toString());
				 System.out.println("Starting emergency plan !!!");
			}
	}

}
