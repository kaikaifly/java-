import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("./dukai/demo/test1.txt"));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("./dukai/demo/data.txt"));
//        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeInt(12);
        dataOutputStream.writeDouble(14.6);

        boolean b = dataInputStream.readBoolean();
        int i = dataInputStream.readInt();
        double v = dataInputStream.readDouble();
        System.out.println("i: " + i + "v: " + v);

    }

}
