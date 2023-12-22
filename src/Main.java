import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {

        int concurrentGames = 2;
        int populationSize = concurrentGames * 4;
        double mutationRate = 0.1;
        int generations = 50;

        GameManager gameManager = new GameManager();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(populationSize, mutationRate);

        // it is better to initialize weights and biases here
        // then we need to just write them to files before starting games (easy)
        // we do not have to parse them from subprocesses of subprocess (which is much harder to do)
        Player[] population = geneticAlgorithm.initializePopulation(541);


        for (int i = 0; i < generations; i++) {

            ArrayList<String> results = gameManager.runGames(2, population);
            results.forEach(System.out::println);
            // here we get game results

            // we need to parse those results to our population

            // then we need to calculate fitness of each player based on previous stats

            // then we perform selection of parents
            Player[] parents = geneticAlgorithm.selectParents(population);

            // then we fill the rest of the population with offsprings
            Player[] offspring = geneticAlgorithm.crossover(parents);

            // here we perform mutation
            geneticAlgorithm.mutate(offspring);


            // and we replace old population with the new one
            System.arraycopy(offspring, 0, population, parents.length, offspring.length);

        }

    }

}