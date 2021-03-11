package com.example.permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tv_Numero;
    private TextView tv_Nombre;
    private TextView tv_Correo;
    private ImageButton btnNumero;

    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Numero = (TextView) findViewById(R.id.tv_telefono);
        tv_Nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_Correo = (TextView) findViewById(R.id.tv_correo);
        btnNumero = (ImageButton) findViewById(R.id.btn_numero);
        Bundle objetoEnviado = getIntent().getExtras();
        Usuario user=null;
        if(objetoEnviado!=null){
            user = (Usuario) objetoEnviado.getSerializable("idUser");
            tv_Nombre.setText(user.getNombre() + " " + user.getApellidoP() + " " + user.getApellidoM());
            tv_Numero.setText(user.getTelefono());
            tv_Correo.setText(user.getCorreo());
        }
        btnNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = tv_Numero.getText().toString();
                if (num != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                    } else {
                        versionesAnteriores(num);
                    }
                }
            }

            private void versionesAnteriores(String num) {
                Intent intentLlamada = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
                if (verificarPermisos(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentLlamada);
                } else {
                    Toast.makeText(MainActivity.this, "Configura los permisos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];
                if (permission.equals((Manifest.permission.CALL_PHONE))) {
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        String phoneNumber = tv_Numero.getText().toString();
                        Intent intentLlamada = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        startActivity(intentLlamada);
                    } else {
                        Toast.makeText(MainActivity.this, "Configura los permisos", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }

    private boolean verificarPermisos(String permiso) {
        int resultado = this.checkCallingOrSelfPermission(permiso);
        return resultado == PackageManager.PERMISSION_GRANTED;


    }
}