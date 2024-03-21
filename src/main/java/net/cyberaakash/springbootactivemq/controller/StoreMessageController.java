package net.cyberaakash.springbootactivemq.controller;

import net.cyberaakash.springbootactivemq.dto.Store;
import net.cyberaakash.springbootactivemq.producer.StoreMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StoreMessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    StoreMessageProducer storeMessageProducer;

    @Value("${activemq.destination}")
    private String destination;

    /**
     * API for publish message for ActiveMQ queue
     * @param store
     * @return String
     */
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Store store){
        storeMessageProducer.sendTo(destination,store);
        return "Success";
    }
}
