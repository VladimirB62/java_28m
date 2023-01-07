import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestMain2 {

    @Test
    public void testAdd2(){
        List<Integer> list = List.of(-1, -2, -3);
        Assertions.assertEquals(-6,Main2.add(list));
    }

    @Test
    public void testAdd1(){
        List<Integer> list = List.of(1, 2, 3,82,25,8);
        Assertions.assertEquals (121,Main2.add(list));

    }

}
