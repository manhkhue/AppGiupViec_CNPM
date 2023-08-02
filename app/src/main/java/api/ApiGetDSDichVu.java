package api;

import android.os.AsyncTask;

import java.io.IOException;

import interfaces.getDSDichVuFromApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiGetDSDichVu extends AsyncTask<Void,Void,Void> {
    String data;
    getDSDichVuFromApi getDSDichVu;

    public ApiGetDSDichVu(getDSDichVuFromApi getDSDichVu){
        this.getDSDichVu =getDSDichVu;
        this.getDSDichVu.Start();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url("https://webdoctruyent5.000webhostapp.com/layDSDichVu.php").build();
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
            this.getDSDichVu.Error();
        }
        else {
            this.getDSDichVu.End(data);
        }
    }
}
