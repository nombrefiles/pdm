package com.example.listviewarraylist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        criaContato("Pedro Files", "53999750051", R.drawable.golden2);

        ListView listView = findViewById(R.id.rvContatos);
        MeuAdaptador adaptador = new MeuAdaptador(this, R.layout.item_contato, contatos);

        listView.setAdapter(adaptador);


    }
    private void criaContato(String nome, String telefone, int foto){
        contatos.add(new Contato(nome, telefone, foto));
    }
}