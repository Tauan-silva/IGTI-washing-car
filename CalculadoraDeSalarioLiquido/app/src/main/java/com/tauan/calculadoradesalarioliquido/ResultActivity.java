package com.tauan.calculadoradesalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mViewHolder.salarioBruto = findViewById(R.id.textValorSalarioBruto);
        mViewHolder.inss = findViewById(R.id.textValorINSS);
        mViewHolder.irrf = findViewById(R.id.textValorIRRF);
        mViewHolder.outrosDescontos = findViewById(R.id.textValorOutroDesc);
        mViewHolder.salarioLiquido = findViewById(R.id.textSalarioLiquido);
        mViewHolder.porcentDesconto = findViewById(R.id.textDesconto);

        Bundle dados = getIntent().getExtras();

        if(dados != null){
            String salBruto = dados.getString("salario_bruto");
            String salLiquido = String.valueOf(dados.getDouble("salario_liquido"));
            String outrosDescontos = dados.getString("outros_descontos");
            String inss = String.valueOf(dados.getDouble("inss"));
            String irrf = String.valueOf(dados.getDouble("irrf"));
            String totalDesconto = String.valueOf(dados.getDouble("total_desconto"));

            mViewHolder.salarioBruto.setText(salBruto);
            mViewHolder.inss.setText(inss);
            mViewHolder.irrf.setText(irrf);
            mViewHolder.outrosDescontos.setText(outrosDescontos);
            mViewHolder.porcentDesconto.setText(totalDesconto + "%");
            mViewHolder.salarioLiquido.setText(salLiquido);
        }

    }

    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public class ViewHolder {
        TextView salarioBruto, inss, irrf, outrosDescontos, porcentDesconto, salarioLiquido;
    }
}

