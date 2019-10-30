import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {
    private static final Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        MillionList millionList = new MillionList();
        Callable<Integer> task = new CountMillionCallableTask(millionList);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futureResult = executorService.submit(task);
        try {
            int result = futureResult.get();
            System.out.println("Executor service result is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Task execution failed", e);
        }
        executorService.shutdown();

        CountMillionForkJoinTask forkJoinTask = new CountMillionForkJoinTask(millionList);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        int result = commonPool.invoke(forkJoinTask);
        System.out.println("ForkJoinPool result is: " + result);
        commonPool.shutdown();
    }
}
