import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Используя стримы сформировать список из N первых  чисел Фибоначи
//getFibonacciList(5) = {0,1,1,2,3}
//getFibonacciList(10) = {0,1,1,2,3,5,8,13,21,34}
//getFibonacciList(0)={}
//getFibonacciList(1) = {0}
//getFibonacciList(-10) = {]
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = Stream.of("x","kjh","kjuhijg","kjghh","t","kjp","v").collect(Collectors.toMap(
                s->s.length(),
                s->s,
                (s1,s2)->s2+"|"+s1
        ));
        System.out.println(map);
    }

    public static List<Integer> getFibonacciList(int n){
        if (n<=0) return List.of();
        return Stream.iterate(new int[]{0,1},arr->new int[]{arr[1],arr[1]+arr[0]})
                .limit(n)
                .map(arr->arr[0])
                .collect(Collectors.toList());
    }

    public static List<Integer> getFibonacciListWithGenerate(int n){
        if (n<=0) return List.of();
        return Stream.generate(
                new Supplier<Integer>() {
                    int n1 = 0;
                    int n2 = 1;
                    @Override
                    public Integer get() {
                        int fib = n1;
                        n1 = n2;
                        n2 += fib;
                        return fib;
                    }
                })
                .limit(n)
                .collect(Collectors.toList());
    }
}
