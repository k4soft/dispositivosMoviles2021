package co.com.k4soft.sistemasolar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        cargarPlanetas();
        cargarAdapter();
    }

    private void cargarAdapter() {
        PlanetaBaseAdapter planetaBaseAdapter = new PlanetaBaseAdapter(this,listaPlanetas);
        listViewPlanetas.setAdapter(planetaBaseAdapter);
    }

    private void initComponents() {
        listViewPlanetas = findViewById(R.id.listViewPlanetas);
    }

    private void cargarPlanetas() {
        listaPlanetas = new ArrayList<>();
        listaPlanetas.add(new Planeta(R.drawable.marte, "Marte"," es el cuarto planeta del Sistema Solar. Conocido como el planeta rojo por sus tonos rosados, los romanos lo identificaban con la sangre y le pusieron el nombre de su dios de la guerra. El planeta Marte Cuando se halla más cerca de la Tierra, a unos 55 millones de kilómetros, Marte es, después de la Luna, Venus y Júpiter, el objeto más brillante en el cielo nocturno. Puede observarse más fácilmente cuando se forma la línea recta Sol-Tierra-Marte (es decir, cuando está en oposición) y se encuentra cerca de la Tierra, cosa que pasa una vez cada 15 años. Ocurrió por última vez el 31 de julio de 2018, cuando se le vio en la constelación de Capricornio."));
        listaPlanetas.add(new Planeta(R.drawable.tierra, "Tierra","es nuestro planeta y el único habitado. Está situado en la ecosfera, un espacio que rodea al Sol y que tiene las condiciones adecuadas para que exista vida.  Y la tiene. Está dominada ahora por unos primates que han evolucionado hasta estudiar la astronomía. La Tierra es el planeta de los simios El planeta Tierra"));
        listaPlanetas.add(new Planeta(R.drawable.jupiter, "Jupiter","Es el planeta más grande del Sistema Solar. Tiene casi dos veces y media la materia de todos los demás planetas juntos, y su volumen es 1.317 veces el de la TierraDe los denominados planetas exteriores o gigantes gaseosos, Júpiter es el que se encuentra más cerca del Sol. Por eso, y por su enorme tamaño, es el que podemos ver más brillante en el cielo nocturno."));

    }
}