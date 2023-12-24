import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithm {

    private int populationSize;
    private double mutationRate;
    private double mutationStrength;

    public GeneticAlgorithm(int populationSize, double mutationRate, double mutationStrength) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.mutationStrength = mutationStrength;
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



    // check if this is working correctly
    private Player crossoverIndividuals(Player parent1, Player parent2) {
        Player child = new Player(parent1.getGenes().length);
        Random random = new Random();
        int crossoverPoint = random.nextInt(parent1.getGenes().length);
        for (int i = 0; i < crossoverPoint; i++) {
            child.getGenes()[i] = parent1.getGenes()[i];
        }
        for (int i = crossoverPoint; i < parent2.getGenes().length; i++) {
            child.getGenes()[i] = parent2.getGenes()[i];
        }
        return child;
    }


    public void mutate(Player[] population) {
        Random random = new Random();
        for (Player player : population) {
            for (int i = 0; i < player.getGenes().length; i++) {
                if (random.nextDouble() < mutationRate) {
                    double mutation = random.nextGaussian() * mutationStrength;
                    double newValue = player.getGenes()[i] + mutation;

                    // Ensure the new value is within the range [-2, 2]
                    newValue = Math.max(-2, Math.min(2, newValue));

                    player.getGenes()[i] = newValue;
                }
            }
        }
    }


}
