package co.com.k4soft.login;

import co.com.k4soft.login.dominio.Credenciales;

public interface LoginMVP {

    interface View {


        void requerirUsuario();

        void requerirPassword();

        void rechazarCredenciales();

        void aceptarCredenciales();

        Credenciales getCredenciales();
    }

    interface Presenter {
        void validarInformacion();

        void requerirUsuario();

        void requerirPassword();

        void aceptarCredenciales();

        void rechazarCredenciales();
    }

    interface Model {

        void validarInformacion();

        void setCredenciales(Credenciales credenciales);
    }
}
