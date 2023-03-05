package practices;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*System.out.println(process("Hey! this is test", new Processor() {
            @Override
            public String process(String str) {
                return str.toLowerCase();
            }
        }
        ));*/
        Permutation p = new Permutation();
        p.permutation("ab","");

    }

    private static String process(String s, Processor process) {
        return process.process(s);
    }
}
