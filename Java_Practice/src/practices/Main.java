package practices;

public class Main<T extends Comparable<T>> {

    /*static node head;

    static class node {
        int data;
        node next;

        node(int data){
            this.data = data;
            next = null;
        }
    }
    public static void deleteFirstNode(){

        if(head == null)
            return;
        head = head.next;
    }

    public static void deleteLastNode(){
        node tempNode = head;
        if(tempNode == null)
            return;
        while(tempNode.next.next != null){
            tempNode = tempNode.next;
        }

        tempNode.next = null;
    }

    public static void deleteNode(int value){
        node currentNode = head;
        node previousNode = null;
        while (currentNode != null){
            if(currentNode.data == value){
                if(previousNode == null)
                    head = currentNode.next;
                else
                    previousNode.next = currentNode.next;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    // Helper function to print the linked list
    public void printList() {
        node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }*/
//    int currentNumber = 1;
//    int limit = 10;
//
//    public synchronized void printEven(){
//        while(currentNumber <= limit){
//            if(currentNumber % 2 == 0){
//                System.out.println(currentNumber);
//                currentNumber++;
//                notify();
//            }
//            else {
//                try {
//                    wait();
//                }
//                catch (InterruptedException ie){
//                    System.out.println(ie.getStackTrace());
//                }
//            }
//        }
//    }
//    public synchronized void printOdd(){
//        while(currentNumber <= limit){
//            if(currentNumber % 2 != 0){
//                System.out.println(currentNumber);
//                currentNumber++;
//                notify();
//            }
//            else {
//                try {
//                    wait();
//                }
//                catch (InterruptedException ie){
//                    System.out.println(ie.getStackTrace());
//                }
//            }
//        }
//    }


    public static void main(String[] args) {




    }

    /*private static String process(String s, Processor process) {
        return process.process(s);
    }*/


}
