package com.victorbug_77816.questao2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSubmeter(View view){

        // URL PARA CONSUMO DA API REST
        String url = "https://jsonplaceholder.typicode.com/posts";

        // PARAMETROS A SEREM INSERIDOS
        String parameter =
                "{\n                                   " +
                        "   \"userId\":   UserId_Value,\n  " +
                        "   \"title\" : \"Title_Value\"\n  " +
                        "   \"body\"  : \"Body_Value\"\n   " +
                        "}                                     ";


        // ATRELA-SE OS TEXTVIEWS E EDITTEXTS DO CODIGO AOS DA ACTIVITY
        TextView edtUserId = findViewById(R.id.edtUserId);
        TextView edtTitle = findViewById(R.id.edtTitle);
        TextView edtBody = findViewById(R.id.edtBody);
        TextView txtFeedback = findViewById(R.id.txtFeedback);

        //SUBSTITUI 'VARIAVEIS' POR CADA VALOR DOS EDTTEXTS
        parameter.replace( "UserId_Value" , edtUserId.getText().toString() );
        parameter.replace( "Title_Value" , edtTitle.getText().toString() );
        parameter.replace( "Body_Value" , edtBody.getText().toString() );

        //SOLICITA A BUSCA NA URL
        new DataGetterPost(txtFeedback).execute(url,parameter);
    }
}
