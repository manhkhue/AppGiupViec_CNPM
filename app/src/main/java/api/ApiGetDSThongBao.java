package api;

import android.os.AsyncTask;

import java.io.IOException;

import interfaces.getDSThongBaoFromApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiGetDSThongBao extends AsyncTask<Void,Void,Void> {
    String data;
    getDSThongBaoFromApi getDSThongBao;
    public ApiGetDSThongBao(getDSThongBaoFromApi getDSThongBao){
        this.getDSThongBao = getDSThongBao;
        this.getDSThongBao.Start();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url("https://webdoctruyent5.000webhostapp.com/layDSThongBao.php").build();
        data = null;
        try {
            Response response =client.newCall(request).execute();
            ResponseBody body =response.body();
            data =body.string();
        }
        catch (IOException a){
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        if(data ==null){
            this.getDSThongBao.Error();
        }
        else {
            this.getDSThongBao.End(data);
        }
    }
}
