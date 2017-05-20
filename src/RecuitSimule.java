import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Silver on 15-Mar-17.
 */
public class RecuitSimule extends MOptimisation {
    private int maxNbTemperatures;
    private int iterationMaxTemperature;
    private double gamma;
    private double temperature;

    public RecuitSimule(int size, ArrayList<Integer> queens, int mnt, int imt, double temperature){
        this(size, queens, mnt, imt, temperature, 0.95);
    }

    public RecuitSimule(int size, ArrayList<Integer> queens, int mnt, int imt, double temperature, double gamma){
        super(size, mnt*imt, queens);
        this.iterationMaxTemperature = imt;
        this.gamma = gamma;
        this.temperature = temperature;
        this.maxNbTemperatures = mnt;
    }

    public void optimisation(){
        ArrayList<ArrayList<Integer>> voisins;
        ArrayList<Integer> voisin;
        int differenceFitness;
        int fitnessVoisin;
        Random rand = new Random();

        for(int k = 0 ; k <= this.maxNbTemperatures ; k++){
            for(int l = 1 ; l <= this.iterationMaxTemperature ; l++){
                voisin = this.getRandomVoisin();

                fitnessVoisin = this.fitness(voisin);
                differenceFitness = fitnessVoisin - fitness();

                if(differenceFitness <= 0){
                    this.setQueens(voisin);
                    if(fitnessVoisin < this.getfMin()){
                        this.setfMin(fitnessVoisin);
                        this.setqMin(voisin);
                        if(getfMin() == 0) return;
                    }
                }
                else{
                    if(rand.nextInt(1) < Math.exp(-differenceFitness/this.temperature))
                        this.setQueens(voisin);
                    else this.setQueens(this.getQueens());
                }
                this.setIteration(this.getIteration() + 1);
            }
            this.temperature = this.gamma * this.temperature;
        }
    }
}
