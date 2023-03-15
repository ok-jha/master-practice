package practices;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Start--> Testing the command line argument is working or not
        /*if (args.length < 2){
            System.out.println("Hello "+args[0]);
        }
        else{
            System.out.print("Hello ");
            for (int i =0;i< args.length;i++){
                if(i != args.length-1)
                    System.out.print(args[i]+" and ");
                else {
                    System.out.print(args[i]);
                }
            }
        }*/
        // End--> Testing the command line argument is working or not

        /*Start--> UnionFind
        This will fail because we are using hashmap which doesn't allow duplicate keys and if you alter the logic
        also it's not doable using hashmap*/
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        String N = "0";
        N = br.readLine();

        FailedUnionFind uf = new FailedUnionFind();
        UnionFind suf = new UnionFind();

        for (int i = 0; i < Integer.parseInt(N); i++) {
            String[] pq = br.readLine().split(" ");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            if(!suf.isConnected(p,q)){
                suf.union(p,q);
                System.out.println(p+ " "+q);
            }
            else {
                System.out.println("Both the point "+p+" and "+q+" is already connected");
            }
        }

        //End--> UnionFind


    }

}
