import com.sun.jndi.toolkit.url.Uri;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Formatter;

public class FileInfoTest {

    public static void main(String[] args) throws IOException {
//        File file = new File("c:/test");
//        File file1 = new File("c:\\test.txt");//这里的第一个反斜杠是作为转义符存在的，第二个才是真正意义上的反斜杠


        //创建文件
//        File file2 = new File("c:/", "test.doc");
//        File file2 = new File(new File("c:/"),"test.doc");
//        File file3 = new File(file2.toURI());
//        if (!file2.exists()) {
//            file2.createNewFile();
//        }

        //创建临时文件
//        File file1 = new File("c://dukai");
//        File msg = File.createTempFile("msg", ".tmp", file1);//msg3895416956522635807.tmp
//        msg.deleteOnExit();//程序运行deleteOnExit成功后，File并没有直接删除，而是在虚拟机正常运行结束后才会删除
        //场景：程序有个需求需要创建临时文件，这个临时文件可能作为存储使用，但是程序运行结束后，这个文件应该就被删除了。
        // 在哪里做删除操作呢，需要监控程序关闭吗，如果有很多地方可以中止程序，这个删除操作需要都放置一份吗？其实只要这么写,程序结束后文件就会被自动删除了：

        //创建目录
//        File file = new File("c:/dukai/test");
//        if (!file.exists()) {
//            file.mkdirs();//创建成功，可以创建多级目录
////            file.mkdir();//创建失败，只能创建一级目录
//        }

        //删除文件
//        File file = new File("c:/dukai/demo/test.txt");
//        if (file.exists() && file.isFile()) {
//            file.delete();
//        }

        //递归删除文件夹下面的子文件和文件夹
//        deleteDirectory("c:/dukai");

        //文件信息
        File file = new File("./dukai/demo" + File.separator + "test1.txt");
        System.out.println("toString = [" + file.toString() + "]");//.\dukai\demo\test1.txt
        System.out.println("toPath = [" + file.toPath() + "]");//.\dukai\demo\test1.txt
        System.out.println("toURI = [" + file.toURI() + "]");//file:/C:/MyWork/ideaProject/FileDemo/./dukai/demo/test1.txt
        System.out.println("toURL = [" + file.toURL() + "]");//file:/C:/MyWork/ideaProject/FileDemo/./dukai/demo/test1.txt
        System.out.println("getParent = [" + file.getParent() + "]");//父路径
        System.out.println("getParentFile = [" + file.getParentFile() + "]");//父路径
        System.out.println("getName = [" + file.getName() + "]");//文件名
        System.out.println("getPath = [" + file.getPath() + "]");//相对路径
        //绝对路径,不会处理“.”和“..”的情况。C:\MyWork\ideaProject\FileDemo\.\dukai\demo\test.txt
        System.out.println("getAbsolutePath = [" + file.getAbsolutePath() + "]");
        //规范化的绝对路径,相当于将getAbsolutePath()中的“.”和“..”解析成对应的正确的路径。C:\MyWork\ideaProject\FileDemo\dukai\demo\test.txt
        System.out.println("getCanonicalPath = [" + file.getCanonicalPath() + "]");
        System.out.println("getFreeSpace = [" + getPrintSize(file.getFreeSpace()) + "]");//返回所在分区的剩余空间
        System.out.println("getTotalSpace = [" + getPrintSize(file.getTotalSpace()) + "]");//返回所在分区的总空间
        System.out.println("getUsableSpace = [" + getPrintSize(file.getUsableSpace()) + "]");//返回所在分区的可用空间，与 getFreeSpace() 相比，此方法能更准确地估计可实际写入的新数据数。
        System.out.println("lastModified = [" + file.lastModified() + "]");//最后修改时间
        System.out.println("length = [" + file.length() + "]");//文件字节长度


//        file.setWritable(false);
//        file.setReadable(false);//没有设置成功，原因未知
//        file.setExecutable(false);//没有设置成功，原因未知

        System.out.println("canExecute = [" + file.canExecute() + "]");
        System.out.println("canRead = [" + file.canRead() + "]");
        System.out.println("canWrite = [" + file.canWrite() + "]");
        System.out.println("isDirectory = [" + file.isDirectory() + "]");
        System.out.println("exists = [" + file.exists() + "]");
        System.out.println("isAbsolute = [" + file.isAbsolute() + "]");//时候是绝对路径
        System.out.println("isHidden = [" + file.isHidden() + "]");//是否是隐藏文件


//        file.renameTo(new File("./src/test.txt"));//所在目录不同则剪切，相同则重命名

//        for (int i = 0; i < File.listRoots().length; i++) {
//            System.out.println("listRoots = [" + File.listRoots()[i] + "]");//返回系统上多有盘符
//        }

//        File file1 = new File("./");//获取该目录下的所有文件名
//        for (int i = 0; i < file1.list().length; i++) {
//            System.out.println("list = [" + file1.list()[i] + "]");
//        }
//
//        File file1 = new File("./");//获取该目录下所有文件和目录的绝对路径
//        for (int i = 0; i < file1.listFiles().length; i++) {
//            System.out.println("list = [" + file1.listFiles()[i] + "]");
//        }
    }

    /**
     * 递归删除文件夹下面的子文件和文件夹
     *
     * @param filePath
     */
    public static void deleteDirectory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File myfile : files) {
                deleteDirectory(filePath + "/" + myfile.getName());
            }

            file.delete();
        }
    }

    /**
     * 转换单位
     *
     * @param size
     * @return
     */
    public static String getPrintSize(long size) {
        long rest = 0;
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size /= 1024;
        }

        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            rest = size % 1024;
            size /= 1024;
        }

        if (size < 1024) {
            size = size * 100;
            return String.valueOf((size / 100)) + "." + String.valueOf((rest * 100 / 1024 % 100)) + "MB";
        } else {
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
        }
    }
}
