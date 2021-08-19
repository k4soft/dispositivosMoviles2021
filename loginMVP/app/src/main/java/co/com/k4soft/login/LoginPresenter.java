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
            model.setUsuario(view.getUsuario());
            model.validarInformacion();
        }
    }

    @Override
    public void requerirUsuario() {
        if(view != null){
            view.requerirUsuario();
        }
    }
}
