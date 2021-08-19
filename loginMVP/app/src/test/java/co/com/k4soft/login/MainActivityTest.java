package co.com.k4soft.login;



import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    LoginMVP.View view;
    LoginMVP.Presenter presenter;
    LoginMVP.Model model;

    @Before
    public void setUp(){
        presenter = new LoginPresenter(view);
        model = new LoginModel(presenter);
    }

    @Test
    public void requerirUsuarioNull(){
        when(view.getUsuario()).thenReturn(null);
        model.setUsuario(view.getUsuario());
        model.validarInformacion();
        verify(view).requerirUsuario();
    }

    @Test
    public void requerirUsuarioVacio(){
        when(view.getUsuario()).thenReturn("");
        model.setUsuario(view.getUsuario());
        model.validarInformacion();
        verify(view).requerirUsuario();
    }




}