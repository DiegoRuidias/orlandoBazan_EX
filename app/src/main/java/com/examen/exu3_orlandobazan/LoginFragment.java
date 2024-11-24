package com.examen.exu3_orlandobazan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.examen.exu3_orlandobazan.Interface.BquirogaorlandoAPI;
import com.examen.exu3_orlandobazan.Model.LoginRequest;
import com.examen.exu3_orlandobazan.Model.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginFragment extends Fragment {
    private EditText editTextDni, editTextPassword;
    private Button buttonLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextDni = view.findViewById(R.id.editTextDNI);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> authenticateUser());

        return view;
    }

    private void authenticateUser() {
        String dni = editTextDni.getText().toString();
        String password = editTextPassword.getText().toString();

        if (dni.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bquirogaorlando.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BquirogaorlandoAPI api = retrofit.create(BquirogaorlandoAPI.class);

        LoginRequest loginRequest = new LoginRequest(dni, password);
        Call<TokenResponse> call = api.authenticate(loginRequest);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String token = response.body().getAccessToken();
                    Toast.makeText(getContext(), "Autenticación exitosa", Toast.LENGTH_SHORT).show();

                    // Crear un Bundle para pasar el token al siguiente fragmento
                    Bundle bundle = new Bundle();
                    bundle.putString("token", token);

                    // Navegar al fragmento "Generar Citas"
                    Navigation.findNavController(requireView())
                            .navigate(R.id.action_loginFragment_to_generateCitaFragment, bundle);
                } else {
                    Toast.makeText(getContext(), "Credenciales inválidas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}