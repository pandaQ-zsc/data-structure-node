package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CustomProduceParameters {
    public static void main(String[] args) {
        //配置
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.21.18.155:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //缓冲区大小
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        //批次大小
        // linger.ms
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // 压缩
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        //创建生产者
        try (KafkaProducer<Object, Object> kafkaProducer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 5; i++) {
                kafkaProducer.send(new ProducerRecord<>("first", "xxx -> " + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
