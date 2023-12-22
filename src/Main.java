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
            int playerNumber = 1;
            int gameNumber = 0;
            int emptyLines = 0;
            int populationIndex = 1;
            String[] tokens;
            for (int j = 0; j < results.size(); j++) {

                if (results.get(j).isEmpty()) emptyLines++;
                if (emptyLines == 4) {
                    gameNumber++;
                    emptyLines = 0;
                }

                tokens = results.get(j).split(": ");
                switch (tokens[0]) {
                    case "STAT":
                        playerNumber = Integer.parseInt(String.valueOf(tokens[1].charAt(tokens[1].length()-1)));
                        populationIndex = gameNumber * 4 + playerNumber - 1;
                        break;
                    case "turnsPlayed":
                        population[populationIndex].getStats().setTurnsPlayed(Integer.parseInt(tokens[1]));
                        break;
                    case "survive":
                        population[populationIndex].getStats().setSurvive(Boolean.parseBoolean(tokens[1]));
                        break;
                    case "fleetGenerated":
                        population[populationIndex].getStats().setFleetGenerated(Integer.parseInt(tokens[1]));
                        break;
                    case "fleetLost":
                        population[populationIndex].getStats().setFleetLost(Integer.parseInt(tokens[1]));
                        break;
                    case "fleetReinforced":
                        population[populationIndex].getStats().setFleetReinforced(Integer.parseInt(tokens[1]));
                        break;
                    case "largestAttack":
                        population[populationIndex].getStats().setLargestAttack(Integer.parseInt(tokens[1]));
                        break;
                    case "largestLoss":
                        population[populationIndex].getStats().setLargestLoss(Integer.parseInt(tokens[1]));
                        break;
                    case "largestReinforcement":
                        population[populationIndex].getStats().setLargestReinforcement(Integer.parseInt(tokens[1]));
                        break;
                    case "planetsLost":
                        population[populationIndex].getStats().setPlanetsLost(Integer.parseInt(tokens[1]));
                        break;
                    case "planetsConquered":
                        population[populationIndex].getStats().setPlanetsConquered(Integer.parseInt(tokens[1]));
                        break;
                    case "planetsDefended":
                        population[populationIndex].getStats().setPlanetsDefended(Integer.parseInt(tokens[1]));
                        break;
                    case "planetsAttacked":
                        population[populationIndex].getStats().setPlanetsAttacked(Integer.parseInt(tokens[1]));
                        break;
                    case "numFleetLost":
                        population[populationIndex].getStats().setNumFleetLost(Integer.parseInt(tokens[1]));
                        break;
                    case "numFleetReinforced":
                        population[populationIndex].getStats().setNumFleetReinforced(Integer.parseInt(tokens[1]));
                        break;
                    case "numFleetGenerated":
                        population[populationIndex].getStats().setNumFleetGenerated(Integer.parseInt(tokens[1]));
                        break;
                    case "totalTroopsGenerated":
                        population[populationIndex].getStats().setTotalTroopsGenerated(Integer.parseInt(tokens[1]));
                        break;
                }
            }


            // then we need to calculate fitness of each player based on previous stats
            for (Player p : population) {
                p.calculateFitness();
            }


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