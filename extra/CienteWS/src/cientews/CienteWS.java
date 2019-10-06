/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cientews;

/**
 *
 * @author cazucito
 */
public class CienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(hello("QWERTY"));
    }

    private static String hello(java.lang.String name) {
        wsc.ArticuloService service = new wsc.ArticuloService();
        wsc.ArticuloWS port = service.getArticuloWSPort();
        return port.hello(name);
    }
    
}
