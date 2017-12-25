class CreatingAndRunAThread2{
      public static void main(String[] args){
            ThreadHelper th = new ThreadHelper("XiaoQiang");
            ThreadHelper th2 = new ThreadHelper("旺财");

            Thread thread1 = new Thread(th);
            Thread thread2 = new Thread(th2);

            thread1.start();
            thread2.start();
      }

}


class ThreadHelper implements Runnable{
  String className;
  public ThreadHelper(String name){
    this.className = name;
  }
  public void run(){
      printInfo();

  }

  void printInfo(){
      for(int x = 0; x<10; x++){
          for(long y = -999999999; y<999999999; y++ ){}
          System.out.println(className+": "+Thread.currentThread().getName());
      }

  }

}
