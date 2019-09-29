# VISTA

## JSF | Facelet

1. Construya y ejecute un componente JSF con el código de la página anterior (hola.xhtml) 

      1. ```xml
         <?xml version='1.0' encoding='UTF-8' ?>
         <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
                                                                                            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
         <html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html">
             <h:head>
                 <title>Hola Mundo</title>
             </h:head>
             <h:body>
                 <h:outputText value="Hola Mundo"/>
             </h:body>
         </html>
         ```

## JSF | Managed Bean

1. Construya y ejecute el ‘**AdivinadorBean**’ mostrado en las diapositivas

   1. Adivina.xhtml

      1. ```xml
         <?xml version='1.0' encoding='UTF-8' ?>
         <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
           "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
         <html xmlns="http://www.w3.org/1999/xhtml"
               xmlns:h="http://xmlns.jcp.org/jsf/html">
           <h:head><title>Adivina el número</title></h:head>
           <h:body>
             <h:form>
               <h:outputText value="Adivina el número generado"/><p/>
               <h:outputLabel value="Ingresa un número (1-13): "/>
               <h:inputText value="#{adivinaBean.numero}"/><p/>
               <h:commandButton value="Submit" action="#{adivinaBean.verificaRespuesta()}"/>
               <h:commandButton value="Reset" action="#{adivinaBean.reset()}"/>
             </h:form>
           </h:body>
         </html>
         ```

   2. AdivinadorBean.java

      1. ```java
         package model;
         import javax.inject.Named;
         import javax.enterprise.context.SessionScoped;
         import java.io.Serializable;
         import java.util.Random;
         import javax.faces.application.FacesMessage;
         import javax.faces.context.FacesContext;

         @Named(value = "adivinaBean")
         @SessionScoped
         public class AdivinadorBean implements Serializable {
           private int respuesta;
           private int numero;
           public AdivinadorBean() {  respuesta = new Random().nextInt(13);  }
           public int getNumero() { return numero; }
           public void setNumero(int numero) { this.numero = numero; }
           //
          public void verificaRespuesta() {
             String s = "";
             if (numero == respuesta) {
               s = "Adivinaste, ¡¡¡Felicidades!!!";
             } else if (numero > respuesta) {
               s = "¡¡¡Muy alto!!!";
             } else if (numero < respuesta) {
               s = "¡¡¡Muy bajo!!!";
             }
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));
           }
           //
           public void reset() {
             numero = 0;
             respuesta = new Random().nextInt(13);
             System.out.println("El número generado es: " + respuesta);
           }
         }
         ```

   3. web.xml

      1. ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <web-app> <!-- ... -->
             <servlet>
                 <servlet-name>Faces Servlet</servlet-name>
                 <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
                 <load-on-startup>1</load-on-startup>
             </servlet>
             <servlet-mapping>
                 <servlet-name>Faces Servlet</servlet-name>
                 <url-pattern>/faces/*</url-pattern>
             </servlet-mapping>
             <welcome-file-list>
                 <welcome-file>index.xhtml</welcome-file>
             </welcome-file-list>
         </web-app>
         ```

## JSF | COMPONENTES UI

1. Realizar la interfaz gráfica con *facelets* para el Alta, Baja, Cambios y Consultas de una tabla de al menos 3 campos

## JSF | MANAGED BEAN

1. Adicionar el *Managed Bean* a la interfaz gráfica realizada en la actividad anterior

## JSF | MANAGED BEAN | FLASH

1. Ejemplifique la utilización del alcance de memoria *flash*
   1. Cree un formulario que direccione a otra vista
   2. La vista que recibe el flujo debe mostrar la información leída desde la memoria *flash*

## JSF | PLANTILLAS

1. OPCIONAL
   Modifique alguna de las aplicaciones desarrolladas anteriormente adicionando plantillas para gestionar su presentación

## JSF | CONVERTIDORES/VALIDADORES

1. Modifique alguna de las aplicaciones desarrolladas anteriormente adicionando convertidores y/o validadores
   1. Incluya la capacidad de mostrar mensajes de error

## JSF | EVENTOS

1. Cree un ejemplo que muestre la gestión de eventos
   1. Mediante un método en un *bean*
   2. Mediante la implementación de un *Listener*
