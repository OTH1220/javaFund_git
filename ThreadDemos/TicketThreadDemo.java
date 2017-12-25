class Ticket extends Thread{
    private int tickets = 100;

    public void run(){
      while(true){
            if(tickets>0){
                  System.out.println(Thread.currentThread().getName()+"...selling..."+tickets);
                  tickets--;
            }
      }
    }
}
/**用继承Thread的方式创建线程不能保证票数是共享的，因为每个线程在创建时都要创建独立的对象，
而每个独立的线程对象都持有属于自己的100张票

这种场景使用Runnable接口创建线程才是最好的，代码如下
*/

class TicketSelling implements Runnable{
    private int tickets;
// public boolean flag = true;
    public TicketSelling(int ticketNumber){
        this.tickets = ticketNumber;
    }

    public void run(){
        sellTicket();
    }

    // private void sellTicket(){
    //     while (true) {
    //         if (tickets>0) {
    //             System.out.println(Thread.currentThread().getName()+"......is selling....."+tickets);
    //             tickets--;
    //         }
    //     }
    //   }
    private void sellTicket(){
        // while(true){
        //       synchronized(this){
        //           if(tickets>0){
        //                 if (flag) {
        //                   System.out.println(Thread.currentThread().getName()+"....if..is selling....."+tickets);
        //                   tickets--;
        //                   try {Thread.sleep(5);} catch(InterruptedException e){}
        //                 }else{
        //                   System.out.println(Thread.currentThread().getName()+"....else..is selling....."+tickets);
        //                   tickets--;
        //                   try {Thread.sleep(5);} catch(InterruptedException e){}
        //                 }
        //           }
        //       }
        // }

        //多个线程操作被同步代码块封装的卖票逻辑
        while(true){
            synchronized(this){
                if(tickets>0){
                        System.out.println(Thread.currentThread().getName()+"....if..is selling....."+tickets);
                        tickets--;
                }
            }
            //为了让线程交替卖票，每个卖完票的线程睡1ms
            try {Thread.sleep(1);} catch(InterruptedException e){}
        }
    }

}
    class TicketThreadDemo{
        public static void main(String[] args){
      /**
              Ticket ticket = new Ticket();
              Ticket ticket2 = new Ticket();

              ticket.start();
              ticket2.start();
        */
              // TicketSelling ticketSelling = new TicketSelling(50);
              TicketSelling ticketSelling = new TicketSelling(300);

              Thread thread1 = new Thread(ticketSelling);
              Thread thread2 = new Thread(ticketSelling);
              // Thread thread3 = new Thread(ticketSelling);

              thread1.start();
              try {Thread.sleep(1);} catch(InterruptedException e){}
              // ticketSelling.flag = false;
              thread2.start();
              // thread3.start();
        }

    }
