package practices;

import java.awt.*;
import java.beans.BeanProperty;
import java.io.Serial;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/*class ListNode{
    int value;
    ListNode next;

    ListNode(int val){
        value = val;
        next = null;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        value = val;
        left = null;
        right = null;
    }
}*/

class Employee {
    long salary;
    String department;

    public Employee (String dep, long salary){
        this.department = dep;
        this.salary = salary;
    }
    public String getDepartment(){
        return department;
    }

    public long getSalary() {
        return salary;
    }
}
public class Main {

    public static void main(String[] args) {

        List<Employee> li = new ArrayList<>();
        li.add(new Employee("HR",10));
        li.add(new Employee("HR",20));
        li.add(new Employee("IT",10));
        li.add(new Employee("Sales",30));

        Map<String,Long> total = li.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)));

        total.forEach((department,totalSalary)-> System.out.println("Department "+department+" : "+totalSalary));
        /*ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        int n = 0;
        ListNode result = Solution(list, n);

        while(result != null){
            System.out.println(result.value);
            result = result.next;
        }*/

//        String[] arr = {"eat","tea","tan","ate","nat","bat"};
//        List<List<String>> result = Solution(arr);
//
//        System.out.println(result);
         /*TreeNode node = new TreeNode(1);
         node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        Solution(node);*/

    }

    /*public static void Solution (TreeNode root){

        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.poll();
                if(i==0)
                    System.out.print(current.value+ " ");
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
        }



    }*/

    /*public static List<List<String>> Solution (String[] arr){

        if (arr == null || arr.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str:
             arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }*/

    /*public static ListNode Solution(ListNode head, int n){
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        ListNode second = temp;

        if(n==0)
            return head;

        for (int i = 1; i <= n+1; i++) {
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return temp.next;
    }*/


}
