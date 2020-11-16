package com.hnu.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: YUANHX
 * @create: 10:17 上午
 **/
@Component
public class KafkaListen {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaListen.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void sendKafka(){
        LOG.info("kafka producer begin **********   ");
        for(int i = 0;i<20;i++){
            kafkaTemplate.send("yuanhx","data"+i);
        }
        LOG.info("kafka producer end **********   ");
    }

    @KafkaListener(topics = {"yuanhx"})
    public void kafkaListen(ConsumerRecord<?, ?> record){
        LOG.info("kafka consumer begin **********   ");
        LOG.info(" consumer recieve :" + record.value().toString());
        LOG.info("kafka consumer end **********   ");
    }

    @KafkaListener(groupId = "yuan",topics = {"yuanhx"})
    public void kafkaListen1(String msg){
        LOG.info("kafka kafkaListen1 groupId yuan begin **********   ");
        LOG.info(" consumer recieve :" + msg);
        LOG.info("kafka kafkaListen1 groupId yuan  end **********   ");
    }
}
