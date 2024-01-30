import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of(1, 1, 2, 3, 5)
                .parallel().count();
    }
}
