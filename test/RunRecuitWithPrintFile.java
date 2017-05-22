import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Menros on 20/05/2017.
 */
public class RunRecuitWithPrintFile {

    public static void main(String[] args) {
        int NOMBRE_DE_TESTS = 1;
        int NOMBRE_REINES = 200;
        int N1 = NOMBRE_REINES*2;
        int N2 = NOMBRE_REINES*2;
        int TEMPERATURE_INITIALE = 30*NOMBRE_REINES/100;
        int GAMMA = 40;
        ArrayList<Integer> queens;

        queens = new ArrayList<>();
        for (int i = 0; i < NOMBRE_REINES; i++) {
            queens.add(i);
        }
        RecuitSimule recuit;

        long timeStart = 0;
        long timeEnd = 0;

        long timeMoy = 0;
        int iterMoy = 0;
        int fitnessMoy = 0;

        try{
            PrintWriter writer = new PrintWriter("test.csv", "UTF-8");
            writer.println("temperature;temps;iterations;fitness");
            for(int tmp = 1 ; tmp <= 100 ; tmp+=1){
                System.out.println("val : " + tmp);
                TEMPERATURE_INITIALE = tmp;
                for(int c = 0 ; c < NOMBRE_DE_TESTS ; c++){
                    timeStart = System.currentTimeMillis();
                    recuit = new RecuitSimule(NOMBRE_REINES, queens, N1, N2, TEMPERATURE_INITIALE, (double)GAMMA/100);
                    recuit.optimisation();
                    timeEnd = System.currentTimeMillis();
                    timeMoy += (timeEnd - timeStart);
                    iterMoy += recuit.getIteration();
                    fitnessMoy += recuit.getfMin();
                }
                timeMoy = timeMoy/NOMBRE_DE_TESTS;
                iterMoy = iterMoy/NOMBRE_DE_TESTS;
                fitnessMoy = fitnessMoy/NOMBRE_DE_TESTS;

                System.out.println("time : " + timeMoy);
                System.out.println(iterMoy + " itérations");
                System.out.println("fitness : " + fitnessMoy);
                writer.println(TEMPERATURE_INITIALE + ";" + timeMoy + ";" + iterMoy + ";" + fitnessMoy);
                System.out.println("");
            }
            writer.close();
        } catch (IOException e) {
            // do something
        }
    }
}
