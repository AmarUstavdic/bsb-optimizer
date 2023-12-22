import java.util.Arrays;
import java.util.Random;

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
        Arrays.sort(population, (a, b) -> Double.compare(b.getFitness(), a.getFitness()));
        return Arrays.copyOfRange(population, 0, populationSize / 2);
    }


    public Player[] crossover(Player[] parents) {
        Player[] offspring = new Player[populationSize - parents.length];
        Random random = new Random();
        for (int i = 0; i < offspring.length; i++) {
            Player parent1 = parents[random.nextInt(parents.length)];
            Player parent2 = parents[random.nextInt(parents.length)];
            offspring[i] = crossoverIndividuals(parent1, parent2);
        }
        return offspring;
    }


    private Player crossoverIndividuals(Player parent1, Player parent2) {

        return null;
    }


    public void mutate(Player[] population) {

    }

}
