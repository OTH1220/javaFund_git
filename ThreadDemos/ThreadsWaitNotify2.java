//引入线程的 等待-唤醒 机制，实现输入输出内容的逐一打印

class Resource_Person{

    public String name;
    public String gender;
    public boolean ioSwithcher = false; //用来标记输入输出的次序

}

class InputHelper implements Runnable{
    Resource_Person resource_person = null;
    int switcher = 0;

    //输入输出工具公用一个Resource_person对象，所以选择在构造函数中传入
    public InputHelper(Resource_Person rp){
        this.resource_person = rp;
    }

    public void run(){
        while(true){
            //加入同步代码块，避免线程安全问题
            synchronized(resource_person){
                if(resource_person.ioSwithcher)
                    try{resource_person.wait();}catch(InterruptedException e){}
                if(switcher%2 == 0){
                    resource_person.name = "汤姆";
                    resource_person.gender = "男";
                    // switcher++;
                }else{
                    resource_person.name = "Alice";
                    resource_person.gender = "Female";
                    // switcher++;
                    // resource_person.ioSwithcher = true;
                    // resource_person.notify();
                }
                resource_person.ioSwithcher = true;
                resource_person.notify();
            }
            switcher++;
        }
    }
}

class OutputHelper implements Runnable{
    Resource_Person resource_person = null;
    // int switcher = 0;

    public OutputHelper(Resource_Person rp){
        this.resource_person = rp;
    }

    public void run(){
        while(true){
            //加入同步代码块，避免线程安全问题
            synchronized(resource_person){
                // if(switcher%2 == 0){
                if(!resource_person.ioSwithcher)
                    try{resource_person.wait();}catch(InterruptedException e){}
                System.out.println(resource_person.name+"......"+resource_person.gender);
                resource_person.ioSwithcher = false;
                resource_person.notify();
                // }else{
                    // System.out.println(resource_person.name+"......"+resource_person.gender);
                // }
            }
        }
    }

}


class ThreadsWaitNotify2{
    public static void main(String[] args){
        Resource_Person resource_person = new Resource_Person();
        InputHelper inputHelper = new InputHelper(resource_person);
        OutputHelper outputHelper = new OutputHelper(resource_person);

        Thread inputThread = new Thread(inputHelper);
        Thread outputThread = new Thread(outputHelper);

        inputThread.start();
        outputThread.start();
    }

}
