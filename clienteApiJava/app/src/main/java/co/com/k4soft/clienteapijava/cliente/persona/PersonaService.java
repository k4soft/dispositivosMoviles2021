package co.com.k4soft.clienteapijava.cliente.persona;

import android.content.Context;

import java.util.List;

import co.com.k4soft.clienteapijava.cliente.Service;
import co.com.k4soft.clienteapijava.cliente.util.RetrofitFactory;
import co.com.k4soft.clienteapijava.model.Persona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PersonaService extends RetrofitFactory implements Service {


    protected PersonaService(Context context) {
        super(context);
    }

    @Override
    public void consumirServicio() {
        Retrofit retrofit = getTokenInstance();
        PersonaClient client = retrofit.create(PersonaClient.class);
        Call<List<Persona>> response = client.findAll();
        response.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {

            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {

            }
        });
    }
}
