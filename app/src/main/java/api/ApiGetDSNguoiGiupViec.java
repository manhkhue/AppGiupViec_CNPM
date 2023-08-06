package api;

import android.os.AsyncTask;

import java.io.IOException;

import interfaces.getDSNguoiGiupViecFromApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiGetDSNguoiGiupViec extends AsyncTask<Void,Void,Void> {
    String tenNGV;
    String data;
    getDSNguoiGiupViecFromApi getDSNguoiGiupViec;

    public ApiGetDSNguoiGiupViec(getDSNguoiGiupViecFromApi getDSNguoiGiupViec, String tenNGV){
        this.tenNGV = tenNGV;
        this.getDSNguoiGiupViec = getDSNguoiGiupViec;
        this.getDSNguoiGiupViec.Start();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder().url("https://webdoctruyent5.000webhostapp.com/layDSNhanVien.php?tenNGV="+tenNGV).build();
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
        if (data==null)
        {
            this.getDSNguoiGiupViec.Error();
        }
        else {
            this.getDSNguoiGiupViec.End(data);
        }
    }
}
