import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Player {

    private final Stats stats;
    private double[] genes;
    private double fitness;

    public Player(double[] genes) {
        this.genes = genes;
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
            System.out.println("data.csv file created and genes written to it");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stats getStats() {
        return stats;
    }
}
