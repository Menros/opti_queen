import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Menros on 21/05/2017.
 */
public class RunTabouWithPrintFile {
    public static void main(String[] args) {
        int n = 50;
        int tabouSize = 5;
        int iterationMax = 200;
        ArrayList<Integer> queens = new ArrayList<>();
        int nbTests = 1;

        for (int i = 1; i <= n; i++){
            queens.add(i);
        }

        try{
            PrintWriter writer = new PrintWriter("test.csv", "UTF-8");
            writer.println("tabou;temps;iterations;fitness");

            for(tabouSize = 1 ; tabouSize <= 50 ; tabouSize++){
                System.out.println("Pour : " + tabouSize);

                long timeMoy = 0;
                int fitnessMoy = 0;
                int iterationMoy = 0;

                for(int z = 1 ; z <= nbTests ; z++){
                    System.out.println(z);

                    Tabou tabou = new Tabou(n, iterationMax, tabouSize, queens);

                    long timeStart = System.currentTimeMillis();
                    tabou.optimisation();
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

                writer.println(tabouSize + ";" + timeMoy + ";" + iterationMoy + ";" + fitnessMoy);
                System.out.println("");
                System.out.println("");
            }

            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
