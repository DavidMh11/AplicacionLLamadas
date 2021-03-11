package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Usuario usuario;
    Button btn_registrarse;
    Button btn_login;
    EditText edTCorreo;
    EditText edTPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_registrarse = (Button) findViewById(R.id.btn_registrarse);
        btn_login = (Button) findViewById(R.id.btn_login);
        edTCorreo = (EditText) findViewById(R.id.edTCorreo);
        edTPassword = (EditText) findViewById(R.id.edTPassword);

        Bundle objetoEnviado = getIntent().getExtras();
        Usuario user=null;
        if(objetoEnviado!=null){
            user = (Usuario) objetoEnviado.getSerializable("usuario");
            edTCorreo.setText(user.getCorreo());
            edTPassword.setText(user.getContraseña());
            usuario = user;
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                if(usuario!=null) {
                    if (usuario.getCorreo().equals(edTCorreo.getText().toString()) && usuario.getContraseña().equals(edTPassword.getText().toString())) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("idUser",usuario);
                        main.putExtras(bundle);
                        startActivity(main);
                    } else {
                        Toast.makeText(getApplicationContext(),"Datos incorrectos", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Completa los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(LoginActivity.this, RegistrarseActivity.class);
                startActivity(registrarse);
            }
        });
    }
}