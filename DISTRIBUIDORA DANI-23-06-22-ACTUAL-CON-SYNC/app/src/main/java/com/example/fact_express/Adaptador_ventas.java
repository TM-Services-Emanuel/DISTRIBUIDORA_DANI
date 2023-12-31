package com.example.fact_express;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fact_express.Modelos.Ventas;

import java.util.ArrayList;


public class Adaptador_ventas extends BaseAdapter {
    private final Context context;
    private ArrayList<Ventas> listItems;



    public Adaptador_ventas(Context context, ArrayList<Ventas> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ventas item = (Ventas) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_listarventas, null);

        TextView idventa = convertView.findViewById(R.id.tv_idventa);
        TextView timbado = convertView.findViewById(R.id.tv_timbrado);
        TextView factura = convertView.findViewById(R.id.tv_factura);
        TextView fecha = convertView.findViewById(R.id.tv_fecha);
        TextView vendedor = convertView.findViewById(R.id.tv_vendedor);
        TextView cliente = convertView.findViewById(R.id.tv_cliente);
        TextView total = convertView.findViewById(R.id.tv_total);
        TextView estado= convertView.findViewById(R.id.id_estadoV);
        TextView sync = convertView.findViewById(R.id.id_syncV);

        idventa.setText(String.valueOf(item.getId()));
        timbado.setText("Timbrado: "+item.getTimbra());
        factura.setText("Factura "+item.getCondicion()+" N°: "+item.getEst()+"-"+item.getEmision()+"-"+item.getFactura());
        fecha.setText("Fecha/Hora: "+item.getFecha());
        vendedor.setText("Vendedor: "+item.getNombre());
        cliente.setText("Nombre: "+item.getCliente()+" - RUC: "+item.getRuc());
        total.setText("TOTAL: "+String.valueOf(item.getTotal()));
        estado.setText(estado(item.getEstado()));
        if(item.getSync().equals("S")){
            sync.setText(sync(item.getSync()));
            sync.setTextColor(Color.parseColor("#008000"));

        }else if(item.getSync().equals("N")){
            sync.setText(sync(item.getSync()));
            sync.setTextColor(Color.parseColor("#FF0000"));

        }

        return convertView;
    }

    public String estado(String estado){
        String est;
        if(estado.equals("S")){
            est="";
        }else{
            est="Comprob. Anulado";
        }
        return est;
    }

    public String sync(String sync){
        String syn;
        if(sync.equals("S")){
            syn="Sincronizado";
        }else{
            syn="Sincronización Pendiente";
        }
        return syn;
    }


}
