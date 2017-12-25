//等待唤醒机制的原型程序，不能实现输入输出内容逐一打印

class Resource_Person{

    public String name;
    public String gender;

    public Resource_Person(){

    }

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
                if(switcher%2 == 0){
                    resource_person.name = "汤姆";
                    resource_person.gender = "男";
                    switcher++;
                }else{
                    resource_person.name = "Alice";
                    resource_person.gender = "Female";
                    switcher++;
                }
            }
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
                    System.out.println(resource_person.name+"......"+resource_person.gender);
                // }else{
                    // System.out.println(resource_person.name+"......"+resource_person.gender);
                // }
            }
        }
    }

}


class ThreadsWaitNotify1{
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
