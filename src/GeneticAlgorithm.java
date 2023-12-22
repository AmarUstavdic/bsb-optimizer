public class GeneticAlgorithm {

    private int populationSize;
    private double mutationRate;

    public GeneticAlgorithm(int populationSize, double mutationRate) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
    }

    public Player[] initializePopulation(int genesLength) {
        Player[] population = new Player[populationSize];
        for (int i = 0; i < populationSize; i++) {
            double[] genes = new double[genesLength];
            for (int j = 0; j < genesLength; j++) {
                genes[j] = Math.random() * 4 - 2;
            }
            population[i] = new Player(genes);
        }
        return population;
    }



    public Player[] selectParents(Player[] population) {


        return null;
    }


    public Player[] crossover(Player[] parents) {


        return null;
    }


    private Player crossoverIndividuals(Player parent1, Player parent2) {

        return null;
    }


    public void mutate(Player[] population) {

    }

}
