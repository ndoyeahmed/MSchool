package controller.mouhamed.com.mschool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class InscriptionActivity extends AppCompatActivity {

    /*private EditText txtFirstName, txtLastName;
    private CheckBox cbOLevel, cbBachelor, cbMaster;
    private String firstName, lastName;*/
//    private String degrees;
    private ArrayList<String> degreesListes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        final EditText txtFirstName = findViewById(R.id.txtFirstName);
        final EditText txtLastName = findViewById(R.id.txtLastName);
        final Button btnSave = findViewById(R.id.btn_save);
        final CheckBox cbBachelor = findViewById(R.id.cbBachelor);
        final CheckBox cbMaster = findViewById(R.id.cbMaster);
        final CheckBox cbOLevel = findViewById(R.id.cbOLevel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = txtFirstName.getText().toString();
                String lastName = txtLastName.getText().toString();
                System.out.println(firstName);
                System.out.println(lastName);
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
