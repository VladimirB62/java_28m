import java.util.List;

public class Main11_MaxInList {
    public static void main(String[] args) {
        List<String> str = List.of("ab","ad","aa","az");
        System.out.println(max(str));
        List<Integer> ints = List.of(1,5,3,2,19);
        System.out.println(max(ints));
    }

    public static <T extends Comparable<T>> T max (List<T> list) {
        T max = null;
        for (T s:list) {
            if((max==null)||(s.compareTo(max)>0)){
                max = s;
            }
        }
        return max;
    }
}
