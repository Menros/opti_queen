
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
}
