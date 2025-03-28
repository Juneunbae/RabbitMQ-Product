package com.market.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductEndpoint {
    @Value("${spring.application.name}")
    private String applicationName;

    @RabbitListener(queues = "${message.queue.product}")
    public void receiveMessage(String orderId) {
        log.info("Receive OrderId: {}, appName: {}", orderId, applicationName);
    }
}