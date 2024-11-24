package com.examen.exu3_orlandobazan.Interface;

import com.examen.exu3_orlandobazan.Model.AuthRequest;
import com.examen.exu3_orlandobazan.Model.CitaIdRequest;
import com.examen.exu3_orlandobazan.Model.CitaRequest;
import com.examen.exu3_orlandobazan.Model.CitaResponse;
import com.examen.exu3_orlandobazan.Model.GenericResponse;
import com.examen.exu3_orlandobazan.Model.TokenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BquirogaorlandoAPI {
    // Endpoint para autenticación
    @POST("/auth")
    Call<TokenResponse> authenticate(@Body AuthRequest authRequest);

    // Endpoint para registrar una cita
    @POST("api_orlandobazan_guardarcita")
    Call<CitaResponse> registrarCita(@Body CitaRequest citaRequest);

    // Endpoint para anular una cita
    @POST("api_orlandobazan_anularcita")
    Call<GenericResponse> anularCita(@Body CitaIdRequest citaIdRequest);

    // Endpoint para listar todas las citas (protegido con JWT)
    @GET("api_orlandobazan_listarcitas")
    Call<List<CitaResponse>> listarCitas();
}
