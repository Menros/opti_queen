
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

    public static void main(String[] args) {
        int n = 100;
        int n1 = n*2;
        int n2 = n*8;
        int temperatureInitiale = 1;
        double gamma = 0.1;
        ArrayList<Integer> queens = new ArrayList<>();
        int fitness = 0;
        int nbTests = 1;

        for (int i = 0; i < n; i++) {
            queens.add(i);
        }

        System.out.println("-------------- Algorithm Recuit Simulé --------------");

        long timeStart = System.currentTimeMillis();
        for(int z = 0 ; z < nbTests ; z++){
            RecuitSimule recuit = new RecuitSimule(n, queens, n1, n2, temperatureInitiale, gamma);
            System.out.println(recuit.getQueens());
            System.out.println("Fitness début : " + recuit.getfMin());
            recuit.optimisation();
            System.out.println(recuit.getIteration() + " itérations");
            System.out.println("Solution finale : " + recuit.getqMin());
            System.out.println("Fitness min : " + recuit.getfMin());
            System.out.println("");
            fitness+= recuit.getfMin();
        }
        long timeEnd = System.currentTimeMillis();

        Date date = new Date(timeEnd - timeStart);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println("Temps d'exécution : " + cal.get(Calendar.MINUTE) + " min " + cal.get(Calendar.SECOND) + " s " + cal.get(Calendar.MILLISECOND) + " ms");

        System.out.println("Somme fitness : " + fitness);
    }
}
