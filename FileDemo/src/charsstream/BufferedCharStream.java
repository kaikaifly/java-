package charsstream;

import java.io.*;

public class BufferedCharStream {
    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("java.txt");
            FileOutputStream fos = new FileOutputStream("java_new_buff.txt");

            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");

            BufferedReader br = new BufferedReader(reader);
//             BufferedWriter bw = new BufferedWriter(writer);
            // PrintWriter和BufferedWriter用法类似
            // PrintWriter可以输出换行符
            // 构造方法PrintWriter(Writer out,boolean autoFlush) 里可以设置缓冲区自动输出，这样就不需要手动调用flush方法了。
            PrintWriter pw = new PrintWriter(writer, true);

            String input;
            while ((input = br.readLine()) != null) { // BufferedReader可以按行读取
//                 bw.write(input); //
                // BufferedWriter的writer方法是带有缓冲区的，此时打印的文本是不带换行符的
                pw.println(input);// PrintWriter的println方法支持不同平台的换行符输出
            }

//             bw.flush(); // 强制输出缓冲区内容。如果不加上flush，最后的缓冲区未读满将不输出内容

//             bw.close();
            pw.close();// 按顺序关闭流
            writer.close();
            fos.close();

            br.close();
            reader.close();
            fis.close();

            System.out.println("done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
