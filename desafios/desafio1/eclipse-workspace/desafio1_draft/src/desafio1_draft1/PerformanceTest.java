package desafio1_draft1;

// https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
// https://www.vogella.com/tutorials/JavaPerformance/article.html

import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
    private static final long MEGABYTE = 1024L * 1024L;

    public static double bytesToMegabytes(long bytes) {
        return (double) bytes/ MEGABYTE;
    }

    public static void main(String[] args) {
        // I assume you will know how to create a object Person yourself...
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i <= 100000; i++) {
            list.add(new Person("Jim", "Knopf"));
        }
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is: " + memory + " Bytes");
        System.out.println("Used memory is: "
                + String.format( "%.2f MB" ,bytesToMegabytes(memory)).replace(".", ","));
    }
}