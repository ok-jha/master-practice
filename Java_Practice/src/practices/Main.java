package practices;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

//public class Main {
//
//    public static void main(String[] args) {
////        MyService myService = new MyService();
////        Runnable task = new MyTask();
////        MyService myServiceOne = new MyService(1);
//
//        /*for(int i=0;i<20;i++){
//            myService.doSomething();
//        }*/
//        //for(int i=0;i<5;i++){
////            try {
////                myService.processTask(new MyTask());
////                myService.processTask(new MyTask());
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        //}
//
//     /*   for (int i = 0; i < 5; i++) {
//            try {
//                myServiceOne.usingFutureObject(task);
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }*/
//
////        myService.shutdown();
////
////        System.out.println("All tasks have been executed");
//
//
//        /*int[] pArray = {1, 2, 3, 4, 5};
//        Arrays.sort(pArray);
//        int minimumSum = Integer.MAX_VALUE;
//        int length = pArray.length;
//
//        int start = 0;
//        int end = length-1;
//        int minStart= pArray[0];
//        int minEnd = pArray[length-1];
//
//
//        while (start < end) {
//            int sum = pArray[start]+pArray[end];
//
//            if(Math.abs(sum) < Math.abs(minimumSum)){
//                minimumSum = sum;
//                minStart = pArray[start];
//                minEnd = pArray[end];
//            }
//            if(sum > 0)
//                end--;
//            else
//                start++;
//        }
//        System.out.println("Closest pair to zero is: "+minStart+" and "+minEnd);*/
//    }

//}
public class Main {
    int number = 1;
    int maxNumber;

    public Main(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public static void main(String[] args) {
        Main evenOddPrinter = new Main(10);

        Thread evenThread = new Thread(() -> evenOddPrinter.printEven());
        Thread oddThread = new Thread(() -> evenOddPrinter.printOdd());

        evenThread.start();
        oddThread.start();
    }

    public synchronized void printEven() {
        while (number <= maxNumber) {
            // If number is odd, wait
            if (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // If number is even, print it and increment the number
            if (number <= maxNumber) {
                System.out.println("Even: " + number);
                number++;
            }

            // Notify the other thread
            notify();
        }
    }

    public synchronized void printOdd() {
        while (number <= maxNumber) {
            // If number is even, wait
            if (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // If number is odd, print it and increment the number
            if (number <= maxNumber) {
                System.out.println("Odd: " + number);
                number++;
            }

            // Notify the other thread
            notify();
        }
    }
}

