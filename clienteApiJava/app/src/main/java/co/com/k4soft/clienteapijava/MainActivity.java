package co.com.k4soft.clienteapijava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import co.com.k4soft.clienteapijava.cliente.Service;
import co.com.k4soft.clienteapijava.cliente.impl.LoginService;

public class MainActivity extends AppCompatActivity {


    EditText txtUser;
    EditText txtPassword;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        btnLogin.setOnClickListener( v-> consumirServicio());
    }

    private void consumirServicio() {
        Service login = new LoginService(this,txtUser.getText().toString(),txtPassword.getText().toString());
        login.consumirServicio();
    }

    private void initComponents() {
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}