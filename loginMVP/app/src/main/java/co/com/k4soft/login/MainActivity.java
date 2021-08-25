package co.com.k4soft.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.com.k4soft.login.dominio.Credenciales;

public class MainActivity extends AppCompatActivity implements LoginMVP.View {

    EditText txtxUsername;
    EditText txtxPassword;
    Button btnAceptar;
    LoginMVP.Presenter presenter;
    private Credenciales credenciales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        btnAceptar.setOnClickListener(v -> {
            establecerComando();
            presenter.validarInformacion();
        });
    }

    private void establecerComando() {
        credenciales = new Credenciales(txtxUsername.getText().toString(),txtxPassword.getText().toString());
    }

    private void initComponent() {
        txtxPassword = findViewById(R.id.txtxPassword);
        txtxUsername = findViewById(R.id.txtxUsername);
        btnAceptar = findViewById(R.id.btnAceptar);
        presenter = new LoginPresenter(this);
    }


    @Override
    public void requerirUsuario() {
        txtxUsername.setError(getString(R.string.requerido));
    }


    @Override
    public void requerirPassword() {
        txtxPassword.setError(getString(R.string.requerido));
    }

    @Override
    public void rechazarCredenciales() {
        Toast.makeText(this, R.string.credenciales_no_validas, Toast.LENGTH_LONG).show();
    }

    @Override
    public void aceptarCredenciales() {
        Toast.makeText(this, R.string.bienvenido, Toast.LENGTH_LONG).show();
    }

    @Override
    public Credenciales getCredenciales() {
        return credenciales;
    }
}