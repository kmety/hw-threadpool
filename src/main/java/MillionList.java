import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MillionList {
    private List<Integer> integers = new ArrayList<>();

    public MillionList() {
        Random random = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            integers.add(random.nextInt(100));
        }
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}
