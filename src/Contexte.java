import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Silver on 15-Mar-17.
 */
public class Contexte {
    private int size;
    private MOptimisation Mopti;

    public Contexte(int size) {
        this.size = size;
    }

//    public static void main(String[] args) {
//        int n = 100;
//        ArrayList<Integer> queens = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            queens.add(i);
//        }
//        Tabou tabou = new Tabou(n, 1000000000, n, queens);
//        System.out.println(tabou.getQueens());
//        long timeStart = System.nanoTime();
//        tabou.opimisation();
//        long timeEnd = System.nanoTime();
//        System.out.println(tabou.getIteration() + " itérations");
//        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -6)) +"ms");
////        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -9)) +"s");
//        System.out.println(tabou.getqMin());
//        System.out.println(tabou.getfMin());
//    }

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> queens = new ArrayList<>();
        for (int i = 0; i < n; i++){
            queens.add(i);
        }
        RecuitSimule recuit = new RecuitSimule(n, queens, n*2, n*8, 1, 0.1);
        System.out.println(recuit.getQueens());
        long timeStart = System.nanoTime();
        recuit.optimisation();
        long timeEnd = System.nanoTime();
        System.out.println(recuit.getIteration() + " itérations");
        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -6)) +"ms");
        System.out.println("Solution finale : " + recuit.getqMin());
        System.out.println("Fitness min : " + recuit.getfMin());
    }
}
