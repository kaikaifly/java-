package charsstream;

import java.io.*;

public class FileCharStream {
    public static void main(String[] args) {
        {
            try {
                FileReader fileReader = new FileReader("java.txt");
                FileWriter fileWriter = new FileWriter("java_new_file.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    printWriter.println(s);
                }

                bufferedReader.close();
                fileReader.close();
                printWriter.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
