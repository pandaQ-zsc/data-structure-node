package com.test;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author xxx
 */
public class DemoTest {
    public static void main(String[] args) {
        Student s1 = new Student("001", "xiaoming", 20);
        Student s2 = new Student("002", "jjaja", 30);
        Student s3 = new Student("003", "titi", 50);
        Student s5 = new Student("003", "gaga", 24);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s5);
        System.out.println(list);
        Collections.shuffle(list, new Random());
        System.out.println(list);
        list.stream().sorted((i1, i2) -> i1.getAge() - i2.getAge()).forEach(System.out::println);
        Integer reduce = list.stream().map(Student::getAge).reduce(0, Integer::sum);
        String collect = list.stream().map(e -> e.getName()).collect(Collectors.joining("-", "aa", "bb"));
        System.out.println(collect + "===========");
        System.out.println(reduce + " +++++++++++++");
        ArrayList<String> collect1 = list.stream().map(Student::getName).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect1.toString() + "----");
        Spliterator<String> stringSpliterator = collect1.spliterator().trySplit();
        System.out.println(stringSpliterator + "------");
        System.out.println("------------sort-----------------------");
        Map<String, Student> map = list.stream().collect(Collectors.toMap(Student::getStuNum, Function.identity(), (i1, i2) -> i2));
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        System.out.println("--------------------end -------------------------");
//        int duplicate = findDuplicate(new int[]{2, 3, 3, 4});
//        System.out.println(duplicate);
        System.out.println("--------------------end -------------------------");
        Function<Integer, Student> func = Student::new;
        func.apply(30);
        Student student = new Student();
        student.setName("hahaha");
        Supplier<String> sup = student::getName;
//        Function<Integer,String[]> func2 = (len) ->new String[len];
        Function<Integer, String[]> func2 = String[]::new;
        String[] apply = func2.apply(10);
        Arrays.fill(apply, "bb");
        System.out.println(Arrays.toString(apply));
        System.out.println("--------------------end -------------------------");
        //迭代，遍历前10个偶数
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {
//        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //生成，随机数
        //public static<T> Stream<T> generate(Supplier<T> s) {
//        Stream.generate(Math::random).map(e -> e * 100).limit(20).forEach(System.out::println);

    }

    //    @Test
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }


    @Test
    public void test01() {
        List<String> strings = Arrays.asList("alpha", "beta", "gamma");
        String collect3 = strings.stream().distinct().collect(Collectors.joining(","));
// output: alpha,beta,gamma
        System.out.println(collect3);
        String collect4 = strings.stream().map(s -> s + "-").collect(Collectors.joining(",", "[", "]"));
// output: [alpha,beta,gamma]
        System.out.println(collect4);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(DemoTest::fromStringToStream).forEach(s -> {
            s.forEach(System.out::print);
        });
        System.out.println();
        System.out.println("++++++++++++++++++++++");
//        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(DemoTest::fromStringToStream);

        characterStream.forEach(System.out::print);
    }

    public static Stream<Character> fromStringToStream(String str) {//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test03() throws Exception {
//        int[] arr = new int[]{1, 2, 3};
//        try {
//            System.out.println(arr[4]);
//        } catch (Exception e) {
//            throw new Exception("数组越界");
//        } finally {
//            System.out.println("ahahzhadsjahj");
//        }
        int[] arr = new int[]{1, 2, 3, 4, 5};
        String temp = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test2.txt";
        File file2 = new File("hello.txt");//相较于当前工程
        System.out.println(file2.getAbsolutePath());
        System.out.println(temp);
        File file = new File(temp);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("文件创建成功");
        }
        try (BufferedInputStream bin = new BufferedInputStream(Files.newInputStream(new File("src/test.txt").toPath())); BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() throws Exception {
        String[] strArr = new String[]{"as", "s", "xq"};
        Integer[] intArr = new Integer[]{3, 54, 6, 7, 3, 2};
        printArray(strArr);
        printArray(intArr);
        String[] strings = new String[10];
        Object[] objects = Arrays.copyOf(strArr, strings.length);
        try {
            objects[4] = 3;
        } catch (Exception e) {
            throw new RuntimeException("超出数组范围");
        }
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //   0111  7
        //   0011  4
        //   0011

    }

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (left - right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    //[1,3,5,6]
//5
    static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                list.add(i + 1);
            }
        }
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        return 0;
    }


    @Test
    public void test07() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        String format = now.format(dateTimeFormatter);
        System.out.println("format ---- > " + format);
        String str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09

        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter
                .ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 输出 2014-04-13T20:00

    }

    @Test
    public void test05() {
        String[] s = new String[]{"dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A", "ss", "a", "a"};
        List<String> list = Arrays.asList(s);
        System.out.println(list);
        list.sort((String e1, String e2) -> e1.compareTo(e2));
        Collections.reverse(list);
        System.out.println(list);
        
        List<Integer> list1 = Arrays.asList(2, 23, 4, 5, 6, 7, 2);
        System.out.println(list1.stream().mapToInt(x -> x * 2).summaryStatistics().getMax());
        List<String> strings2 = Arrays.asList("xyz", "jqx");
        System.out.println(Stream.concat(list.stream(), strings2.stream()).collect(Collectors.joining("-")));
        //没有指定类型的话会报错
    }

    @Test
    public void test06() {
        // 创建一个 HashMap
        HashMap<String, String> countries = new HashMap<>();

        // 往HashMap插入映射项
        countries.put("Washington", "America");
        countries.put("Canberra", "Australia");
        countries.put("Madrid", "Spain");
        System.out.println("HashMap: " + countries);

        //合并 key为 Washington的映射
        String returnedValue = countries.merge("Washington", "USA", (oldValue, newValue) -> oldValue + "/" + newValue);
        System.out.println("Washington: " + returnedValue);

        //输出更新后的HashMap
        System.out.println("Updated HashMap: " + countries);

        HashMap<String, String> map = new HashMap<>();
//        LocalDate date = LocalDate.of(2021, 1, 26);
        //format yyyy-MM-dd
        LocalDate date2 = LocalDate.now();
        System.out.println(String.format("date format : %s", date2));
        LocalDateTime date = LocalDateTime.now();
        LocalTime localTime = LocalTime.now().withNano(0);
        System.out.println("localtime --> " + localTime);
        System.out.println("date  -->  " + date);
        LocalDate parse = LocalDate.parse("2021-01-26");
        System.out.println("date  -->  " + parse);

        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 12, 12, 22);
        String formatTime = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String formatTime = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("formatTime  -->  " + formatTime);

        LocalTime time = LocalTime.of(12, 12, 22);
        LocalTime.parse("12:12:22");
        System.out.println("date  -->  " + time);

        // print result
