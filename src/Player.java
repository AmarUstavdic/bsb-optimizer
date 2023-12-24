import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Player {

    private final Stats stats;
    private final double[] genes;
    private double fitness;

    public Player(double[] genes) {
        this.genes = genes;
        this.stats = new Stats();
    }

    public Player(int genesLength) {
        this.genes = new double[genesLength];
        this.stats = new Stats();
    }


    /**
     *  Creates new file every time and writes genes to it.
     */
    public void writeGenesToFile(String fileName, String dirPath) {
        try {
            File file = new File(dirPath, fileName);
            FileWriter writer = new FileWriter(file);
            for (double gene : genes) {
                writer.write(String.valueOf(gene));
                writer.write(", ");
            }
            writer.close();
            //System.out.println("data.csv file created and genes written to it");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateFitness() {
        fitness += (double) stats.getTotalTroopsGenerated() / stats.getTurnsPlayed();
        fitness += (stats.isSurvive() ? 1 : 0.0);
        fitness += stats.getPlanetsConquered();
    }

    public double getFitness() {
        return fitness;
    }

    public double[] getGenes() {
        return genes;
    }

    public Stats getStats() {
        return stats;
    }
}
