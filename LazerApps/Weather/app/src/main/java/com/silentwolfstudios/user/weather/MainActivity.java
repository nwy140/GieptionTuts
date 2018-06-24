package com.silentwolfstudios.user.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
    String apiKey;
    String forecast;

    private TextView tvWeather;
    private CurrentWeather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiKey = getResources().getString(R.string.apikey);
        forecast = "https://api.darksky.net/forecast/" + apiKey + "/" + latitude + "," + longtitude;
        tvWeather = findViewById(R.id.tvWeather);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(forecast).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                alertDialog();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if (response.body() != null) {
                       getCurrentWeather(response.body().string()); // calling response body .string twice crashes the app, you can't request the body twice
                    }
                    if (response.isSuccessful()) {
                        Log.d("Response", "Response is successful"); // this is running in background thread thus we can't kust use Toast
                        runOnUiThread(new Runnable() { // tell the UI thread to call from the background thread
                            @Override
                            public void run() { // Toast
                                tvWeather.setText("Testing");
                            }
                        });
                    } else {
                        Log.e("Response", "Response not successful");
                    }
                } catch (IOException e) {
                    Log.e("Error Happenning", "IOException error");

                } catch (JSONException e){ //exeption caught when passed in data is not JSON
                    Log.e("Error Happening", "JSONException error");
                }
            }
        });
    }

    private CurrentWeather getCurrentWeather(String jsonData) throws JSONException{ // throws exeptiom when passed data is not json format
        JSONObject forecast = new JSONObject(jsonData);
        double lat = forecast.getDouble("latitude"); // get latitude's data from JSONOBject passed in
        Log.d("lat value", Double.toString(lat));

        return null;
    }

    private void alertDialog() {
        AlertDialogFragment dialog = new AlertDialogFragment();  //dialog fragment is the dialog that shows up in the activity
        dialog.show(getFragmentManager(), "errorDialog");
    }
}