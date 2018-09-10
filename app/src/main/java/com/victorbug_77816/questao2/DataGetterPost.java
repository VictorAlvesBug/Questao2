package com.victorbug_77816.questao2;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String,Void,String> {


    private TextView txtFeedback;

    public DataGetterPost(TextView txtFeedback) {
        this.txtFeedback = txtFeedback;
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetworkToolkit.doPost(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try
        {
            //OBJETO SJON
            JSONObject jsonResponse = new JSONObject(s);

            //RETORNA O id DO OBJETO JSON
            String id = jsonResponse.getString("id");

            //RETORNA FEEDBACK
            txtFeedback.setText("Sucesso! ID: " + id);
        }
        catch(JSONException e){
            //CASO OCORRA ERRO, INFORMA QUAL É O ERRO
            this.txtFeedback.setText(e.toString());
        }
    }
}
