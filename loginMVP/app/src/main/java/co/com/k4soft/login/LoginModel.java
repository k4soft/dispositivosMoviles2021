package co.com.k4soft.login;

import co.com.k4soft.login.dominio.Credenciales;

public class LoginModel implements LoginMVP.Model {

    private final LoginMVP.Presenter presenter;
    private Credenciales credenciales;

    public LoginModel(LoginMVP.Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    public void validarInformacion() {
        boolean camposLlenos = true;
        if (credenciales.getUsuario() == null || "".equals(credenciales.getUsuario() )) {
            camposLlenos = false;
            presenter.requerirUsuario();
        }

        if (credenciales.getPassword() == null || "".equals(credenciales.getPassword() )) {
            camposLlenos = false;
            presenter.requerirPassword();
        }

        if(camposLlenos){
            if("admin".equals(credenciales.getUsuario() ) && "1234".equals(credenciales.getPassword())){
                presenter.aceptarCredenciales();
            }else{
                presenter.rechazarCredenciales();
            }
        }


    }



    @Override
    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }
}
