package com.company.reservation.controller;

import com.company.reservation.entity.Customer;
import com.company.reservation.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka/")
public class ApacheKafkaWebController {
    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer/{message}")
    public String producer(@PathVariable String message) {
        kafkaSender.send(message);

        return "Message sent to the Kafka Topic kafka_example Successfully";
    }

    @PostMapping(value ="/producer/customer")
    public  String producerCustomer(@RequestBody Customer customer) {
        kafkaSender.sendObject(customer);
        return "Message sent to the Kafka Topic kafka_object_example Successfully";
    }

}
