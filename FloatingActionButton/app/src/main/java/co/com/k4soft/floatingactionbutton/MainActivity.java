package co.com.k4soft.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import co.com.k4soft.floatingactionbutton.util.ActionBarUtil;
import co.com.k4soft.floatingactionbutton.util.MovableFloatingActionButton;

public class MainActivity extends AppCompatActivity {

    MovableFloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarUtil actionBarUtil = new ActionBarUtil(this);
        actionBarUtil.setToolBar("Activity 1", false);
        actionButton= findViewById(R.id.floatingActionButton);
        actionButton.setOnClickListener(v-> {
            Intent intent = new Intent(this,Activity2.class);
            startActivity(intent);
        });
    }


}