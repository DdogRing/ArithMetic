/**
 * @author DdogRing
 * 归并排序
 */
public class Merge {

    // 归并所需要的辅助数据
    private static Comparable[] assist;

    /*
        比较v元素是否小于w元素
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    /*
        数组元素i和j交换位置
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /*
        对数组a中的元素进行排序
     */
    public static void sort(Comparable[] a){
        // 1、初始化辅助数组
        assist = new Comparable[a.length];
        // 2、定义一个lo变量和hi变量，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length - 1;
        // 3、调用sort重载方法完成数组a中从索引lo到索引hi的元素的排序
        sort(a,lo,hi);
    }

    /*
        对数组a中从lo到hi的元素进行排序
     */
    private static void sort(Comparable[] a,int lo,int hi){
        // 做安全性校验
        if (hi <= lo){
            return;
        }

        // 对lo到hi之间的数据进行分为两组
        int mid = lo + (hi - lo) >> 1;

        // 分别对每一组数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        // 再把两个组中的数据进行归并
        merge(a,lo,mid,hi);
    }

    /*
        对数组中，从lo到mid为一组，从mid+1到hi位一组，对这两组数据进行归并
     */
    private static void merge(Comparable[] a,int lo,int mid,int hi){

    }
}
