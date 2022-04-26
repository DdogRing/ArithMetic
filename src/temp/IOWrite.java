package temp;

import java.io.*;

/**
 * @author DdogRing
 */
public class IOWrite {
    public static void main(String[] args) {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\IDEA_Projects\\ArithMetic\\src\\temp\\两百个数倒序.txt")));

            byte[] b = new byte[1024 * 1024];
            for (Integer i = 200; i >= 1; i--) {

                bw.write(i.toString() + "\n");
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
