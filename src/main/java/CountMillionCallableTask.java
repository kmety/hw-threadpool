import java.util.concurrent.Callable;

public class CountMillionCallableTask implements Callable<Integer> {
    private MillionList millionList;

    public CountMillionCallableTask(MillionList millionList) {
        this.millionList = millionList;
    }

    @Override
    public Integer call() throws Exception {
        return millionList.getIntegers().stream().mapToInt(Integer::intValue).sum();
    }
}
