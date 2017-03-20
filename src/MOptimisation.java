import java.util.ArrayList;

/**
 * Created by menros on 15/03/17.
 */
public abstract class MOptimisation {
    private int size;
    private int iteration;
    private int iterationMax;
    private ArrayList<Integer> queens;
    private int fMin;
    private ArrayList<Integer> qMin;

    public int getIteration() {
        return iteration;
    }

    public int getfMin() {
        return fMin;
    }

    public ArrayList<Integer> getqMin() {
        return qMin;
    }

    public MOptimisation(ArrayList<Integer> queens) {
        this(8,50, queens);
    }

    public MOptimisation(int size, int iterationMax, ArrayList<Integer> queens) {
        this.size = size;
        this.iteration = 0;
        this.iterationMax = iterationMax;
        this.queens = queens;
        this.fMin = this.fitness();
        this.qMin = this.queens;
    }

    private int fitness(){
        return fitness(this.queens);
    }

    private int fitness(ArrayList<Integer> a){
        int f = 0;
        for (int i = 0; i < this.size; i++){
            for (int j = i+1; j < this.size; j++){
                if (Math.abs(i - j) == Math.abs(a.get(i) - a.get(j)))
                    f++;
            }
        }
        return f;
    }

    private ArrayList<ArrayList<Integer>> voisins(){
        ArrayList<ArrayList<Integer>> vois = new ArrayList<>();

        for (int i = 0; i < this.size; i++){
            for (int j = i+1; j < this.size; j++){
                vois.add(voisin(i,j));
            }
        }

        return vois;
    }

    private ArrayList<Integer> voisin(int i, int j){
        ArrayList<Integer> v = queens;
        v.set(i, queens.get(j));
        v.set(i, queens.get(j));
        return v;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getIterationMax() {
        return iterationMax;
    }

    public void setIterationMax(int iterationMax) {
        this.iterationMax = iterationMax;
    }

    public ArrayList<Integer> getQueens() {
        return queens;
    }

    public void setQueens(ArrayList<Integer> queens) {
        this.queens = queens;
    }

    public void setfMin(int fMin) {
        this.fMin = fMin;
    }

    public void setqMin(ArrayList<Integer> qMin) {
        this.qMin = qMin;
    }

    public void optimisation(){

    }

}
