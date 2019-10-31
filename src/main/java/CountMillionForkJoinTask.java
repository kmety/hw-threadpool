import java.util.concurrent.RecursiveTask;

public class CountMillionForkJoinTask extends RecursiveTask<Integer> {
    private MillionList millionList;

    public CountMillionForkJoinTask(MillionList millionList) {
        this.millionList = millionList;
    }

    @Override
    protected Integer compute() {
        return millionList.getIntegers().stream().mapToInt(Integer::intValue).sum();
    }
}
