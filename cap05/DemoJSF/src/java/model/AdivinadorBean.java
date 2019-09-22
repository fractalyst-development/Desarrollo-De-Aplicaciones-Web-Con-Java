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
  private int maximo=13;

  public AdivinadorBean() {
    numero = 7;
    respuesta = new Random().nextInt(13);
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

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

  public int getMaximo() {
    return maximo;
  }

  public void setMaximo(int maximo) {
    this.maximo = maximo;
  }
}
