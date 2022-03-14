package callableYFuture;

import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> callable = ()->{
            Thread.sleep(2000);
          return String.valueOf((int)(Math.random()*1000)+1);
        };

        List<Future> futures = List.of(
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable),
                                    executor.submit(callable));

        executor.shutdown();
        futures.forEach(v-> {
            try {
                System.out.println(v.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
