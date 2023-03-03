package com.example.ligafootball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {
    EditText editTextNome, editTextLiga, editTextPais, editTextCampeonato;
    Button buttonConfirmarAlteracao;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        editTextLiga = findViewById(R.id.editTextNomeD);
        editTextNome = findViewById(R.id.editTextLigaD);
        editTextPais = findViewById(R.id.editTextPaisD);
        editTextCampeonato = findViewById(R.id.editTextCampeonatoD);
        buttonConfirmarAlteracao = findViewById(R.id.buttonConfirmarInclusaoD);

        Bundle bundle =  getIntent().getExtras();
        id = bundle.getInt("id");
        editTextNome.setText(bundle.getString("nome"));
        editTextLiga.setText(bundle.getString("liga"));
        editTextPais.setText(bundle.getString("pais"));
        editTextCampeonato.setText(bundle.getString("campeonato"));

        buttonConfirmarAlteracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DtoContato dtoContato= new DtoContato();
                dtoContato.setId(id);
                dtoContato.setNome(editTextNome.getText().toString());
                dtoContato.setLiga(editTextLiga.getText().toString());
                dtoContato.setPais(editTextPais.getText().toString());
                dtoContato.setCampeonato(editTextCampeonato.getText().toString());


                DaoContato daoContato =  new DaoContato(DetalhesActivity.this);
                try {
                    long linhasInseridas = daoContato.alterar(dtoContato);
                    if(linhasInseridas > 0){
                        Toast.makeText(DetalhesActivity.this, "Alterado com sucesso", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(DetalhesActivity.this, MainActivity.class);
                        startActivity(main);

                    }else{
                        Toast.makeText(DetalhesActivity.this, "Não foi possível inserir", Toast.LENGTH_SHORT).show();

                    }
                }
                catch (Exception ex){
                    Toast.makeText(DetalhesActivity.this, "Erro ao alterar: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}