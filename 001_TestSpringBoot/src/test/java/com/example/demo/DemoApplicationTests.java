package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeData;
import com.example.demo.entity.ResponseBean;
import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RestTemplate restTemplate;

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
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        String s = squaresList.toString();
        System.out.println(s);
    }

    @Test
    public void test01() throws Exception {
        String getUrl = "http://localhost:8080/testGet?userCode={userCode}&userMsg={userMsg}";
        String postUrl = "http://localhost:8080/testPostHeader";
        HashMap<String, String> map = new HashMap<>();
        map.put("userCode", "10086");
        map.put("userMsg", "哈哈哈哈");
        if (Optional.ofNullable(restTemplate).isPresent()) {
            ResponseEntity<ResponseBean> res = restTemplate.getForEntity(getUrl, ResponseBean.class, map);
            //请求头设置
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            LinkedMultiValueMap<String, String> headMap = new LinkedMultiValueMap<>();

            //参数设置
            headMap.put("userCode", Collections.singletonList("99999"));
            headMap.put("userMsg", Collections.singletonList("i am really sad"));
            //组装请求体
            HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(headMap, headers);

            ResponseEntity<ResponseBean> postForEntity = restTemplate.postForEntity(postUrl, httpEntity, ResponseBean.class);

            System.out.println(res);
            System.out.println(postForEntity);
        } else {
            throw new Exception("restTemplate 未注入");
        }
    }
}
