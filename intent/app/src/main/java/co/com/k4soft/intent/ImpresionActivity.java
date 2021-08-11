package co.com.k4soft.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ImpresionActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);
        texto = findViewById(R.id.texto);
        String textoIngresado = getIntent().getStringExtra("TEXTO");
        texto.setText(textoIngresado);
    }
}