package com.example.visitasappsqlite.Activitys;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.visitasappsqlite.DB.EstabelecimentoDAO;
import com.example.visitasappsqlite.R;
import com.example.visitasappsqlite.utils.Estabelecimento;
import com.example.visitasappsqlite.utils.EstabelecimentoAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton btnAdc;
    public static final int Request_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recy_view);




        btnAdc =(FloatingActionButton) findViewById(R.id.btn_flutuante);


        btnAdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CadastrosEstabelecimento.class);
                startActivityForResult(intent,Request_CODE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        readDatabase();
    }

    private void readDatabase() {

        EstabelecimentoDAO dao = new EstabelecimentoDAO(MainActivity.this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);


        List<Estabelecimento> e = dao.retornarTodos();
        recyclerView.setAdapter(new EstabelecimentoAdapter(e));

    }



    }

