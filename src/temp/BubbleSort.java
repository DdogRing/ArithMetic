package temp;

/**
 *  冒泡排序
 * @author DdogRing
 */
public class BubbleSort {

    public static void sort(Integer[] is) {

        for (int i = 0; i < is.length - 1; i++) {

            int temp = 0;
            for (int j = 0; j < is.length - 1 - i; j++) {

                if (is[j] > is[j + 1]) {
                    temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                }
            }
        }
    }
}
