class ThreadSuperSubDemo{
    public static void main(String[] args){
        RunnableThreadHelper rth = new RunnableThreadHelper();
        Thread thread = new ThreadExtensionHelper(rth);
        thread.run();

        new Thread(new Runnable(){
            public void run(){
                System.out.println("Runnable class's run method");
            }
        }){
            public void run(){
                System.out.println("Sub class's run method");
            }
        }.start();
    }
}

class RunnableThreadHelper implements Runnable{
    public void run(){
        System.out.println("RunnableHelper's run method");
    }

}

class ThreadExtensionHelper extends Thread{
    ThreadExtensionHelper(RunnableThreadHelper rth){
        super(rth);
    }

    public void run(){
        System.out.println("ThreadHelper's run method");
    }
}
