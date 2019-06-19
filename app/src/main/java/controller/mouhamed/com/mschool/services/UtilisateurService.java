package controller.mouhamed.com.mschool.services;

import controller.mouhamed.com.mschool.model.Utilisateur;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.ArrayList;

public interface UtilisateurService {
    //    String BASE_URL = "http://192.168.43.155:8080/mschool/";
//    String BASE_URL = "http://192.168.1.36:8080/mschool/";
    String BASE_URL = "https://androidschoolapi.herokuapp.com/mschool/";

    @Headers({"Accept: application/json"})
    @GET("/list-user")
    Call<ArrayList<Utilisateur>> getUsers();

   /* @GET("/drivers/{id}")
    Call<Driver> getDriver(@Path("id") String id);*/

    @Headers({"Accept: application/json"})
    @POST("login")
    Call<Utilisateur> login(@Body Utilisateur utilisateur);

   /* @DELETE("/drivers/{id}")
    Call<Void> deleteDriver(@Path("id") long id);

    @Headers({"Accept: application/json"})
    @PUT("/drivers/{id}")
    Call<Driver> updateDriver(@Body Driver driver, @Path("id") long id);*/
}
