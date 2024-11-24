package com.examen.exu3_orlandobazan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.examen.exu3_orlandobazan.Interface.BquirogaorlandoAPI;
import com.examen.exu3_orlandobazan.Model.CitaIdRequest;
import com.examen.exu3_orlandobazan.Model.GenericResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AnularCitaFragment extends Fragment {
    private EditText editTextCitaId;
    private Button buttonAnularCita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anular_cita, container, false);

        editTextCitaId = view.findViewById(R.id.editTextCitaId);
        buttonAnularCita = view.findViewById(R.id.buttonAnularCita);

        buttonAnularCita.setOnClickListener(v -> anularCita());

        return view;
    }

    private void anularCita() {
        String citaId = editTextCitaId.getText().toString();

        if (citaId.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese el ID de la cita", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bquirogaorlando.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BquirogaorlandoAPI api = retrofit.create(BquirogaorlandoAPI.class);

        CitaIdRequest citaIdRequest = new CitaIdRequest(Integer.parseInt(citaId));
        Call<GenericResponse> call = api.anularCita(citaIdRequest);
        call.enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Cita anulada exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error al anular la cita", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GenericResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

}