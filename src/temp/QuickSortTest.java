package temp;


import java.util.Arrays;

/**
 * @author DdogRing
 */
public class QuickSortTest {


    public void qucikTest(){

        Integer[] is = {24,6,83,1,99,8,23,1,36,7,2,15,12};

        sort(is);

        Arrays.stream(is).forEach(a -> System.out.print(a + "\t"));

    }

    public static void sort(Integer[] is){

        int lo = 0;
        int hi = is.length - 1;

        sort(is,lo,hi);
    }

    public static void sort(Integer[] is,Integer lo,Integer hi){

        if(lo >= hi){
            return;
        }

        int group = group(is,lo,hi);

        sort(is,lo,group - 1);
        sort(is,group + 1,hi);
    }


    public static int group(Integer[] is,Integer lo,Integer hi){

        int value = is[lo];

        int left = lo;

        int right = hi + 1;

        while(true){

            while(compare(value,is[--right])){

                if (lo == right){
                    break;
                }
            }

            while(compare(is[++left],value)){

                if (left == hi){
                    break;
                }
            }

            if (left >= right){
                break;
            }else {
                exchange(is,left,right);
            }
        }

        exchange(is,lo,right);
        return right;
    }

    public static boolean compare(Integer a,Integer b){
        return a.compareTo(b) < 0;
    }

    public static void exchange(Integer[] is,Integer indexA,Integer indexB){
        Integer temp = is[indexA];
        is[indexA] = is[indexB];
        is[indexB] = temp;
    }
}
