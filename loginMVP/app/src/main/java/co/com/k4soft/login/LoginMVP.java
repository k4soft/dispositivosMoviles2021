package co.com.k4soft.login;

public interface LoginMVP {

     interface View{

          String getUsuario();

          void requerirUsuario();
     }

     interface Presenter{
         void validarInformacion();

          void requerirUsuario();
     }

     interface Model{

          void setUsuario(String usuario);

          void validarInformacion();
     }
}
