package jp.ac.tama.mobilepushandrest.app;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by KAJIWARAYutaka on 2015/07/06.
 */
public class ExternalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        String messageType = gcm.getMessageType(intent);
        if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
            Log.v("GcmReceiver","Send error:"+intent.getExtras().toString());
        } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED .equals(messageType)) {
            Log.v("GcmReceiver","Deleted messages:"+intent.getExtras().toString());
        } else {
            Log.v("GcmReceiver","Received:"+intent.getExtras().toString());
            // メッセージビュー
            TextView tv = new TextView(context);
            tv.setTextSize(20.0f);
            tv.setTextColor(Color.WHITE);
            tv.setText( intent.getExtras().toString());
            // リニアレイアウト上に、作成したビューを並べる
            LinearLayout ll = new LinearLayout(context);
            ll.setOrientation( LinearLayout.HORIZONTAL );
            ll.setGravity( Gravity.CENTER );
            ll.addView(tv);

            // トーストを作成し、今作ったビューをセットする
            Toast toast = new Toast(context);
            toast.setView(ll);
            toast.setGravity( Gravity.CENTER, 0, 0 );
            toast.setDuration(Toast.LENGTH_LONG);

            View v = toast.getView();
            v.setBackgroundColor(Color.rgb(30, 30, 30));

            toast.show();

        }
        setResultCode(Activity.RESULT_OK);
    }
}
