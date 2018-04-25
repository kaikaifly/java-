package charsstream;

import java.io.*;

public class CharStream {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("java.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("java_new.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

            int length;
            char[] bytes = new char[1024];
            while ((length = inputStreamReader.read(bytes)) != -1) {
                outputStreamWriter.write(bytes);
            }

            inputStreamReader.close();
            fileInputStream.close();
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
