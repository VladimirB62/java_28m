import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> qwe = getCollections(() -> new HashSet<>(), "11", "777", "qwe");
        Collection<Integer> qwe1 = getCollections(() -> new LinkedList<>(), 3,15,589);
        System.out.println(qwe);
        System.out.println(qwe1);

        ArrayDeque<Integer> arrayDeque = List.of(1, 4, 5, 6, 48, 5).stream()
                .filter(i -> i > 5)
                .map(i->i*2)
                .sorted()
                .limit(2)
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        System.out.println(arrayDeque);
    }

    public static <T> Collection<T> getCollections(Supplier<Collection<T>> supplier, T ... args){
        Collection<T> res = supplier.get();
        res.addAll(Arrays.asList(args));
        return res;
    }
}
