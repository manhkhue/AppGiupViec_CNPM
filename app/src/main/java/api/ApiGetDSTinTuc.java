package api;

import android.os.AsyncTask;

import java.io.IOException;

import interfaces.getDSTinTucFromApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiGetDSTinTuc extends AsyncTask<Void,Void,Void> {
    String data;
    getDSTinTucFromApi getDSTinTuc;
    public ApiGetDSTinTuc(getDSTinTucFromApi getDSTinTuc){
        this.getDSTinTuc = getDSTinTuc;
        this.getDSTinTuc.Start();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url("https://webdoctruyent5.000webhostapp.com/layDSTinTuc.php").build();
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
    protected void onPostExecute(Void aVoid) {
        if(data ==null){
            this.getDSTinTuc.Error();
        }
        else {
            this.getDSTinTuc.End(data);
        }
    }
}
