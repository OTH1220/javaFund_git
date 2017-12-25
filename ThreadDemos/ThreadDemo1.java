class PrintFunction{
    String str;
    int runtime = 0;

    public PrintFunction(String str){
          System.out.println(str);
    }

    public void finalize(){
        ++runtime;
        System.out.println("Finalize run: "+runtime);
    }
}


class ThreadDemo1{

    public static void main(String args[]){
          new PrintFunction("pf1");
          new PrintFunction("pf2");
          new PrintFunction("pf3");
          System.gc();
          new PrintFunction("pf4");
          new PrintFunction("pf5");
          System.out.println("Last main statement");
    }



}
