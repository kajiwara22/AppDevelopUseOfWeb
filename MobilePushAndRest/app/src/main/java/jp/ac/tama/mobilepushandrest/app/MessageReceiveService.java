package jp.ac.tama.mobilepushandrest.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/**
 * Created by KAJIWARAYutaka on 2015/07/06.
 */
public class MessageReceiveService  extends Service {


    public static void sendToApp(Bundle extras, Context context){
        Intent newIntent = new Intent();
        newIntent.setClass(context, MainActivity.class);
        newIntent.putExtras(extras);
        newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
    }
    public void onCreate(){
        super.onCreate();
        sendToApp(new Bundle(), this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
