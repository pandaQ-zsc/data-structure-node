package com.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomProducer {
    public static void main(String[] args) {
        //0.配置
        Properties properties = new Properties();
        //连接Broker
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.21.18.155:9092");
        //指定序列化
        // StringSerializer.class.getSimpleName() ----> org.apache.kafka.common.serialization.StringSerializer
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //自定义分区器
//        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.kafka.MyPartitioner");

        //1.创建对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        //2.发送数据
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("first", 1, "a", "hahaha  xxx --->  " + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("主题 : " + metadata.topic() + "分区： " + metadata.partition());
                    }
                }
            });
        }
        //3.关闭资源
        kafkaProducer.close();
    }
}
