package temp;

import java.util.Arrays;

/**
 * @author DdogRing
 */
public class ShellSort {

    public void shellTest(){
        Integer[] is = {24,6,83,1,99,8,23,1,36,7,2,15,12};
        sort(is);
        Arrays.stream(is).forEach(a -> System.out.print(a + "\t"));
    }

    // 排序方法
    public static void sort(Integer[] is){

        int h = 1;
        while(h < is.length / 2){
            h = 2 * h + 1;
        }

        while(h >= 1) {
            // 找到待排序元素
            for (int i = h; i < is.length; i++) {

                for (int j = i; j >= h; j -= h) {

                    if(compare(is[j - h],is[j])){
                        exchange(is,j,j - h);
                    }else {
                        break;
                    }
                }
            }
            h = h / 2;
        }

    }

    // 比较方法 true a > b false b < b
    public static boolean compare(Integer a,Integer b){

        return a - b > 0;
    }

    // 交换方法
    public static void exchange(Integer[] is,Integer indexA,Integer indexB){

        Integer temp = is[indexA];
        is[indexA] = is[indexB];
        is[indexB] = temp;
    }

}
