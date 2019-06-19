package controller.mouhamed.com.mschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controller.mouhamed.com.mschool.model.Utilisateur;
import controller.mouhamed.com.mschool.services.ApiFactory;
import controller.mouhamed.com.mschool.services.UtilisateurService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        final EditText txtLogin = findViewById(R.id.txtLogin);
        final EditText txtPassword = findViewById(R.id.txtPassword);
        Button btnConnection = findViewById(R.id.btnConnection);
        //btnInscription = findViewById(R.id.btnInscription);

        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = txtLogin.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if (login.isEmpty() || password.isEmpty()) {
                    Toast.makeText(ConnexionActivity.this, getString(R.string.error_fields), Toast.LENGTH_SHORT).show();
                } else {
                    // redirection vers la page d'accueil
                    /*Intent intent = new Intent(ConnexionActivity.this, HomeActivity.class);
                    startActivity(intent);*/
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setUsername(login);
                    utilisateur.setPassword(password);
                    postToServer(utilisateur);
                }
            }
        });
    }

    private void postToServer(Utilisateur utilisateur) {
        UtilisateurService service = ApiFactory.getUtilisateurService();
        Call<Utilisateur> call = service.login(utilisateur);
        call.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                Utilisateur utilisateur1 = response.body();
                if (utilisateur1 != null) {
                    Intent intent = new Intent(ConnexionActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ConnexionActivity.this, getString(R.string.error_connexion), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Toast.makeText(ConnexionActivity.this, getString(R.string.error_connexion), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
