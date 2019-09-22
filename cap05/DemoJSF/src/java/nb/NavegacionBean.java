package nb;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "navegacionBean")
@RequestScoped
public class NavegacionBean {

  public NavegacionBean() {
  }

  public String checkStatus(String _n) {
    boolean f = _n.equalsIgnoreCase("a");
    if (f) {
      return "a";
    } else {
      return "b";
    }
  }
}
