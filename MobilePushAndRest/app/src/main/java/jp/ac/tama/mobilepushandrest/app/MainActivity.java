package jp.ac.tama.mobilepushandrest.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jp.ac.tama.mobilepushandrest.app.entity.DeviceToken;
import jp.ac.tama.mobilepushandrest.app.restInterface.DeviceRegisterAPI;
import jp.ac.tama.mobilepushandrest.app.util.DeviceTokenAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;

public class MainActivity extends Activity {
    private GoogleCloudMessaging gcm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gcm = GoogleCloudMessaging.getInstance(getBaseContext());
        register();
    }

    private void register(){
        new AsyncTask(){
            protected Object doInBackground(final Object... params) {
                String token;
                String projectNumber = getString(R.string.project_number);
                Log.i("ProjectNumber", projectNumber);
                try {
                    token = gcm.register(projectNumber);
                    // JSONのパーサー
//                    DeviceToken deviceToken = new DeviceToken();
//                    deviceToken.deviceToken = token;
//                    Gson gson = new GsonBuilder()
//                            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                            .registerTypeAdapter(DeviceToken.class,new DeviceTokenAdapter())
//                            .create();
//
//                    // RestAdapterの生成
//                    RestAdapter adapter = new RestAdapter.Builder()
//                            .setEndpoint("http://192.168.11.100:3000")
//                            .setConverter(new GsonConverter(gson))
//                            .setLogLevel(RestAdapter.LogLevel.FULL)
//                            .setLog(new AndroidLog("=NETWORK="))
//                            .build();
//                    adapter.create(DeviceRegisterAPI.class).register(deviceToken)
//                            .subscribeOn(Schedulers.newThread())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Observer<Boolean>() {
//                                @Override
//                                public void onCompleted() {
//                                    Log.d("MainActivity", "onCompleted()");
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    Log.e("MainActivity", "Error : " + e.toString());
//                                }
//
//                                @Override
//                                public void onNext(Boolean result) {
//                                    Log.d("MainActivity", "onNext()");
//                                    if(result){
//                                        Log.d("MainActivity","Register successful");
//                                    }
//                                }
//                            });

                    Log.i("registrationId", token);
                }
                catch (IOException e) {
                    Log.i("Registration Error", e.getMessage());
                }

                return true;
            }
        }.execute(null, null, null);
    }
}
