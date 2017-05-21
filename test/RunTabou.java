import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Menros on 20/05/2017.
 */
public class RunTabou {
    public static void main(String[] args) {
        int n = 3;
        int tabouSize = 5;
        int iterationMax = 10000;
        ArrayList<Integer> queens = new ArrayList<>();
        int nbTests = 1;

        for (int i = 0; i < n; i++){
            queens.add(i);
        }

        long timeMoy = 0;
        int fitnessMoy = 0;
        int iterationMoy = 0;

        for(int z = 1 ; z <= nbTests ; z++){
            System.out.println("test : " + z);

            Tabou tabou = new Tabou(n, iterationMax, tabouSize, queens);

            long timeStart = System.currentTimeMillis();
            tabou.opimisation();
            long timeEnd = System.currentTimeMillis();

            timeMoy += (timeEnd-timeStart);
            fitnessMoy += tabou.getfMin();
            iterationMoy += tabou.getIteration();
        }

        timeMoy = timeMoy/nbTests;
        fitnessMoy = fitnessMoy/nbTests;
        iterationMoy = iterationMoy/nbTests;

        Date date = new Date(timeMoy);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println("Temps d'exécution moyen : " + cal.get(Calendar.MINUTE) + " min " + cal.get(Calendar.SECOND) + " s " + cal.get(Calendar.MILLISECOND) + " ms");
        System.out.println("nombre d'itérations moyen : " + iterationMoy);
        System.out.println("fitness moyenne : " + fitnessMoy);
    }
}
