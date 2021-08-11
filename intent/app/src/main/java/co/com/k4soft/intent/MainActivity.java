package co.com.k4soft.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        btnEnviar.setOnClickListener(v-> enviar());
    }

    private void enviar() {
        String textoIngresado = texto.getText().toString();
        if(textoIngresado == null || "".equals(textoIngresado)){
            texto.setError(getString(R.string.requerido));
        } else {
            Intent intent = new Intent(getApplicationContext(),ImpresionActivity.class);
            intent.putExtra("TEXTO",textoIngresado);
            startActivity(intent);
        }

    }

    private void initComponent() {
        texto =  findViewById(R.id.texto);
        btnEnviar =  findViewById(R.id.btnEnviar);
    }
}