package practices;

public class Main {

    public static void main(String[] args) {
        MyService myService = new MyService();
        Runnable task = new MyTask();

        /*for(int i=0;i<20;i++){
            myService.doSomething();
        }*/
        for(int i=0;i<20;i++){
            try {
                myService.processTask(new MyTask());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        myService.shutdown();

        System.out.println("All tasks have been executed");

    }
}
