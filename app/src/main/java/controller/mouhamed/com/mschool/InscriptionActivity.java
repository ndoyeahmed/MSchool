package controller.mouhamed.com.mschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class InscriptionActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName;
    private Button btnSave;
    private CheckBox cbOLevel, cbBachelor, cbMaster;
    private String firstName, lastName;
    private String degrees;
    private ArrayList<String> degreesListes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        btnSave = findViewById(R.id.btn_save);
        cbBachelor = findViewById(R.id.cbBachelor);
        cbMaster = findViewById(R.id.cbMaster);
        cbOLevel = findViewById(R.id.cbOLevel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = txtFirstName.getText().toString();
                lastName = txtLastName.getText().toString();
                if (degreesListes != null) {
                    degreesListes.clear();
                } else {
                    degreesListes = new ArrayList<>();
                }
                if (cbMaster.isChecked()) {
                    degreesListes.add(getString(R.string.master));
                }
                if (cbBachelor.isChecked()) {
                    degreesListes.add(cbBachelor.getText().toString());
                }
                if (cbOLevel.isChecked()) {
                    degreesListes.add(cbOLevel.getText().toString());
                }
            }
        });

    }
}
