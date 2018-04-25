package bytestream;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("./dukai/demo/data.txt"));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("./dukai/demo/test.txt"));
//        dataOutputStream.writeBoolean(true);
//        dataOutputStream.writeInt(12);
//        dataOutputStream.writeInt(11);
//        dataOutputStream.writeBoolean(false);
//        dataOutputStream.writeDouble(12.5);
        dataOutputStream.writeUTF("hehe");
        dataOutputStream.close();
//        int read;
//        while ((read = dataInputStream.read()) != -1) {
//            System.out.println(read);
//        }
//        System.out.println(dataInputStream.readInt());
//        System.out.println(dataInputStream.readInt());
//        System.out.println(dataInputStream.readBoolean());
//        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());

        dataInputStream.close();


    }

}
