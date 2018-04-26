package com.bird;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import java.util.Calendar;

/**
 * author: 牛虻.
 * time:2018/4/26
 * email:pettygadfly@gmail.com
 * doc:
 */
public class Test {
    private static JmsTemplate jmsTemplate;
    public static void main(String[] args) throws JMSException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
         jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
        Queue queue = jmsTemplate.getConnectionFactory().createConnection().createSession(true,Session.AUTO_ACKNOWLEDGE).createQueue("iCresssateQuene");
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(500);
                        jmsTemplate.send(new MessageCreator() {
                            @Override
                            public Message createMessage(Session session) throws JMSException {
                                return session.createTextMessage("fuck you "+ Calendar.getInstance().getTimeInMillis());
                            }
                        });
                        jmsTemplate.send("iCreateQuene",new MessageCreator() {
                            @Override
                            public Message createMessage(Session session) throws JMSException {
                                return session.createTextMessage("fuck you "+ Calendar.getInstance().getTimeInMillis());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
