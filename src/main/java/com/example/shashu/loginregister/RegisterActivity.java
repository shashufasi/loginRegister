package com.example.shashu.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    //~~~~~~~~~~~~~Fields~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //button fields
    private Button btnCancel;
    private Button btnConfirm;

    //EditText fields
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;

    //TextView Fields
    private TextView txtViewInvalidEmail;
    private TextView txtViewInvalidPassword;
    private TextView txtViewInvalidConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //getting IDs in Fields
        editTextEmail = findViewById(R.id.txtEmailReg);
        editTextPassword = findViewById(R.id.txtPasswordReg);
        editTextConfirmPassword=findViewById(R.id.txtConfirmPassword);
        txtViewInvalidEmail = findViewById(R.id.txtInvalidEmail);
        txtViewInvalidPassword = findViewById(R.id.txtInvalidPassword);
        txtViewInvalidConfirmPassword = findViewById(R.id.txtInvalidConfirmPassword);
        btnCancel = findViewById(R.id.btnCancel);
        btnConfirm = findViewById(R.id.btnConfirm);


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Action Listeners(Click Events)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //Cancel Button Click Event
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                goBackLoginActivity();
            }
        });

        //Confirm Button Click Event
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String getEmail = editTextEmail.getText().toString();
                String getPassword = editTextPassword.getText().toString();
                String getConfirmPassword=editTextConfirmPassword.getText().toString();
                String expn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
                if (getEmail.matches(expn) && getEmail.length() > 0) {
                    txtViewInvalidEmail.setText("");
                } else

                {
                    txtViewInvalidEmail.setText("Invalid Email");
                }
                if (getPassword.length() > 4) {
                    txtViewInvalidPassword.setText("");
                } else {
                    txtViewInvalidPassword.setText("Short Password");
                }
                if(getConfirmPassword.matches(getPassword))
                {
                    txtViewInvalidConfirmPassword.setText("");
                }
                else
                {
                    txtViewInvalidConfirmPassword.setText("Password Does not Match");
                }
                registerNew();
            }
        });
    }

    //Go Back Function which Called from Cancel Button Event
    public void goBackLoginActivity() {

        //Back to Login Activity
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    //New Person Registered Function
    public void registerNew() {

    }

}
