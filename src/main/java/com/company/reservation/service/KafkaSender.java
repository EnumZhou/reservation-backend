package com.company.reservation.service;

import com.company.reservation.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String,Customer> customerKafkaTemplate;

    String kafkaTopic = "kafka_example";
    String kafkaObjectTopic = "kafka_object_example";
    public void sendObject(Customer customer) {
        log.info("Producing Object: {}",customer.toString());
        customerKafkaTemplate.send(kafkaObjectTopic,customer);
    }

    public void send(String message) {
        log.info("Producing Message: {}",message);
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(kafkaTopic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
