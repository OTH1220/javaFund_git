class CreatingAndRunAThread{
      public static void main(String[] args){
              ThreadHelper helper = new ThreadHelper("XiaoQiang");
              ThreadHelper helper2 = new ThreadHelper("WangCai");

              helper.start();
              helper2.start();


      }

}

// Creating a thread by extending the Thread class

class ThreadHelper extends Thread{
      String nameInfo;

      public ThreadHelper(String name){
              this.nameInfo = name;
      }

      public void run(){
            for(int i=0; i<10; i++){
                for(long j=-999999999; j<999999999; j++){}
                  System.out.println(nameInfo+": "+i);
            }
      }
}
