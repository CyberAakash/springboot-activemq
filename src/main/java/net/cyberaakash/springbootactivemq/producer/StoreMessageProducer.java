package net.cyberaakash.springbootactivemq.producer;

import lombok.extern.slf4j.Slf4j;
import net.cyberaakash.springbootactivemq.dto.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StoreMessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Convert and publish the message to the queue
     *
     * @param destination
     * @param store
     */
    public void sendTo(String destination, Store store) {
        jmsTemplate.convertAndSend(destination, store);
        log.info("Producer> Message Sent");
    }

}