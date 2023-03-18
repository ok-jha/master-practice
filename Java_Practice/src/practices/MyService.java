package practices;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
import java.io.*;
import java.util.concurrent.Executors;

public class MyService {
    private static final int MAX_ATTEMPTS = 5;
    private ExecutorService executorService;

    public MyService(){
        executorService = Executors.newFixedThreadPool(10);
    }

    public void doSomething(){
        Runnable task = new MyTask();
        executorService.execute(task);
    }

    public void processTask(Runnable task) throws InterruptedException{
        int attempt = 1;
        while(attempt <= MAX_ATTEMPTS){
            System.out.println("Attempting task, attempt "+ attempt);

            try {
                executorService.submit(task).get();
                return;
            }
            catch (ExecutionException e){
                System.err.println("Task Failed, attempt "+ attempt);
            }
            attempt++;
        }
    }

    public void shutdown(){
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
