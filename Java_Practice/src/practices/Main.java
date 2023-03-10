package practices;

public class Main {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permutation("ab","");

    }

    private static String process(String s, Processor process) {
        return process.process(s);
    }
}
