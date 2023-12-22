import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameResult implements Runnable {

    private final ArrayList<String> result;
    private final Process process;


    public GameResult(Process process, ArrayList<String> result) {
        this.result = result;
        this.process = process;
    }


    @Override
    public void run() {
        try (InputStream inputStream = process.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            boolean gameStats = false;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("STAT")) gameStats = true;
                if (gameStats) result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
