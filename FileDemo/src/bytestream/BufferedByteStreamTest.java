package bytestream;

import java.io.*;

public class BufferedByteStreamTest {
    public static void main(String[] args) throws IOException {
        /*
        * 带缓冲的流和不带缓冲的流区别:
        不带缓冲的操作, 每读一个字节就要写入一个字节, 由于涉及磁盘的IO操作相比内存的操作要慢很多, 所以不带缓冲的流效率很低
        带缓冲的流, 可以一次读很多字节, 但不向磁盘中写入, 只是先放到内存里. 等凑够了缓冲区大小的时候一次性写入磁盘, 这种方式可以减少磁盘操作次数, 速度就会提高很多!
        带缓冲的流适合读写比较大的文件.
        */
        FileInputStream fileInputStream = new FileInputStream("./ideaIU-2017.3.5.exe");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,1024*1024);

        FileOutputStream fileOutputStream = new FileOutputStream("./ideaIU-2017.3.5_bak.exe");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream,1024*1024);

        int length;
        int count = 0;
        byte[] bytes = new byte[1024*1024];
        long before = System.currentTimeMillis();
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes);
            count++;
        }

        System.out.println("time = " + (System.currentTimeMillis() - before) + "ms");
        System.out.println("count = " + count + "");

        bufferedInputStream.close();
        bufferedOutputStream.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
