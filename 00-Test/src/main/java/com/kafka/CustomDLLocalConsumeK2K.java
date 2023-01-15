package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.Properties;

public class CustomDLLocalConsumeK2K implements Runnable {
    private KafkaConsumer<String, String> consumer;
    private ConsumerRecords<String, String> msgList;
    private final String topic;

    public CustomDLLocalConsumeK2K(String topicName) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Broker连接地址
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.21.18.155:9092");
        // Group id
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
        // 是否自动提交offset
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        // 自动提交offset的时间间隔
//        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 会话超时时间
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // 消息Key值使用的反序列化类
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        // 消息内容使用的反序列化类
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        // 最大消费量
        properties.put("max.poll.records", 1000);
        this.consumer = new KafkaConsumer<>(properties);
        this.topic = topicName;
        this.consumer.subscribe(Collections.singletonList(topic));

    }


    @Override
    public void run() {
        int messageNo = 1;
        System.out.println("---------开始消费---------");
        try {
            while (true) {
                msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, String> record : msgList) {
                        System.out.println(messageNo + "=======receive: key = " + record.key() + ", value = " + record.value() + " offset===" + record.offset());
                        //消费100条就打印 ,但打印的数据不一定是这个规律的
                        if (messageNo % 100 == 0) {
                            System.out.println(messageNo + "=======receive: key = " + record.key() + ", value = " + record.value() + " offset===" + record.offset());
                        }
                        //当消费了1000条就退出
                        if (messageNo % 1000 == 0) {
                            break;
                        }
                        messageNo++;
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();

        }
    }

    public static void main(String[] args) {
//        CustomDLLocalConsumeK2K test1 = new CustomDLLocalConsumeK2K("asap_alarm123");
        CustomDLLocalConsumeK2K test1 = new CustomDLLocalConsumeK2K("first");
        Thread thread1 = new Thread(test1);
        thread1.start();
    }

}
