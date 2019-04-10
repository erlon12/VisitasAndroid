package com.example.visitasappsqlite.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.visitasappsqlite.DB.EstabelecimentoDAO;
import com.example.visitasappsqlite.R;
import com.example.visitasappsqlite.utils.Estabelecimento;

public class CadastrosEstabelecimento extends AppCompatActivity {

    EditText edt_numero, edt_cnpj, edt_razao, edt_cep, edt_idcity;
    Button btn_salvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastros_estabelecimento);

        edt_numero = (EditText) findViewById(R.id.edt_numero);

        edt_cnpj = (EditText) findViewById(R.id.edt_cnpj);

        edt_razao = (EditText) findViewById(R.id.edt_razao);

        edt_cep = (EditText) findViewById(R.id.edt_cep);

        edt_idcity= (EditText)findViewById(R.id.edt_id);


        btn_salvar = (Button)findViewById(R.id.button2);


        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EstabelecimentoDAO dao = new EstabelecimentoDAO(CadastrosEstabelecimento.this);

                Estabelecimento e = new Estabelecimento();
                int num = Integer.parseInt(edt_numero.getText().toString());
                e.setNumero(num);
                int cnpj = Integer.parseInt(edt_cnpj.getText().toString());
                e.setCnpj(cnpj);
                e.setCidade(edt_idcity.getText().toString());
                e.setRazao(edt_razao.getText().toString());
                e.setCep(edt_cep.getText().toString());

                dao.save(e);
                finish();



            }
        });
    }

    }

