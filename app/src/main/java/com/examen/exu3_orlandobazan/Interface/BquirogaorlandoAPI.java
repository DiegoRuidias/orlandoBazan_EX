package com.examen.exu3_orlandobazan.Interface;

import com.examen.exu3_orlandobazan.Model.CitaIdRequest;
import com.examen.exu3_orlandobazan.Model.CitaRequest;
import com.examen.exu3_orlandobazan.Model.CitaResponse;
import com.examen.exu3_orlandobazan.Model.GenericResponse;
import com.examen.exu3_orlandobazan.Model.LoginRequest;
import com.examen.exu3_orlandobazan.Model.TokenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BquirogaorlandoAPI {
    // Endpoint para autenticación (Inicio de sesión)
    @POST("auth")
    Call<TokenResponse> authenticate(@Body LoginRequest loginRequest);

    // Endpoint para guardar citas
    @POST("api_orlandobazan_guardarcita")
    Call<GenericResponse> guardarCita(@Body CitaRequest citaRequest);

    // Endpoint para anular citas
    @POST("api_orlandobazan_anularcita")
    Call<GenericResponse> anularCita(@Body CitaIdRequest citaIdRequest);

    // Endpoint para listar citas (requiere autenticación)
    @GET("api_orlandobazan_listarcitas")
    Call<List<CitaResponse>> listarCitas();
}
