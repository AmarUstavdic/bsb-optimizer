import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameManager {


    public GameManager() {

    }


    public ArrayList<String> runGames(int n, Player[] population) {

        String[] command = {"java", "-jar", "Game.jar", "-gui=false", "Player1", "Player2", "Player3", "Player4"};

        ArrayList<String> results = new ArrayList<String>(n);
        ArrayList<Thread> threads = new ArrayList<>(n);

        int index = 0;
        int nPlayers = 4;
        int playerNumber = 0;
        String fileName = "data.csv";
        for (int i = 0; i < n; i++) {
            while (playerNumber++ < nPlayers) {
                population[index].writeGenesToFile(fileName,"/home/lilwizzz/Desktop/optimizer/Player" + playerNumber);
            }
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
            Process process = null;
            try {
                process = processBuilder.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            threads.add(Thread.ofVirtual().start(new GameResult(process,results)));
            playerNumber = 0;

            // block till files are deleted by players (meaning they have taken their values)
            //waitForFileToNotExist("/home/lilwizzz/Desktop/optimizer");
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return results;
    }


    public void waitForFileToNotExist(String gameRoot) {
        File f1 = new File(gameRoot + "/Player1/data.csv");
        File f2 = new File(gameRoot + "/Player2/data.csv");
        File f3 = new File(gameRoot + "/Player3/data.csv");
        File f4 = new File(gameRoot + "/Player4/data.csv");

        while (f1.exists() && f2.exists() && f3.exists() && f4.exists()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Files no longer exist. Starting next game!");
    }

}
