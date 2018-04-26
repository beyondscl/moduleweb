package com.bird;

import org.apache.logging.slf4j.Log4jLoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * author: 牛虻.
 * time:2018/4/26
 * email:pettygadfly@gmail.com
 * doc:
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            Thread.sleep(500);
            System.out.println(((TextMessage)message).getText());

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
