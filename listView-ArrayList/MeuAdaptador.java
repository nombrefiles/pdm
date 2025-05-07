package com.example.listviewarraylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MeuAdaptador extends ArrayAdapter<Contato> {
    public MeuAdaptador(@NonNull Context context, int resource, @NonNull ArrayList<Contato> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contato, parent, false);

        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtFone = convertView.findViewById(R.id.txtFone);
        ImageView imgFoto = convertView.findViewById(R.id.ivFoto);

        Contato contato = getItem(position);

        txtFone.setText(contato.telefone);
        txtNome.setText(contato.nome);
        imgFoto.setImageResource(contato.foto);

        return convertView;
    }
}
