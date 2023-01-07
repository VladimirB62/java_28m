import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testgetFibonacciList() {
        List<Integer> list10 = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        List<Integer> list5 = List.of(0, 1, 1, 2, 3);
        List<Integer> list0 = List.of();
        List<Integer> list1 = List.of(0);

        Assertions.assertAll(
                () -> {
                    Assertions.assertIterableEquals(list10, Main.getFibonacciList(10));
                },
                () -> {
                    Assertions.assertIterableEquals(list5, Main.getFibonacciList(5));
                },
                () -> {
                    Assertions.assertIterableEquals(list1, Main.getFibonacciList(1));
                },
                () -> {
                    Assertions.assertIterableEquals(list0, Main.getFibonacciList(0));
                },
                () -> {
                    Assertions.assertIterableEquals(list0, Main.getFibonacciList(-10));
                },
                () -> {
                    int k = 12;
                    List<Integer> fibonacciList = Main.getFibonacciList(k);
                    boolean flag = true;
                    for (int i = 2; i < fibonacciList.size() && flag; i++) {
                        flag = fibonacciList.get(i) == fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
                    }
                    Assertions.assertTrue(flag);
                });

    }

        @Test
        public void testGetFibonacciListWithGenerate() {
            List<Integer> list10 = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
            List<Integer> list5 = List.of(0, 1, 1, 2, 3);
            List<Integer> list0 = List.of();
            List<Integer> list1 = List.of(0);

            Assertions.assertAll(
                    ()->{Assertions.assertIterableEquals(list10,Main.getFibonacciListWithGenerate(10));},
                    ()->{Assertions.assertIterableEquals(list5,Main.getFibonacciListWithGenerate(5));},
                    ()->{Assertions.assertIterableEquals(list1,Main.getFibonacciListWithGenerate(1));},
                    ()->{Assertions.assertIterableEquals(list0,Main.getFibonacciListWithGenerate(0));},
                    ()->{Assertions.assertIterableEquals(list0,Main.getFibonacciListWithGenerate(-10));},
                    ()->{
                        int k=12;
                        List<Integer> fibonacciList = Main.getFibonacciListWithGenerate(k);
                        boolean flag = true;
                        for (int i=2; i<fibonacciList.size()&&flag; i++){
                            flag = fibonacciList.get(i) == fibonacciList.get(i-1)+fibonacciList.get(i-2);
                        }
                        Assertions.assertTrue(flag);
                    });
    }

}