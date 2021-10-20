package co.com.k4soft.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import co.com.k4soft.floatingactionbutton.util.ActionBarUtil;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ActionBarUtil actionBarUtil = new ActionBarUtil(this);
        actionBarUtil.setToolBar("Activity 2", "Esta es una prueba", true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.goToGuardar) {
            goToGuardar();
            return true;
        } else if  (item.getItemId() == R.id.goToDownload){
            goToDownload();
        }
            return super.onOptionsItemSelected(item);
    }

    private void goToDownload() {
        Toast.makeText(this,"pulsaste descargar",Toast.LENGTH_SHORT).show();
    }

    private void goToGuardar() {
        Toast.makeText(this,"pulsaste guardar",Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}