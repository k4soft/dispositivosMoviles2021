package co.com.k4soft.sistemasolar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.k4soft.sistemasolar.adapter.PlanetaBaseAdapter;
import co.com.k4soft.sistemasolar.entities.Planeta;

public class MainActivity extends AppCompatActivity {

    List<Planeta> listaPlanetas;

    ListView listViewPlanetas;

    EditText txtBusqueda;
    PlanetaBaseAdapter planetaBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        cargarPlanetas();
        cargarAdapter();
        txtBusqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                planetaBaseAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void cargarAdapter() {
         planetaBaseAdapter = new PlanetaBaseAdapter(this,listaPlanetas);
         listViewPlanetas.setAdapter(planetaBaseAdapter);
    }

    private void initComponents() {
        listViewPlanetas = findViewById(R.id.listViewPlanetas);
        txtBusqueda = findViewById(R.id.txtBusqueda);
    }

    private void cargarPlanetas() {
        listaPlanetas = new ArrayList<>();
        listaPlanetas.add(new Planeta(R.drawable.marte, "Marte"," es el cuarto planeta del Sistema Solar. Conocido como el planeta rojo por sus tonos rosados, los romanos lo identificaban con la sangre y le pusieron el nombre de su dios de la guerra. El planeta Marte Cuando se halla m??s cerca de la Tierra, a unos 55 millones de kil??metros, Marte es, despu??s de la Luna, Venus y J??piter, el objeto m??s brillante en el cielo nocturno. Puede observarse m??s f??cilmente cuando se forma la l??nea recta Sol-Tierra-Marte (es decir, cuando est?? en oposici??n) y se encuentra cerca de la Tierra, cosa que pasa una vez cada 15 a??os. Ocurri?? por ??ltima vez el 31 de julio de 2018, cuando se le vio en la constelaci??n de Capricornio."));
        listaPlanetas.add(new Planeta(R.drawable.tierra, "Tierra","es nuestro planeta y el ??nico habitado. Est?? situado en la ecosfera, un espacio que rodea al Sol y que tiene las condiciones adecuadas para que exista vida.  Y la tiene. Est?? dominada ahora por unos primates que han evolucionado hasta estudiar la astronom??a. La Tierra es el planeta de los simios El planeta Tierra"));
        listaPlanetas.add(new Planeta(R.drawable.jupiter, "Jupiter","Es el planeta m??s grande del Sistema Solar. Tiene casi dos veces y media la materia de todos los dem??s planetas juntos, y su volumen es 1.317 veces el de la TierraDe los denominados planetas exteriores o gigantes gaseosos, J??piter es el que se encuentra m??s cerca del Sol. Por eso, y por su enorme tama??o, es el que podemos ver m??s brillante en el cielo nocturno."));

    }
}