//        LocalDateTime dateTime2 = LocalDateTime.of(2021, 1, 26, 12, 12, 22);
    }

    @Test
    public void test08() {

        /**
         * 使用enum关键字定义枚举类
         * 说明：定义的枚举类默认继承于java.lang.Enum类
         *
         * 三、Enum类的常用方法
         *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
         *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
         *      toString()：返回当前枚举类对象常量的名称
         */
        Season1 summer = Season1.SUMMER;
        //toString():
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println("****************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

    }

    //使用enum关键字枚举类
    enum Season1 {
        //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
        SPRING("春天", "万物复苏"),
        SUMMER("夏天", "烈日炎炎"),
        AUTUMN("秋天", "金秋送爽"),
        WINTER("冬天", "白雪皑皑");
        //2.声明Season对象的属性:private final修饰
        private final String seasonName;
        private final String seasonDesc;

        //3.私有化类的构造器,并给对象属性赋值
        private Season1(String seasonName, String seasonDesc) {
            this.seasonName = seasonName;
            this.seasonDesc = seasonDesc;
        }

        //4.其他诉求：获取枚举类对象的属性
        public String getSeasonName() {
            return seasonName;
        }

        public String getSeasonDesc() {
            return seasonDesc;
        }

        //4.其他诉求1：提供toString()
        @Override
        public String toString() {
            return "Season{" +
                    "seasonName='" + seasonName + '\'' +
                    ", seasonDesc='" + seasonDesc + '\'' +
                    '}';
        }
    }

    @Test
    public void test10() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        String res = list.stream().map(str -> str.toUpperCase()).collect(Collectors.joining("-", "[", "]"));
        System.out.println(res);
        boolean aa = list.stream().anyMatch(e -> e.equals("aa"));
        System.out.println(aa + "=========");
        Optional<String> listRes = list.stream().findFirst();
        System.out.println(listRes);
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 67, 7, 8, 421, 3114);

        try {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");

            System.out.println(inet1);


            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet4.getHostName());
            //getHostAddress()
            System.out.println(inet4.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11() throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();


        //创建Thread类的匿名子类的方式
        AtomicInteger sum = new AtomicInteger();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "偶数" + i);
                    sum.getAndIncrement();
                }
            }
        }, "n1").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "奇数" + i);
                    sum.getAndIncrement();
                }
            }
        }, "n2").start();
        Thread.sleep(2000);
        System.out.println("aaaa" + sum.get());
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": 偶数为: " + i);
                }
            }
        }

    }

    class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": 奇数为: " + i);
                }
            }
        }
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号
//
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                Character tmp = stack.isEmpty() ? '#' : stack.pop();
                if (!Objects.equals(map.get(c), tmp)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test12() {
        boolean valid2 = isValid2("((");
        System.out.println(valid2);
    }

    public static boolean isValid2(String s) {
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (charMap.containsValue(c)) {
                // ( { [
                stack.push(c);
            } else {//  c -> } ] )
                if (!charMap.containsKey(c)) {
                    return false;
                }
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character popChar = stack.pop();
                    if (!popChar.equals(charMap.get(c))) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    //链接：https://leetcode.cn/problems/valid-parenthesis-string
    //给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
    //
    //任何左括号 (必须有相应的右括号 )。
    //任何右括号 )必须有相应的左括号 (。
    //左括号 ( 必须在对应的右括号之前 )。
    // * 可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
    //一个空字符串也被视为有效字符串。
    //示例 1:
    //
    //输入: "()"
    //输出: True
    //示例 2:
    //
    //输入: "(*)"
    //输出: True
    //示例 3:
    //
    //输入: "(*))"
    //输出: True
    //
    public boolean checkValidString(String s) {
        char[] charArray = s.toCharArray();
        // {*}
        int count = 0;
        int len = charArray.length;
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char c : charArray) {
            if (map.containsValue(c) || c == '*') { //( { [
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // ) } ]
                Character popChar = stack.pop();
                if (popChar == '*') {
                    count++;
                }
                if (!map.containsKey(c) && popChar != '*') {
                    return false;
                }//popChar -> ) } ]
                if (popChar != map.get(c) && popChar != '*') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            for (Character ch : stack) {
                if (ch != '*') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


