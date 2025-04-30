package com.example.bergagame;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int level = 0;

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

        int[] numbers = new int[9];
        Random random = new Random();

        int i = 0;

        while (i < numbers.length) {
            int numero = random.nextInt(300);

            boolean repeated = false;
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numero) {
                    repeated = true;
                    break;
                }
            }

            if (!repeated) {
                numbers[i] = numero;
                i++;
            }
        }


        Arrays.sort(numbers);

        TextView txtCount = findViewById(R.id.txtCount);
        ImageView imgBerga = findViewById(R.id.imageView);

        imgBerga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                txtCount.setText(String.valueOf(count));

                if (level < numbers.length && count == numbers[level]) {
                    level++;

                    String imageName = "level" + level;
                    int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());

                    imgBerga.setImageResource(resId);
                }
            }
        });
    }
}