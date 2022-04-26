

import java.util.Arrays;

/**
 * 希尔排序
 * @author DdogRing
 *
 */

/*
    增长量h的确定：增长量h的值确定的规则：
        int h = 1;
        while(h < (数组.length / 2)){
            h = 2 * h + 1;
        }
        while循环结束后可以确定h的最大值
        h的减小规则为：
            h = h / 2;

 */
public class Shell {

    /*
        对数组a中的元素进行排序
     */
    public static void sort(Integer[] a){

        //1、根据数组a的长度，确定增长量h的值。
        int h = 1;
        while(h < a.length / 2){
            h  = 2 * h + 1;
        }

        //2、希尔排序
        while(h >= 1){
            // 排序
            //2.1、找到待插入的元素
            for (int i = h; i < a.length; i++) {
                //2.2、把待插入的元素插入到有序数列中。
                for (int j = i; j >= h; j-=h) {
                    //待插入的元素是a[j],比较a[j]和a[j-h]
                    if(compare(a[j - h],a[j])){
                        // 大于 交换元素
                        exch(a,j-h,j);
                    }else {
                        // 不大于 待插入元素已经找到了合适的位置，结束循环
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
        }
    }

    /*
        比较元素v是否大于元素w
     */
    public static boolean compare(Integer v,Integer w){
        return v.compareTo(w) > 0;
    }

    /*
        数组元素i和元素j交换位置
     */
    public static void exch(Integer[] a,int indexI,int indexJ){
        Integer temp = a[indexI];
        a[indexI] = a[indexJ];
        a[indexJ] = temp;
    }


    public void test(){
        Integer[] a = {9,1,2,5,7,4,8,6,3,5};
        sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
