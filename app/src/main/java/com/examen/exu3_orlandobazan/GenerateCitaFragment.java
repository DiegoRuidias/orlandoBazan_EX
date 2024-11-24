package com.examen.exu3_orlandobazan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examen.exu3_orlandobazan.Interface.BquirogaorlandoAPI;
import com.examen.exu3_orlandobazan.Model.CitaRequest;
import com.examen.exu3_orlandobazan.Model.CitaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GenerateCitaFragment extends Fragment {
    private EditText editTextFecha, editTextHora, editTextNombrePaciente;
    private Button buttonRegistrarCita;
    private TextView textViewCitaId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generate_cita, container, false);

        editTextFecha = view.findViewById(R.id.editTextFecha);
        editTextHora = view.findViewById(R.id.editTextHora);
        editTextNombrePaciente = view.findViewById(R.id.editTextNombrePaciente);
        buttonRegistrarCita = view.findViewById(R.id.buttonRegistrarCita);
        textViewCitaId = view.findViewById(R.id.textViewCitaId);

        buttonRegistrarCita.setOnClickListener(v -> registrarCita());

        return view;
    }

    private void registrarCita() {
        String fecha = editTextFecha.getText().toString();
        String hora = editTextHora.getText().toString();
        String nombrePaciente = editTextNombrePaciente.getText().toString();

        if (fecha.isEmpty() || hora.isEmpty() || nombrePaciente.isEmpty()) {
            Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bquirogaorlando.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BquirogaorlandoAPI api = retrofit.create(BquirogaorlandoAPI.class);

        CitaRequest citaRequest = new CitaRequest(fecha, hora, nombrePaciente);
        Call<CitaResponse> call = api.registrarCita(citaRequest);
        call.enqueue(new Callback<CitaResponse>() {
            @Override
            public void onResponse(Call<CitaResponse> call, Response<CitaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CitaResponse cita = response.body();
                    textViewCitaId.setText("ID de la cita: " + cita.getCitaId());
                    textViewCitaId.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "Cita registrada exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Error al registrar la cita", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CitaResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

}