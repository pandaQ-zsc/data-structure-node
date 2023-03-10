package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.*;
import com.example.demo.exception.ServiceException;
import com.example.demo.job.PrintWordsJob;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Resource
    RedisTemplate<String, Object> redisTemplate;


    @Test
    void contextLoads() {
        Predicate<Integer> predicate = n -> n > 85;
        Student student = new Student("01", "hahaha", 20);
        System.out.println(predicate.test(student.getAge()));
        Consumer<String> consumer = System.out::println;
        consumer.accept(student.toString());
        Function<Student, String> function = Student::getName;
        function.apply(student);
        List<Employee> employeeList = EmployeeData.getEmployees();
        Optional<Employee> max = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        if (max.isPresent()) {
            Employee employee = max.get();
            System.out.println(employee);
        }

    }

    @Test
    void cul() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// ????????????????????????
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        String s = squaresList.toString();
        System.out.println(s);
    }

    public static int i = 1;

    @Test
    public void test00() {
        Stream<Integer> integerStream = Stream.of(5, 3, 4, 5, 6);
        OptionalDouble average = integerStream.mapToInt(e -> e).average();
        double asDouble = average.getAsDouble();
        System.out.printf("????????????%f", asDouble);
        List<Employee> employees = EmployeeData.getEmployees();
        Optional.ofNullable(employees.get(0)).flatMap(e -> Optional.ofNullable(e.getName()));
        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(map);
        Map<String, List<Employee>> groupingMap = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(" ---- > " + groupingMap);
        System.out.println("============================");
        groupingMap.forEach((a, b) -> System.out.println(a + " : " + b));
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("==============================");
        List<String> list = Arrays.asList("?????? ?????????", "?????? ????????????", "?????? ?????????");
        ArrayList<String> res = new ArrayList<>();
        List<String> collect = list.stream().map(e -> {
            String[] s = e.split(" ");
            Stream<Integer> integerStream2 = Stream.of(5, 3, 4, 5, 6);
            res.addAll(Arrays.asList(s));
            return e;
        }).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
        res.forEach(System.out::println);
        System.out.println("===================================");
        int[] count = {0};
        list.stream().flatMap(e -> Arrays.stream(e.split(" "))).map(e -> (i++) + ". " + e).forEach(System.out::println);

    }


    @Test
    public void test01() throws Exception {
        String getUrl = "http://localhost:8080/testGet?userCode={userCode}&userMsg={userMsg}";
        String postUrl = "http://localhost:8080/testPostHeader";
        HashMap<String, String> map = new HashMap<>();
        map.put("userCode", "10086");
        map.put("userMsg", "????????????");
        if (Optional.ofNullable(restTemplate).isPresent()) {
            ResponseEntity<ResponseBean> res = restTemplate.getForEntity(getUrl, ResponseBean.class, map);
            //???????????????
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            LinkedMultiValueMap<String, String> headMap = new LinkedMultiValueMap<>();

            //????????????
            headMap.put("userCode", Collections.singletonList("99999"));
            headMap.put("userMsg", Collections.singletonList("i am really sad"));
            //???????????????
            HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(headMap, headers);

            ResponseEntity<ResponseBean> postForEntity = restTemplate.postForEntity(postUrl, httpEntity, ResponseBean.class);

            System.out.println(res);
            System.out.println(postForEntity);
        } else {
            throw new Exception("restTemplate ?????????");
        }
    }


    /**
     * Redis??????
     */
    @Test
    public void testRedisDemo1() throws ServiceException {
//        Boolean ageExist = stringRedisTemplate.hasKey("age");
//        System.out.println(ageExist);
//        Set<String> keys = stringRedisTemplate.keys("*");
//        System.out.println(keys);
//        stringRedisTemplate.opsForValue().set("name", "tom");
//        String name = stringRedisTemplate.opsForValue().get("name");
//        System.out.println(name);
//        stringRedisTemplate.delete("name");
//        System.out.println(name);

        System.out.println("==============================");

        redisTemplate.opsForValue().set("t", new Employee(20, "xiong"));
        if (Optional.ofNullable(redisTemplate.opsForValue().get("t")).isPresent()) {
            Object a1 = redisTemplate.opsForValue().get("t");
            if (a1 instanceof Employee) {
                System.out.println(a1.getClass().getName() + "==========");
            }
            Employee a = (Employee) redisTemplate.opsForValue().get("t");

            System.out.println(a);

        } else {
            throw new ServiceException("???????????????");
        }

    }

    @Test
    public void testUUIdDemo() {
        String uuid = IdWorker.get32UUID();
        System.out.println(uuid);
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

    }

    @Test
    public void testMybatisAutoKeyDemo() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("Tom");
            user.setAge(20);
            user.setId(IdWorker.getId(user));
            userMapper.insert(user);
            Long id = user.getId();
            System.out.println("?????????????????????:" + id);
        }

    }

    @Test
    public void testTimedTask() {
//        Runnable runnable = () -> {
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("??????2s....");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };

    }

    @Test
    public void testJob() throws SchedulerException, InterruptedException {
        //???????????????Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("xxx", "qqq");
        jobDataMap.put("aaa", "bbb");
        jobDataMap.put("ccc", "ddd");
        //?????????????????????????????????TestJob??????
        JobDetail job = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("testJob", "test")
                .setJobData(jobDataMap)
                .build();
        //CronTrigger(????????????) ?????? SimpleTrigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("testTrigger", "test")
                .startNow()
                //SimpleTrigger -->  SimpleScheduleBuilder
                //??????1s ????????????
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(10)).build();
        //CronTrigger -->  CronScheduleBuilder
//                .withSchedule(CronScheduleBuilder.cronSchedule("* 30 10 ? * 1/5 2018"))
        scheduler.scheduleJob(job, trigger);
        System.out.println("---------------scheduler start !  ---------------");
        scheduler.start();
        //??????:10s
        TimeUnit.SECONDS.sleep(10);
        scheduler.shutdown();
        System.out.println("---------------scheduler shutdown !  ---------------");
    }
}
