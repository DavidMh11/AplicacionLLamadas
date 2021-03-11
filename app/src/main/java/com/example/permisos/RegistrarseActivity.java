package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {

    Button btn_registrarse;
    EditText edTCorreo;
    EditText edTContraseña;
    EditText edTNombre;
    EditText edTapellidoP;
    EditText edTapellidoM;
    EditText edTTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        btn_registrarse = (Button) findViewById(R.id.btn_registrarse);
        edTCorreo = (EditText) findViewById(R.id.edTCorreo);
        edTContraseña = (EditText) findViewById(R.id.edTContraseña);
        edTNombre = (EditText) findViewById(R.id.edTNombre);
        edTapellidoP = (EditText) findViewById(R.id.edTApellidoP);
        edTapellidoM = (EditText) findViewById(R.id.edTApellidoM);
        edTTelefono = (EditText) findViewById(R.id.edTtTelefono);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Usuario user = new Usuario(
                            edTNombre.getText().toString(),
                            edTapellidoP.getText().toString(),
                            edTapellidoM.getText().toString(),
                            edTCorreo.getText().toString(),
                            edTContraseña.getText().toString(),
                            edTTelefono.getText().toString()
                    );
                    Intent login = new Intent(RegistrarseActivity.this, LoginActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario",user);
                    login.putExtras(bundle);
                    startActivity(login);
            }
        });
    }
}