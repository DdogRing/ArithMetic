package temp;

import java.util.Arrays;

/**
 * @author DdogRing
 */
public class QuickSort {
    public static void main(String[] args) {

        Integer[] is = {9,1,2,5,7,4,8,6,3,5};
        sort(is);
        Arrays.stream(is).forEach(a -> System.out.print(a + "\t"));
    }

    public static void sort(Integer[] is){

        int lo = 0;
        int hi = is.length - 1;
        sort(is,lo,hi);
    }

    public static void sort(Integer[] is,int lo,int hi){

        if(lo >= hi){
            return;
        }

        // 分组
        int group = group(is, lo, hi);

        sort(is,lo,group - 1);
        sort(is,group + 1,hi);
    }

    public static int group(Integer[] is,int lo,int hi){

        // 找初始值/分界值
        int value = is[lo];

        // 定义左指针
        int left = lo;

        // 定义右指针
        int right = hi + 1;

        while(true){

            while(compare(is[--right],value)){
                if (right == lo){
                    break;
                }
            }

            while(compare(value,is[++left])){
                if (left == hi){
                    break;
                }
            }

            if(left >= right){
                break;
            }else {
                exchange(is,left,right);
            }
        }

        exchange(is,lo,right);
        return right;
    }


    /**
     * 比较大小方法
     * 返回true说明a > b，返回false说明a < b
     * @param a
     * @param b
     * @return a.compareTo(b) > 0
     */
    public static boolean compare(Integer a,Integer b){

        return a.compareTo(b) > 0;
    }

    /**
     * 交换数组元素位置方法
     * @param is
     * @param indexA
     * @param indexB
     */
    public static void exchange(Integer[] is,Integer indexA,Integer indexB){

        Integer temp = is[indexA];
        is[indexA] = is[indexB];
        is[indexB] = temp;
    }
}
