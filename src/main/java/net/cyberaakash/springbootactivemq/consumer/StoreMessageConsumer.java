package net.cyberaakash.springbootactivemq.consumer;

import lombok.extern.slf4j.Slf4j;
import net.cyberaakash.springbootactivemq.dto.Store;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StoreMessageConsumer {

    /**
     * Message Listener of ActiveMQ queue
     * @param store
     */
    @JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
    public void processToDo(Store store) {
        log.info("Consumer> " + store);
    }
}