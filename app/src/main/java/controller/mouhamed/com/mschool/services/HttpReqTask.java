package controller.mouhamed.com.mschool.services;

import android.os.AsyncTask;
import android.util.Log;
import controller.mouhamed.com.mschool.model.Utilisateur;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class HttpReqTask extends AsyncTask<Void, Void, Utilisateur[]> {
    @Override
    protected  Utilisateur[] doInBackground(Void... voids) {
        try {
            String apiUrl = "http://192.168.43.155:8080/mschool/list-user";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Utilisateur[] utilisateurs = restTemplate.getForObject(apiUrl,  Utilisateur[].class);
            return utilisateurs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Utilisateur[] utilisateurs) {
        super.onPostExecute(utilisateurs);
        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur.getUsername());
        }
    }
}
