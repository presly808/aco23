package exclude.asynch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by serhii on 17.02.18.
 */
public class TestAsyncCode {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {


        System.out.println("BEGIN");
        CompletableFuture.runAsync(() -> {
            try (PrintWriter printWriter = new PrintWriter("test.txt")) {
                Thread.sleep(1000);
                printWriter.flush();
                System.out.println("WRITE");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> {
            try {
                System.out.println("TEST");
                Files.copy(new File("test.txt").toPath(), new File("testc.txt").toPath());
                System.out.println("COPY");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });




        System.out.println("Next logic");


    }
}
