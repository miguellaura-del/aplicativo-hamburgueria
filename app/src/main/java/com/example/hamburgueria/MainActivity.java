package com.example.hamburgueria;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    private CheckBox chkWagyu, chkClassic, chkSmokey, chkPortobello;
    private CheckBox chkBatata, chkBacon, chkCheddar, chkCebola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Mapeamento dos Hambúrgueres
        chkWagyu = findViewById(R.id.chkWagyu);
        chkClassic = findViewById(R.id.chkClassic);
        chkSmokey = findViewById(R.id.chkSmokey);
        chkPortobello = findViewById(R.id.chkPortobello);


        // Mapeamento dos Acompanhamentos/Ingredientes
        chkBatata = findViewById(R.id.chkBatata);
        chkBacon = findViewById(R.id.chkBacon);
        chkCheddar = findViewById(R.id.chkCheddar);
        chkCebola = findViewById(R.id.chkCebola);


        Button btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }


    private void calcularTotal() {
        double total = 0.0;


        // Soma Hambúrgueres
        if (chkWagyu.isChecked()) total += 38.00;
        if (chkClassic.isChecked()) total += 32.00;
        if (chkSmokey.isChecked()) total += 35.00;
        if (chkPortobello.isChecked()) total += 30.00;


        // Soma Acompanhamentos
        if (chkBatata.isChecked()) total += 14.90;
        if (chkBacon.isChecked()) total += 6.50;
        if (chkCheddar.isChecked()) total += 4.90;
        if (chkCebola.isChecked()) total += 5.20;


        String mensagem = String.format(Locale.getDefault(), "Total do Pedido: R$ %.2f", total);


        Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
    }
}

