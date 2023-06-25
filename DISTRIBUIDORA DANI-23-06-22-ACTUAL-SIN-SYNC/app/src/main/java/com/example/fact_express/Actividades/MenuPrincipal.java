package com.example.fact_express.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fact_express.MainActivity;
import com.example.fact_express.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MenuPrincipal extends AppCompatActivity {
    private int idvendedor;
    private String vendedor;
    private TextView txtbienvenida,txtidvendedor, txtvendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtidvendedor = findViewById(R.id.id_idvendedor);
        txtvendedor = findViewById(R.id.id_vendedor);
        txtbienvenida = findViewById(R.id.id_bienvenido);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            idvendedor = bundle.getInt("idVendedor");
            vendedor= bundle.getString("Vendedor");
        }
        txtidvendedor.setText(String.valueOf(idvendedor));
        txtvendedor.setText(vendedor);
        txtbienvenida.setText("Bienvenido "+vendedor+", comencemos a trabajar!");

    }

    public void irOpcionesMantenimieto(View view){
        Intent i = new Intent( this, Opciones_Mantenimiento.class);
        startActivity(i);
    }

    public void irOpcionesSincronizacion(View view){
        Intent i = new Intent( this, Listar_Sync.class);
        startActivity(i);
    }


    public void irClientes(View view){
        Intent i = new Intent( this, Listar_Clientes.class);
        startActivity(i);
    }

    public void irProductos(View view){
        Intent i = new Intent( this, Listar_Productos.class);
        startActivity(i);
    }

    public void irVenta(View view){
        Intent i = new Intent( this, Listar_ClientesVenta.class);
        i.putExtra("R","N");
        i.putExtra("idVendedor",txtidvendedor.getText());
        i.putExtra("Vendedor",txtvendedor.getText());
        startActivity(i);
    }
    public void irListarVentas(View view){
        Intent i = new Intent( this, Listar_ventas.class);
        i.putExtra("idVendedor",txtidvendedor.getText());
        i.putExtra("Vendedor",txtvendedor.getText());
        startActivity(i);
    }

    public void CerrarSesion(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("¿Esta seguro que desea salir de esta aplicación cerrando sesión por completo?");
        alertDialog.setTitle("CERRAR SESIÓN");
        alertDialog.setIcon(R.drawable.ic_salir_light);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("SI, SALIR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Intent i = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(i);
                txtidvendedor.setText("");
                txtvendedor.setText("");
                txtbienvenida.setText("");
                finish();
            }
        });
        alertDialog.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //Toast.makeText(this, "Una sesión se encuentra iniciada.\n\nCierre Sesión si desea finalizar las operaciones.", Toast.LENGTH_SHORT).show();
        Snackbar.make(findViewById(R.id.linearLayout26), "UNA SESIÓN SE ENCUENTRA INICIADA.\nCierre Sesión si desea finalizar las operaciones.", Snackbar.LENGTH_SHORT)
                .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                .setBackgroundTint(Color.parseColor("#FF6F00")).show();
    }
}