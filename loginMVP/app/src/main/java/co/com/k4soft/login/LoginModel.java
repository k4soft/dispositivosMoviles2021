package co.com.k4soft.login;

public class LoginModel implements LoginMVP.Model{

    private final LoginMVP.Presenter presenter;
    private String usuario;

    public LoginModel(LoginMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void validarInformacion() {
        if(usuario == null || "".equals(usuario)){
          presenter.requerirUsuario();
        }
    }
}
