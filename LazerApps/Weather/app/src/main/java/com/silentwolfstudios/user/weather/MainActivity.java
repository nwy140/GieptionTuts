package com.silentwolfstudios.user.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    double latitude = 3.1280456;
    double longtitude = 101.7543843;
    String apiKey ;
    String forecast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiKey = getResources().getString(R.string.apikey);
        forecast = "https://api.darksky.net/forecast/" + apiKey + "/" + latitude + "," + longtitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(forecast).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
                         @Override
                         public void onFailure(Call call, IOException e) {

                         }

                         @Override
                         public void onResponse(Call call, Response response) throws IOException {
                            try{
                                if(response.isSuccessful()){
                                    Log.d("Response", "Response is successful"); // this is running in background thread thus we can't kust use Toast
                                    runOnUiThread(new Runnable() { // tell the UI thread to call from the background thread
                                        @Override
                                        public void run() { // Toast
                                            Toast.makeText(MainActivity.this, "Hello World-", Toast.LENGTH_SHORT).show();

                                        }
                                    });
                                }
                                else{
                                    Log.e("Response", "Response not successful");
                                }
                                if (response.body()!=null) {
                                    Log.d("Testing", response.body().string());


                                }
                            }
                            catch (IOException e){
                                Log.e("Error Happenning", "IOException error");
                            }
                         }
                     });

    }
}
