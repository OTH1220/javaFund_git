class Resource_Person{
    private String name;
    private String gender;
    private boolean ioSwithcher = false;

    public synchronized void setInfo(String name, String gender){
        while(ioSwithcher)
            try{this.wait();}catch(InterruptedException e){}
        this.name = name;
        this.gender = gender;
        ioSwithcher = true;
        this.notifyAll();
    }

    public synchronized void getInfo(){
        while(!ioSwithcher)
            try{this.wait();}catch(InterruptedException e){}
        System.out.println(this.name+"***LOCK***"+this.gender);
        ioSwithcher=false;
        this.notifyAll();
    }

}

class OutputHelper implements Runnable{
    Resource_Person resource_person = null;

    public OutputHelper(Resource_Person rp){
        this.resource_person = rp;
    }

    public void run(){
        while(true){
            resource_person.getInfo();
        }
    }
}

class InputHelper implements Runnable{
    Resource_Person resource_person = null;
    int resource_switcher = 0;

    public InputHelper(Resource_Person rp){
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
