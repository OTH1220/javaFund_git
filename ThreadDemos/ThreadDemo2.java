class ThreadDemo2{

    public static void main(String[] args){
      ThreadHelper threadHelper = new ThreadHelper("Helper1");
      ThreadHelper threadHelper2 = new ThreadHelper("Helper2");

      threadHelper.printInfo();
      threadHelper2.printInfo();
    }

}


class ThreadHelper{
    String classInfo;

    ThreadHelper(String classInfo){
        this.classInfo = classInfo;
    }

    public void printInfo(){
        for(int x =0; x<10; x++){
            for(long y=-999999999; y<999999999; y++){}
            System.out.println(classInfo+":-----"+x);

        }

    }

}
