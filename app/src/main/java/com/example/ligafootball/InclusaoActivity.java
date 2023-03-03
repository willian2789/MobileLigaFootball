package com.example.ligafootball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InclusaoActivity extends AppCompatActivity {

    EditText editTextNome, editTextLiga, editTextPais, editTextCampeonato;
    Button buttonConfirmarInclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusao);
        editTextNome = findViewById(R.id.editTextNome);
        editTextLiga = findViewById(R.id.editTextLiga);
        editTextPais = findViewById(R.id.editTextPais);
        editTextCampeonato = findViewById(R.id.editTextCampeonato);
        buttonConfirmarInclusao = findViewById(R.id.buttonConfirmarInclusao);

        buttonConfirmarInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adicionar no banco

                DtoContato dtoContato= new DtoContato();
                dtoContato.setNome(editTextNome.getText().toString());
                dtoContato.setLiga(editTextLiga.getText().toString());
                dtoContato.setPais(editTextPais.getText().toString());
                dtoContato.setCampeonato(editTextCampeonato.getText().toString());

                DaoContato daoContato =  new DaoContato(InclusaoActivity.this);
                try {
                    long linhasInseridas = daoContato.inserir(dtoContato);
                    if(linhasInseridas > 0){
                        Toast.makeText(InclusaoActivity.this, "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(InclusaoActivity.this, MainActivity.class);
                        startActivity(main);

                    }else{
                        Toast.makeText(InclusaoActivity.this, "Não foi possível inserir", Toast.LENGTH_SHORT).show();

                    }
                }
                catch (Exception ex){
                    Toast.makeText(InclusaoActivity.this, "Erro ao inserir: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}