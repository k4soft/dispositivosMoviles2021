package co.com.k4soft.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}