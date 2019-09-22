/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author cazucito
 */
@Singleton
public class FachadaSB implements FachadaSBLocal {

    @Resource(mappedName = "jms/demoMDB")
    private Queue demoMDB;

    @Resource(mappedName = "jms/demoMDBFactory")
    private ConnectionFactory demoMDBFactory;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    

    private Message createJMSMessageForjmsDemoMDB(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToDemoMDB(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = demoMDBFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(demoMDB);
            messageProducer.send(createJMSMessageForjmsDemoMDB(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void enviarMensaje(String parameter) {
        try {
            sendJMSMessageToDemoMDB(parameter);
        } catch (JMSException ex) {
            Logger.getLogger(FachadaSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
