package co.com.k4soft.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView valores;
    ListView listViewCiudades;
    List<String> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        cargarCiudades();
        cargarListViewCiudades();
        valores.setText(getString(R.string.valores, seekBar.getProgress()+""));
        seekBarListener();

    }

    private void cargarListViewCiudades() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,ciudades);
        listViewCiudades.setAdapter(arrayAdapter);
    }

    private void seekBarListener() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valores.setText(getString(R.string.valores, progress+""));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valores.setText(getString(R.string.valores, seekBar.getProgress()+""));
            }
        });
    }

    private void cargarCiudades() {
        ciudades = new ArrayList<>();
        ciudades.add("Rionegro");
        ciudades.add("Medellin");
        ciudades.add("La ceja");
        ciudades.add("Bogotá");
        ciudades.add("Cali");
    }

    private void initComponents() {
        seekBar = findViewById(R.id.seekBar);
        valores = findViewById(R.id.valores);
        listViewCiudades = findViewById(R.id.listViewCiudades);
    }
}