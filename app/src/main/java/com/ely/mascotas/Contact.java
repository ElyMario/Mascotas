package com.ely.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Contact extends AppCompatActivity {

    private Toolbar toolbar;

    TextInputEditText tit_Nombre;
    TextInputEditText tit_email;
    TextInputEditText tit_message;
    MaterialButton btn_SendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        tit_Nombre = (TextInputEditText) findViewById(R.id.tit_Nombre);
        tit_email = (TextInputEditText) findViewById(R.id.tit_email);
        tit_message = (TextInputEditText) findViewById(R.id.tit_message);
        btn_SendEmail = (MaterialButton) findViewById(R.id.btn_SendEmail); 

        Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

        btn_SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();

               /* Intent intent = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("mailto:" + tit_email.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, tit_Nombre.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, tit_message.getText().toString());
                startActivity(intent);*/
            }
        });
    }

    private void sendEmail() {
        String mail = tit_email.getText().toString().trim();
        String message = tit_message.getText().toString().trim();
        String subject = tit_Nombre.getText().toString().trim();

        //Ahora enviaremos el mail

        JavaMailApi javaMailApi = new JavaMailApi(this,mail,subject,message);
        javaMailApi.execute();

    }
}