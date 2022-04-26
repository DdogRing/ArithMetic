import java.util.Arrays;

/**
 * @author DdogRing
 */
public class ShellTest {
    public static void main(String[] args) {

        Integer[] is = {24,6,83,1,99,8,23,1,36,7,2,15,12};

        int h = 1;
        while(h < is.length / 2){
            h = 2 * h + 1;
        }

        while(h >= 1){

            for (int i = h; i < is.length; i++) {

                for (int j = i; j >= h; j-=h) {

                    if (is[j] < is[j - h]){
                        Integer temp = is[j];
                        is[j] = is[j - h];
                        is[j - h] = temp;
                    }else {
                        break;
                    }
                }
            }
            h = h / 2;
        }

        Arrays.stream(is).forEach(a -> System.out.print(a + " "));
    }
}
