/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author cazucito
 */
@MessageDriven(mappedName = "jms/demoMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ProcesoCostosoMDB implements MessageListener {
    
    public ProcesoCostosoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            System.out.println("INICIO");
            Thread.sleep(15000);
            System.err.println("FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcesoCostosoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
