package temp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author DdogRing
 */
public class IOReader {

    public static void main(String[] args) throws Exception{

        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(IOReader.class.getClassLoader().getResourceAsStream("temp/一百万个数倒序.txt")));

        String line = null;
        while((line = br.readLine()) != null){
            Integer i = Integer.valueOf(line);
            arrayList.add(i);
        }

        br.close();

        Integer[] integers = new Integer[arrayList.size()];
        arrayList.toArray(integers);

        /*Arrays.stream(integers).forEach(System.out::println);*/

        // compareQ(integers);
        // compareS(integers);
        compare(integers);
        // compareB(integers);
    }

    public static void compareS(Integer[] is) throws InterruptedException {

        long begin = System.currentTimeMillis();
        ShellSort.sort(is);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
        // Arrays.stream(is).forEach(a -> System.out.println(a));
    }

    public static void compareQ(Integer[] is) throws InterruptedException {

        long begin = System.currentTimeMillis();
        QuickSort.sort(is);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
        Thread.sleep(1000000);
    }

    public static void compare(Integer[] is){

        long begin = System.currentTimeMillis();
        Arrays.sort(is);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }

    public static void compareB(Integer[] is){
        long begin = System.currentTimeMillis();
        BubbleSort.sort(is);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
    }
}
