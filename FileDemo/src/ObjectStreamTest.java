import bean.Person;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //(java.io.EOFException异常的解决方法)https://blog.csdn.net/ouyang_peng/article/details/46448877
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./dukai/demo/object.txt", false));
        objectOutputStream.writeObject(new Person("12"));//对象需要实现Serializable序列化
        objectOutputStream.writeObject(new Person("34"));//对象需要实现Serializable序列化
        objectOutputStream.writeObject(null);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./dukai/demo/object.txt"));
        Person person;
        while ((person = (Person) objectInputStream.readObject()) != null) {
            System.out.println(person.getName());
        }

        objectOutputStream.close();
        objectInputStream.close();
    }
}
