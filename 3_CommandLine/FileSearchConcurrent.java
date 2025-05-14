import java.io.*;
import java.util.concurrent.*;
import java.util.*;

public class FileSearchConcurrent {

    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            System.out.println("Usage: java FileSearchConcurrent <directory-path> <search-text>");
            return;
        }

        File rootDir = new File(args[0]);
        String searchText = args[1];

        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("Invalid directory: " + args[0]);
            return;
        }

        List<Future<?>> tasks = new ArrayList<>();
        traverseDirectory(rootDir, searchText, tasks);

        for (Future<?> task : tasks) {
            try {
                task.get(); // wait for task to finish
            } catch (ExecutionException e) {
                System.err.println("Error processing file: " + e.getCause());
            }
        }

        executor.shutdown();
    }

    private static void traverseDirectory(File dir, String searchText, List<Future<?>> tasks) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                traverseDirectory(file, searchText, tasks);
            } else {
                tasks.add(executor.submit(() -> processFile(file, searchText)));
            }
        }
    }

    private static void processFile(File file, String searchText) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, searchText);
            }
            if (count > 0) {
                System.out.println("File: " + file.getAbsolutePath() + " | Occurrences: " + count);
            }
        } catch (IOException e) {
            System.err.println("Could not read file: " + file.getAbsolutePath());
        }
    }

    private static int countOccurrences(String line, String searchText) {
        int count = 0, index = 0;
        while ((index = line.indexOf(searchText, index)) != -1) {
            count++;
            index += searchText.length();
        }
        return count;
    }
}
