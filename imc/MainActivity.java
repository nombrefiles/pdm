package com.example.imc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

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

        EditText etWeight = findViewById(R.id.etWeight);
        EditText etHeight = findViewById(R.id.etHeight);
        Button btnResult = findViewById(R.id.btnResult);
        TextView txtResult = findViewById(R.id.txtResult);
        ImageView img = findViewById(R.id.imgIMC);
        TextView txtCategory = findViewById(R.id.txtCategory);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTE", v.toString());

                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                float result = weight / (height * height);

                txtResult.setText("IMC = " + result);

                if (result < 18.5){
                    img.setImageResource(R.drawable.magro);
                    txtCategory.setText("Abaixo do peso");
                } else if (result >= 40){
                    img.setImageResource(R.drawable.obesidademorbida);
                    txtCategory.setText("Obeso Mórbido");
                } else if (result >= 18.5 && result < 25){
                    img.setImageResource(R.drawable.normal);
                    txtCategory.setText("Peso ideal");
                } else if (result >= 25 && result < 30){
                    img.setImageResource(R.drawable.sobrepeso);
                    txtCategory.setText("Sobrepeso");
                } else if (result >= 30 && result < 35){
                    img.setImageResource(R.drawable.obesomoderado);
                    txtCategory.setText("Obeso nível I");
                } else if (result >= 35 && result < 40){
                    img.setImageResource(R.drawable.obeso);
                    txtCategory.setText("Obeso nível II");
                }
            }
        });
    }
}