package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //recibir datos de layout
        EditText txt1 = findViewById(R.id.num1);
        EditText txt2 = findViewById(R.id.num2);
        TextView txt3 = findViewById(R.id.result);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = txt1.getText().toString();
                String num2 = txt2.getText().toString();

                if (txt1.getText().toString().isEmpty() || txt2.getText().toString().isEmpty())
                {
                    Toast mytoast = Toast.makeText(getApplicationContext(), "INGRESE TODOS LOS VALORES", Toast.LENGTH_LONG );
                    mytoast.show();
                }

                int resul = Integer.parseInt(num1) + Integer.parseInt(num2);
                txt3.setText("EL RESULTADO ES:" + resul);
                txt1.setText("");
                txt2.setText("");


            }




        });








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}