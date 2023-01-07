import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List.of("qwe22","qwe1","qwe4444","qwe333","qwe1","kguhygf")
                .stream()
                .filter(s->s!=null && !s.isEmpty() && s.length()<5)
                .forEach(s-> System.out.println(s));

        Stream.of(1,5,6,9,8,2,-5)
                .filter(i->i>=0)
                .sorted()
                .forEach(i-> System.out.println(i));

        System.out.println("----------------------------------------------------------------");

        List<Integer> qwe = List.of(2,3,4,5,1);
        qwe.parallelStream()
                .filter(i->{
                    System.out.println(" point1:" + i);
                    return i<3;
                } )
                .sorted()
                .map(i->{
                    System.out.println("  point2: " +i);
                    return i*10;
                })
                .forEach(i-> System.out.println("   point3:" +i));
        System.out.println(qwe);


    }
}
