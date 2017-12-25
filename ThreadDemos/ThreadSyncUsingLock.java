class Resource_Person{
    private String name;
    private String gender;
    private boolean ioSwithcher = false;

    public void setInfo(String name, String gender){
        if(ioSwithcher)
            try{this.wait();}catch(InterruptedException e){}
        this.name = name;
        this.gender = gender;
        ioSwithcher = true;
        notify();
    }

    public void getInfo(){
        if(ioSwithcher)
            try{this.wait();}catch(InterruptedException e){}
        System.out.println(this.name+"***LOCK***"+this.gender)
        ioSwithcher=false;
        this.notify();
    }

}


class ThreadSyncUsingLock{
    public static void main(String[] args){


    }


}
