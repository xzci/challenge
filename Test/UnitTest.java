import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    @Test
    void testCalculateMethod_1() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 20;
        String test = "$7650.0\n5 x 4 $7650.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }

    @Test
    void testCalculateMethod_2() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 11;
        String test = "$4590.0\n" +
                "1 x 3 $1530.0\n" +
                "2 x 4 $3060.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }

    @Test
    void testCalculateMethod_3() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 3;
        String test = "$900.0\n" +
                "1 x 3 $900.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }

    @Test
    void testCalculateMethod_4() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 1;
        String test = "$570.0\n1 x 1 $570.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }

    @Test
    void testCalculateMethod_5() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 203;
        String test = "$78030.0\n" +
                "1 x 3 $1530.0\n" +
                "50 x 4 $76500.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }
    @Test
    void testCalculateMethod_6() {
        Algorithm algorithm = new Algorithm();
        TreeMap<Integer, Double> models = new TreeMap<>();
        models.put(1 , 570.0);
        models.put(3 , 900.0);
        models.put(4, 1530.0);
        Integer target = 12203;
        String test = "$4668030.0\n" +
                "1 x 3 $1530.0\n" +
                "3050 x 4 $4666500.0";

        assertEquals(test, algorithm.calculateWithOutput(models, target));

    }
}
