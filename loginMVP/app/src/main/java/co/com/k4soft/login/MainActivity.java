package co.com.k4soft.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LoginMVP.View {

    EditText txtxUsername;
    EditText txtxPassword;
    Button btnAceptar;
    LoginMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        btnAceptar.setOnClickListener(v-> presenter.validarInformacion());
    }

    private void initComponent() {
        txtxPassword = findViewById(R.id.txtxPassword);
        txtxUsername = findViewById(R.id.txtxUsername);
        btnAceptar= findViewById(R.id.btnAceptar);
        presenter = new LoginPresenter(this);
    }

    @Override
    public String getUsuario() {
        return txtxUsername.getText().toString();
    }

    @Override
    public void requerirUsuario() {
        txtxUsername.setError(getString(R.string.requerido));
    }
}