package co.com.k4soft.floatingactionbutton.util;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ActionBarUtil {
    private final AppCompatActivity appCompatActivity;


    public ActionBarUtil(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }




    public void setToolBar(String mensaje,boolean cambiarColorFondo) {
        if (appCompatActivity.getSupportActionBar() != null) {
            appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            appCompatActivity.getSupportActionBar().setTitle(mensaje);
            if(cambiarColorFondo){
                appCompatActivity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(UCOColorPalette.VERDE_UCO)));
            }

        }
    }

    public void setToolBar(String mensaje, String subtitle, boolean cambiarColorFondo) {
        subtitle = subtitle == null?"":subtitle;
        if (appCompatActivity.getSupportActionBar() != null) {
            appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            appCompatActivity.getSupportActionBar().setTitle(mensaje);
            if(cambiarColorFondo){
                appCompatActivity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(UCOColorPalette.VERDE_UCO)));
            }
            appCompatActivity.getSupportActionBar().setSubtitle(subtitle);
        }
    }

    public void hideActionBar() {
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
