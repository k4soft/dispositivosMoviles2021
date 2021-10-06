package co.com.k4soft.clienteapijava.util;

import android.app.Application;

import lombok.Data;

@Data
public class GlobalState extends Application {

    private String accessToken;
}
