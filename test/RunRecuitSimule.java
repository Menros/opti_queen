import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Menros on 20/05/2017.
 */
public class RunRecuitSimule {
    public static void main(String[] args) {
        int NOMBRE_REINES = 100;
        int N1 = NOMBRE_REINES*2;
        int N2 = NOMBRE_REINES*2;
        int TEMPERATURE_INITIALE = 30*NOMBRE_REINES/100;
        double GAMMA = 0.1;
        int NOMBRE_DE_TESTS = 100;

        ArrayList<Integer> queens = new ArrayList<>();

        for (int i = 0; i < NOMBRE_REINES; i++) {
            queens.add(i);
        }

        System.out.println("-------------- Algorithm Recuit Simulé --------------");

        int fitness = 0;
        long timeStart=0;
        long timeEnd=0;
        long time=0;
        long iter=0;
        for(int z = 0 ; z < NOMBRE_DE_TESTS ; z++){
            RecuitSimule recuit = new RecuitSimule(NOMBRE_REINES, queens, N1, N2, TEMPERATURE_INITIALE, GAMMA);
            System.out.print("Fitness : " + recuit.getfMin());
            timeStart = System.currentTimeMillis();
            recuit.optimisation();
            timeEnd = System.currentTimeMillis();
            System.out.println(" -> " + recuit.getfMin());
            System.out.println(recuit.getIteration() + " itérations");
            System.out.println("");
            fitness+= recuit.getfMin();
            time+=(timeEnd - timeStart);
            iter+= recuit.getIteration();
        }

        Date date = new Date(time/NOMBRE_DE_TESTS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println("Temps d'exécution : " + cal.get(Calendar.MINUTE) + " min " + cal.get(Calendar.SECOND) + " s " + cal.get(Calendar.MILLISECOND) + " ms");

        System.out.println("Fitness : " + fitness/NOMBRE_DE_TESTS);
        System.out.println("Nombre d'itérations : " + iter/NOMBRE_DE_TESTS);
    }
}
