package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("./dukai/demo/test1.txt");
        FileOutputStream fos = new FileOutputStream("./dukai/demo/test2.txt", false);//文件不存在会创建
        //逐个读取
//        int read;
//        while ((read = fis.read()) != -1) {
//            System.out.println(read);
//        }
//
//        //按字节数组读取
//        int length;
//        byte[] bytes = new byte[1024];
//        while ((length = fis.read(bytes)) != -1) {
//            System.out.println(new String(bytes, 0, length));
//        }
//        fis.close();

        //将字节数组写入文件
//        byte[] bytes1 = "测试字符123abc".getBytes();
//        fos.write(bytes1);
//        fos.close();


        //实现文件复制
        int length1;
        byte[] bytes2 = new byte[2];
        while ((length1 = fis.read(bytes2)) != -1) {
            fos.write(bytes2);
        }
        fis.close();
        fos.close();
    }
}
