package com.example.pizzapizza;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
        private RadioButton pequena;
        private RadioButton media;
        private RadioButton grande;
        private RadioButton cartao;
        private RadioButton dinheiro;
        private int total;
        private String stotal;
        private Button btnTerminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        pequena = findViewById(R.id.pequena);
        media = findViewById(R.id.media);
        grande = findViewById(R.id.grande);
        cartao = findViewById(R.id.cartao);
        dinheiro = findViewById(R.id.dinheiro);
        btnTerminar = findViewById(R.id.btnTerminar);

        Bundle bundle = getIntent().getExtras();
        stotal = bundle.getString("total");
        total = Integer.parseInt(stotal);

        btnTerminar.setOnClickListener(view ->{
            Intent intent = new Intent(this,MainActivity3.class);

            if (!pequena.isChecked() && !media.isChecked() && !grande.isChecked()) {
                pequena.setError("Selecione um tamanho de pizza");
                media.setError("Selecione um tamanho de pizza");
                grande.setError("Selecione um tamanho de pizza");
                return;
            }

            if (!cartao.isChecked() && !dinheiro.isChecked()) {
                cartao.setError("Selecione uma forma de pagamento");
                dinheiro.setError("Selecione uma forma de pagamento");
                return;
            }
            if (pequena.isChecked()){
                intent.putExtra("tamanho", "pequena");
                total += 30;
            }
             else if (media.isChecked()){
                intent.putExtra("tamanho", "media");
                total += 40;
            }
             else if( grande.isChecked()){
                intent.putExtra("tamanho", "grande");
            }
             if (cartao.isChecked()){
                intent.putExtra("metodo", "cartao");
             }
             else if(dinheiro.isChecked()){
                intent.putExtra("metodo", "dinheiro");
            }
                intent.putExtra("sabores", getIntent().getStringExtra("sabores"));
                intent.putExtra("total", String.valueOf(total));
                startActivity(intent);

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}