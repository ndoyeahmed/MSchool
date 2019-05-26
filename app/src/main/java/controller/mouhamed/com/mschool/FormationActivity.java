package controller.mouhamed.com.mschool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationActivity extends AppCompatActivity {

    private String tabFormation[], tabDetails[];
    private String formation, details;
    private ListView listFormation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
        listFormation = findViewById(R.id.listFormation);
        tabFormation = getResources().getStringArray(R.array.tabFormation);
        tabDetails = getResources().getStringArray(R.array.tabDetails);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(FormationActivity.this, android.R.layout.simple_list_item_1, tabFormation);
        listFormation.setAdapter(adapter);
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                formation = tabFormation[position];
                details = tabDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(FormationActivity.this);
                dialog.setTitle(formation);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setMessage(details);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FormationActivity.this, InscriptionActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });
    }
}
