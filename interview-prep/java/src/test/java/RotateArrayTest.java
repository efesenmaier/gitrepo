import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Test
public class RotateArrayTest {
    public void test() {
        test(asArray( 1, 2, 3), 0, asArray(1, 2, 3));
        test(asArray( 1, 2, 3), 1, asArray(3, 1, 2));
        test(asArray( 1, 2, 3), 2, asArray(2, 3, 1));
        test(asArray( 1, 2, 3), 3, asArray(1, 2, 3));

        test(asArray( 1, 2, 3), -1, asArray(2, 3, 1));
        test(asArray( 1, 2, 3), -2, asArray(3, 1, 2));
        test(asArray( 1, 2, 3), -3, asArray(1, 2, 3));
    }

    private void test(int[] arr, int k, int[] expected) {
        RotateArray.rotate(arr, k);
        List<Integer> rotated = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> expectedBoxed = Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList());

        Assert.assertEquals(rotated, expectedBoxed);
    }

    private int[] asArray(int...vals) {
        return vals;
    }
}
