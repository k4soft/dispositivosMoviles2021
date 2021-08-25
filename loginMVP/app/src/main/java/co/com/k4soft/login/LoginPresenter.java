package co.com.k4soft.login;

public class LoginPresenter implements LoginMVP.Presenter {


    private LoginMVP.View view;
    private LoginMVP.Model model;


    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void validarInformacion() {
        if (view != null) {
            model.setCredenciales(view.getCredenciales());
            model.validarInformacion();
        }
    }

    @Override
    public void requerirUsuario() {
        if(view != null){
            view.requerirUsuario();
        }
    }

    @Override
    public void requerirPassword() {
        if(view != null){
            view.requerirPassword();
        }
    }

    @Override
    public void aceptarCredenciales() {
        if(view != null){
            view.aceptarCredenciales();
        }
    }

    @Override
    public void rechazarCredenciales() {
        if(view != null){
            view.rechazarCredenciales();
        }
    }
}
