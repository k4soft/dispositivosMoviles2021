package co.com.k4soft.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView valores;
    ListView listViewCiudades;
    List<String> ciudades;
    AutoCompleteTextView autoComplete;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        cargarCiudades();
        cargarListViewCiudades();
        valores.setText(getString(R.string.valores, seekBar.getProgress() + ""));
        seekBarListener();
        listViewOnClickListener();
        cargarAutocomplete();
        cargarSpinner();
    }

    private void cargarSpinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ciudades);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showToast(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showToast(int position) {
        Toast.makeText(getApplicationContext(), ciudades.get(position), Toast.LENGTH_LONG).show();
    }

    private void cargarAutocomplete() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, ciudades);
        autoComplete.setAdapter(arrayAdapter);
    }

    private void listViewOnClickListener() {
        listViewCiudades.setOnItemClickListener((parent, view, position, id) -> {
            showToast(position);
        });
    }

    private void cargarListViewCiudades() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, ciudades);
        listViewCiudades.setAdapter(arrayAdapter);
    }

    private void seekBarListener() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valores.setText(getString(R.string.valores, progress + ""));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valores.setText(getString(R.string.valores, seekBar.getProgress() + ""));
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
        ciudades.add("Neiva");
        ciudades.add("Florencia");
        ciudades.add("Envigado");
        ciudades.add("Barranquilla");
        ciudades.add("Cartagena");
        ciudades.add("Rioacha");
    }

    private void initComponents() {
        seekBar = findViewById(R.id.seekBar);
        valores = findViewById(R.id.valores);
        listViewCiudades = findViewById(R.id.listViewCiudades);
        autoComplete = findViewById(R.id.autoComplete);
        spinner = findViewById(R.id.spinner);
    }
}