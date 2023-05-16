package com.test;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DemoTest2_file {

    private static int n;

    public static void main(String[] args) throws IOException {
        byte[] data = "hello, world!".getBytes(StandardCharsets.UTF_8);
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char) n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }

    static class CountInputStream extends FilterInputStream {
        private int count = 0;

        CountInputStream(InputStream in) {
            super(in);
        }

        public int getBytesRead() {
            return this.count;
        }

        public int read() throws IOException {
            int n = in.read();
            if (n != -1) {
                this.count++;
            }
            return n;

        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int n = in.read(b, off, len);
            if (n != -1) {
                this.count += n;
            }
            return n;
        }
    }


    @Test
    public void test01() throws IOException {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        File file2 = new File(File.separator + "Users" + File.separator + "xxx/IdeaProjects/data-structure-node/00-Test", "dodo.txt");
        boolean newFile = file2.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        } else {
            System.out.println("文件已经被创建");
        }
        File dir = new File(File.separator + "Users" + File.separator + "xxx/IdeaProjects/data-structure-node/00-Test");
        File[] files = dir.listFiles();
        assert files != null;
        Arrays.stream(files).filter(e -> e.isFile()).forEach(System.out::println);
        System.out.println("-----------------dir----------------------");
        Arrays.stream(files).filter(e -> e.isDirectory()).forEach(System.out::println);
        System.out.println("-----------------System.dir---------------");
        //Working directory
        System.out.println(System.getProperty("user.dir"));
        //User account name
        System.out.println(System.getProperty("user.home"));
        printSubFile(dir);
        System.out.println(n);
        long length = file2.length();
    }

    @Test
    public void test02() throws IOException {
        FileReader fr = null;
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + File.separator + "aa.txt");
            if (file.createNewFile()) {
                System.out.println("创建文件成功");
            } else {
                System.out.println("文件已经存在");
            }
            //方法一
//            fr = new FileReader(file);
//            char[] ch = new char[1024];
//            //读取的字节数
//            int len;
//            while ((len = fr.read(ch)) != -1) {
//                String s = new String(ch, 0, len);
//                System.out.println(s);
//            }
            //方法二
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data + " ---- ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }


    @Test
    public void test03() throws IOException {
        try (OutputStream outputStream = Files.newOutputStream(Paths.get("./aa.txt"))) {
            outputStream.write("hellohello".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Test
    public void test04() throws IOException {
//        List<String> xx = Files.readAllLines(Paths.get("xx", "ee.txt"));
//        System.out.println("xxxxx");
//        System.out.println(xx);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ddd = sdf.format(date);
        System.out.println(ddd);
        long l = System.currentTimeMillis();
        String format = sdf.format(l);
        System.out.println(format + "-=----");
        Date date1 = new Date(l);
        System.out.println(date1);
        double x = -123.45;
        assert x >= 0 : "x must >= 0";
        System.out.println(x);
    }


    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            //创造流
            oos = new ObjectOutputStream(new FileOutputStream("object.xx"));
            //制造对象
            oos.writeObject(new String("xx"));

            //刷新操作
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                //3.关闭流
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream来实现
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.xx"));

            Object obj = ois.readObject();
            String str = (String) obj;

            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    @Test
//    public void testRedis() {
//        String name;
//        String age;
//        try (Jedis jedis = new Jedis("127.0.0.1", 6379)) {
//            System.out.println("reds -- > " + jedis.ping());
//            name = jedis.get("name");
//            age = jedis.get("age");
//        }
//        System.out.println("name : " + name + " age : " + age);
//
//
//    }

    private void printSubFile(File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                printSubFile(file);
            } else {
                System.out.println(file);
                n++;
            }
        }
    }

    @Test
    public void testDemo2() {
        char a = 97;
        System.out.println(a);
        System.out.println("================");
        List<Employee> list = EmployeeData.getEmployees();
        Employee employee = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("max salary Employee is -> "+employee);
        System.out.println("=========================");
        HashMap<Integer, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getId, HashMap::new, Collectors.toList()));
        Map<Integer, List<Employee>> collect1 = list.stream().collect(Collectors.groupingBy(Employee::getId));
        System.out.println(collect);
        System.out.println("++++++++++++++++++++++");
        System.out.println(collect1);
        System.out.println("++++++++++++++++++++++");
        String s = JSON.toJSONString(collect);
        System.out.println(s);


    }
    //此时是因为实际上返回的类型可能是Intege也可能是Double或者其他类型，编译器只能确定类型一定是Number的子类， 因此可以吧子类都转化成Number列
    //也就是下面的Nubmer first = p.getFirst();和 Number last = p.getLastI*

    static void add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //
    }

    @Test
    public void testDemo3() {
        char[] arr = new char[]{'a', 'b', 'c', 'd'};
        for (char i : arr) {
            i = 'b';
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 'b';
        }
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void testDemo4() {

        URL resource = this.getClass().getResource("/");
        System.out.println(resource);


        SubPerson person = new SubPerson();
        person.setAge(14);
        person.setOpenid("11213232");
        person.setName("测试A11");
        person.setSubName("sub名字");

        Map<String, Object> map = BeanUtil.beanToMap(person);
        System.out.println(map);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("ket -> " + key + ", value -> " + value);

        }
        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(SubPerson.class);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getPropertyType() + "----");
            System.out.println(propertyDescriptor.getName() + "----");

        }
        URL resource1 = this.getClass().getResource("/test.log");
        System.out.println(resource1.getFile().toString());
        System.out.println(resource1.getPath().toString());
        cn.hutool.core.io.file.FileReader fileReader = new cn.hutool.core.io.file.FileReader("test.log");
        List<String> strings = fileReader.readLines();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("================");
    }


}

