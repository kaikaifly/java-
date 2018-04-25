package bytestream;

import java.io.*;

public class ByteArrayStreamTest {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "hehe".getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int read;
        while ((read = byteArrayInputStream.read()) != -1) {
            System.out.println((char) read);
        }


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.writeTo(new FileOutputStream("./dukai/demo/array.txt"));//写入文件

        byteArrayInputStream.close();
        byteArrayOutputStream.close();
    }
}
