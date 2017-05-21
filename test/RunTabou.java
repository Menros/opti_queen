import java.util.ArrayList;

/**
 * Created by Menros on 20/05/2017.
 */
public class RunTabou {
    public static void main(String[] args) {
        int n = 16;
        ArrayList<Integer> queens = new ArrayList<>();
        for (int i = 0; i < n; i++){
            queens.add(i);
        }
        Tabou tabou = new Tabou(n, 1000000000, n, queens);
        System.out.println(tabou.getQueens());
        long timeStart = System.nanoTime();
        tabou.optimisation();
        long timeEnd = System.nanoTime();
        System.out.println(tabou.getIteration() + " itérations");
        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -6)) +"ms");
//        System.out.println(Math.round((timeEnd - timeStart)*Math.pow(10, -9)) +"s");
        System.out.println(tabou.getqMin());
        System.out.println(tabou.getfMin());
    }
}
