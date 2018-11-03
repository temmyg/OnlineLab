//import static net.mindview.util.Print.*;

import java.util.TreeSet;

class Insect implements Comparable<Insect> {
    private int i = initVariable();

    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private int initVariable(){
        System.out.println("Intersect i initialized");
        return 9;
    }

    @Override
    public int compareTo(Insect o) {
        return this.j - o.j;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    public void simulateException() throws Exception{
        throw new Exception("Horrible Error");
    }

    public void wrapperException() throws Exception{
        try {
            simulateException();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public int someActivity() throws Exception{
//        if(true) {
//            throw new Exception();
//        }
//        else
//            return 1;
        try{
            subActivity();
        }
        catch (Exception ex){
            throw new Exception();
        }
        return -1;
    }

    private void subActivity(){

    }

    public int jumpSteps() {

        try{
            throw new Exception("no jump");
        }
        catch (Exception ex){

            return 0;
        }
        finally {
            return  1;
        }
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.format("total %d arguments", args.length);
        System.out.println();
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        //TreeSet ts = new TreeSet();
        //ts.add(b);
        //Insect i = new Insect();
        //ts.add(i);
        TreeSet set = new TreeSet();
        set.add("adfa");
        set.add("fdsf");

        TreeSet<Beetle> ts1 = new TreeSet<Beetle>();
        ts1.add(b);

        try {
          //  b.simulateException();
            b.wrapperException();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        int steps = b.jumpSteps();

    }
}
