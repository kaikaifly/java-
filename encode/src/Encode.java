import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Encode {
    //[Unicode 和 UTF-8 有何区别？](https://www.zhihu.com/question/23374078 "Unicode 和 UTF-8 有何区别？")
    //[字符编码笔记：ASCII，Unicode 和 UTF-8](http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html)
    //[Java 语言中一个字符占几个字节？](https://www.zhihu.com/question/27562173)

    public static void main(String[] args) throws UnsupportedEncodingException {

        String string = "严";

        byte[] bytes = string.getBytes();//编辑器默认编码格式UTF-8
        byte[] bytes_16 = string.getBytes("UTF-16");
        byte[] bytes_16BE = string.getBytes("UTF-16BE");
        byte[] bytes_16LE = string.getBytes("UTF-16LE");

        int length = bytes.length; //length = 3
        int length_16 = bytes_16.length; //length = 4
        int length1_16BE = bytes_16BE.length;//length = 2
        int length2_16LE = bytes_16LE.length;//length = 2

        System.out.println("length: " + length);
        System.out.println("bytes: " + binary(bytes, 2));

        System.out.println("length_16: " + length_16);
        System.out.println("bytes_16: " + binary(bytes_16, 2));

        System.out.println("length1_16BE: " + length1_16BE);
        System.out.println("bytes_16BE: " + binary(bytes_16BE, 2));

        System.out.println("length2_16LE: " + length2_16LE);
        System.out.println("bytes_16LE: " + binary(bytes_16LE, 2));


        String ss = new String("严".getBytes());
        System.out.println(Integer.toBinaryString(ss.charAt(0)));
        char c = '严';
        System.out.println(Integer.toBinaryString(c));

        //“严” 的UTF-8 编码是11100100 10111000 10100101
        //char的默认编码为UTF-16LE
        //进行编码时，因为 UTF-16 编码方式本身未指定字节顺序标记，所以默认使用 Big Endian 字节顺序编码，并将 Big Endian 字节顺序标记写入到流中，所以流前面多了2个字节的高字节作顺序标记
        //进行编码时，UTF-16BE 和 UTF-16LE charset 不会将字节顺序标记写入到流中即它们所编出的码每个字符只占二个字节，要注意的是解码时要使用同样的编码方式，不然会出现问题乱码
    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }
}