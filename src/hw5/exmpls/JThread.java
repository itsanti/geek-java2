package hw5.exmpls;

class JThread extends Thread {
     
    JThread(String name){
        super(name);
    }
     
    @Override
    public void run(){
         
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            for (int i = 0; i < 10; i++) {
            System.out.println("Count in Jthread: " + i);
            Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}
