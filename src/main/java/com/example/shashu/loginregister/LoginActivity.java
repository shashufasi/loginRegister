package com.example.shashu.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btnReg;
    private Button btnLogin;
    private EditText editTxtEmail;
    private EditText editTxtPassword;
    private TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTxtEmail=findViewById(R.id.txtEmail);
        editTxtPassword=findViewById(R.id.txtPassword);
        textViewMessage=findViewById(R.id.txtViewMessage);
        btnLogin=findViewById(R.id.btnLogin);
        btnReg= findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String getText=editTxtEmail.getText().toString();
                String getPassword=editTxtPassword.getText().toString();
                String expn="^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
                if(getText.matches(expn) && getText.length()>0 && getPassword.length()>4)
                {
                    textViewMessage.setText("Valid Email");
                }
                else
                {
                    textViewMessage.setText("Invalid Email Or Password");
                }
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view)
           {
               openRegisterActivity();
           }
        });
    }
    public void openRegisterActivity()
    {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
