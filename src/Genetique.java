import java.util.*;

/**
 * Created by Silver on 21-May-17.
 */
public class Genetique extends MOptimisation {
    int solutionsSize;
    ArrayList<ArrayList<Integer>> solutions;

    int typeSelection;
    int typeCroisement;
    int typeMutation;

    int poidsSelection;
    int poidsCroisement;
    int poidsMutation;

    public Genetique(int size, int iterationMax, ArrayList<ArrayList<Integer>> solutions,
                     int typeSelection, int typeCroisement, int typeMutation,
                     int poidsSelection, int poidsCroisement, int poidsMutation) {
        setSize(size);
        setIteration(0);
        setIterationMax(iterationMax);

        this.solutions = solutions;
        this.solutionsSize = solutions.size();
        this.typeSelection = typeSelection;
        this.typeCroisement = typeCroisement;
        this.typeMutation = typeMutation;
        this.poidsSelection = poidsSelection;
        this.poidsCroisement = poidsCroisement;
        this.poidsMutation = poidsMutation;

        setqMin(solutions.get(0));
        setfMin(fitness(getqMin()));
        setMinGen();
    }

    public void optimisation(){
        if (solutionsSize % (poidsSelection + poidsCroisement + poidsMutation) != 0){
            System.out.println("taille de la liste des solutions non divisible par la somme des poids");
            return;
        }
        do{
            ArrayList<ArrayList<Integer>> newSolutions = new ArrayList<ArrayList<Integer>>();
            switch(typeSelection){
                case 1:
                    newSolutions.addAll(selectionMeilleurs());
                    break;
                case 2:
                    newSolutions.addAll(selectionRandom());
                    break;
            }

            switch(typeCroisement){
                case 1:
                    newSolutions.addAll(croisementSimple(newSolutions));
                    break;
            }

            switch(typeMutation){
                case 1:
                    newSolutions.addAll(mutationSimple(newSolutions));
                    break;
            }
            solutions = newSolutions;
            setMinGen();
            this.setIteration(this.getIteration() + 1);
            System.out.println(getIteration() + " " + solutions.size() + " " + getfMin() + " " + getqMin());

        }while ((this.getIteration() < this.getIterationMax()) && (this.getfMin() > 0));
    }

    public int fitness(ArrayList<Integer> solution){
        int f = 0;
        for (int i = 0; i < this.getSize(); i++){
            for (int j = i+1; j < this.getSize(); j++){
                if (Math.abs(i - j) == Math.abs(solution.get(i) - solution.get(j))
                        || solution.get(i) == solution.get(j)){
                    f++;
                }
            }
        }
        return f;
    }

    public void setMinGen(){
        for (ArrayList<Integer> q : solutions) {
            int fitness = fitness(q);
            if (fitness < getfMin()){
                setqMin(q);
                setfMin(fitness);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> selectionMeilleurs(){
        ArrayList<ArrayList<Integer>> selection = new ArrayList<>();
        ArrayList<Integer> selectionIndices = new ArrayList<>();

        while (selectionIndices.size() < this.solutionsSize * poidsSelection / (poidsSelection + poidsCroisement + poidsMutation) ){

            int indice = 0;
            int fitnessMin = Integer.MAX_VALUE;

            for (int i = 0; i < solutions.size(); i++){
                int fitness = fitness(solutions.get(i));
                if (fitness < fitnessMin && !selectionIndices.contains(i)){
                    indice = i;
                    fitnessMin = fitness;
                }
            }
            selectionIndices.add(indice);

        }
        for (int i : selectionIndices){
            selection.add(this.solutions.get(i));
        }
        return selection;
    }

    public ArrayList<ArrayList<Integer>> selectionRandom(){
        ArrayList<ArrayList<Integer>> selection = new ArrayList<>();
        ArrayList<Integer> selectionIndices = new ArrayList<>();

        while (selectionIndices.size() < this.solutionsSize * poidsSelection / (poidsSelection + poidsCroisement + poidsMutation) ){
            Random random = new Random();
            int indice = random.nextInt(solutionsSize);
            if (!selectionIndices.contains(indice)){
                selectionIndices.add(indice);
            }
        }
        for (int i : selectionIndices){
            selection.add(this.solutions.get(i));
        }
        return selection;
    }

    public ArrayList<ArrayList<Integer>> croisementSimple(ArrayList<ArrayList<Integer>> solutions){
        ArrayList<ArrayList<Integer>> croisement = new ArrayList<>();

        while (croisement.size() < this.solutionsSize * poidsCroisement / (poidsSelection + poidsCroisement + poidsMutation) ){
            Random random = new Random();
            int i = random.nextInt(solutions.size());
            int j = i;
            while (i == j){
                j = random.nextInt(solutions.size());
            }

            int coupure = random.nextInt(this.getSize() - 1) + 1;

            ArrayList<Integer> newSolution = new ArrayList<Integer>();
            for (int k = 0; k < coupure; k++){
                newSolution.add(solutions.get(i).get(k));
            }
            for (int k = coupure; k < this.getSize(); k++){
                newSolution.add(solutions.get(i).get(k));
            }

            croisement.add(newSolution);
        }
        return croisement;
    }

    public ArrayList<ArrayList<Integer>> mutationSimple(ArrayList<ArrayList<Integer>> solutions){
        ArrayList<ArrayList<Integer>> mutation = new ArrayList<>();

        while (mutation.size() < this.solutionsSize * poidsMutation / (poidsSelection + poidsCroisement + poidsMutation) ){
            Random random = new Random();
            ArrayList<Integer> newSolution = new ArrayList<Integer>(solutions.get(random.nextInt(solutions.size())));
            newSolution.set(random.nextInt(this.getSize()), random.nextInt(this.getSize()));
            mutation.add(newSolution);
        }
        return mutation;
    }

}
