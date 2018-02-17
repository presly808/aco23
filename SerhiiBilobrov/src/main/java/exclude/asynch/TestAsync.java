package exclude.asynch;

import sun.awt.windows.ThemeReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by serhii on 17.02.18.
 */
public class TestAsync {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Test");
            return "Test";
        }).thenRun(() -> {
            System.out.println("After");
        });


        System.out.println("After completableFuture");

        Thread.sleep(3000);


    }
}
