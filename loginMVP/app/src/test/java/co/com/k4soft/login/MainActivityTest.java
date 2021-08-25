package co.com.k4soft.login;



import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.k4soft.login.dominio.Credenciales;

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
        Credenciales credenciales = new Credenciales(null,null);
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirUsuario();
    }

    @Test
    public void requerirUsuarioVacio(){
        Credenciales credenciales = new Credenciales("","");
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirUsuario();
    }

    @Test
    public void requerirContrasenaNula(){
        Credenciales credenciales = new Credenciales("ssss",null);
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirPassword();
    }

    @Test
    public void requerirContrasenaVacia(){
        Credenciales credenciales = new Credenciales("ssss","");
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).requerirPassword();
    }

    @Test
    public void rechazarCredenciales(){
        Credenciales credenciales = new Credenciales("ssss","1234");
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).rechazarCredenciales();
    }

    @Test
    public void aceptarCredenciales(){
        Credenciales credenciales = new Credenciales("admin","1234");
        when(view.getCredenciales()).thenReturn(credenciales);
        model.setCredenciales(view.getCredenciales());
        model.validarInformacion();
        verify(view).aceptarCredenciales();
    }




}