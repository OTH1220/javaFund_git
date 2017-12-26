import java.util.concurrent.locks.*;

//定义代表资源的类，用人表示，带有名字和性别属性
class Resource_Person{
    private String name;
    private String gender;
    private boolean ioSwithcher = false; //实现信息 录入/输出 的调节器，当人的信息录入完毕后为false，需要录入时为true
    private int count; //生产数量的计数器
    //用Lock替代Synchronize代码块实现同步
    private final ReentrantLock lock = new ReentrantLock();
    //使用Lock产生的线程监视器，
    private Condition setCondition = lock.newCondition();
    private Condition getCondition = lock.newCondition();

    // public synchronized void setInfo(String name, String gender){
    public void setInfo(String name, String gender){
        lock.lock(); //使用Lock，一定要用try-finally处理，并在finally中释放锁
        try{
            while(ioSwithcher){
                // try{this.wait();}catch(InterruptedException e){}
                try{setCondition.await();}catch(InterruptedException e){}
            }
            count++;
            this.name = name;
            this.gender = gender;
            System.out.println(Thread.currentThread().getName()+": "+this.name+"--"+this.gender+"生产："+count);
            ioSwithcher = true;
            // this.notifyAll();
            getCondition.signal();
        }finally{
            lock.unlock();
        }
    }

    //public synchronized void getInfo(){
    public void getInfo(){
        lock.lock();
        try {
            while(!ioSwithcher){
                // try{this.wait();}catch(InterruptedException e){}
                try{getCondition.await();}catch(InterruptedException e){}
            }
            System.out.println(Thread.currentThread().getName()+": "+this.name+"--"+this.gender+"消费："+count);
            ioSwithcher=false;
            // this.notifyAll();
            setCondition.signal();
        }finally{
            lock.unlock();
        }
    }

}

class OutputHelper implements Runnable{
    private Resource_Person resource_person = null;

    OutputHelper(Resource_Person rp){
        this.resource_person = rp;
    }

    public void run(){
        while(true){
            resource_person.getInfo();
        }
    }
}

class InputHelper implements Runnable{
    private Resource_Person resource_person = null;
    int resource_switcher = 0;

    InputHelper(Resource_Person rp){
        this.resource_person = rp;
    }

    public void run(){
        while(true){
            if (resource_switcher % 2 == 0)
                resource_person.setInfo("老刘","男");
            else
                resource_person.setInfo("Grace","Female");

            resource_switcher++;
        }
    }
}

class ThreadSyncUsingLock{
    public static void main(String[] args){
        Resource_Person resource_person = new Resource_Person();
        InputHelper inputHelper = new InputHelper(resource_person);
        OutputHelper outputHelper = new OutputHelper(resource_person);

        Thread thread0 = new Thread(inputHelper);
        Thread thread1 = new Thread(inputHelper);
        Thread thread2 = new Thread(outputHelper);
        Thread thread3 = new Thread(outputHelper);

        thread0.start();
        thread2.start();
        thread1.start();
        thread3.start();
    }


}
