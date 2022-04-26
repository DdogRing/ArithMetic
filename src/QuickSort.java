

import java.util.Arrays;

/**
 * @author DdogRing
 */
public class QuickSort {

    public void quicktest(){
        Integer[] is = {24,6,83,1,99,8,23,1,36,7,2,15,12};

        sort(is);

        Arrays.stream(is).forEach(a -> System.out.print(a + " "));

    }

    // 排序方法
    public static void sort(Integer[] is){
        int lo = 0;
        int hi = is.length - 1;
        sort(is,lo,hi);
    }

    public static void sort(Integer[] is,int lo,int hi){
        // 如果右边界小于等于左边界了 直接return
        if(hi <= lo){
            return;
        }
        int group = group(is,lo,hi);

        sort(is,group + 1,hi);
        sort(is,lo,group - 1);
    }

    public static int group(Integer[] is,int lo,int hi){

        // 确认分界值
        Integer value = is[lo];

        // 定义两个指针，分别指向最小索引和最大索引+1
        int left = lo;
        int right = hi + 1;

        while(true){

            // 先从右往左扫描移动right指针，找到一个比分界值小的元素停止
            while(compareLess(value,is[--right])){
                if (right == lo){
                    break;
                }
            }
            // 再从左往右扫描移动left指针，找到一个比分界值大的元素停止
            while(compareLess(is[++left],value)){
                if(left == hi){
                    break;
                }
            }

            // 判断left >= right ,如果是则证明元素扫描完毕,结束循环;如果不是,交换位置

            if(left >= right){
                break;
            }else {
                exchange(is,left,right);
            }
        }

        // 交换分界值下标的元素和
        exchange(is,lo,right);

        return right;
    }

    // 比较方法
    public static boolean compareLess(Integer a,Integer b){

        return a.compareTo(b) < 0;
    }

    // 交换方法
    public static void exchange(Integer[] is,Integer indexA,Integer indexB){

        Integer temp = is[indexA];
        is[indexA] = is[indexB];
        is[indexB] = temp;
    }
}
