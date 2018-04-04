package util.android.speak;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SpeakService extends Service {

    boolean isRunning;

    @Override
    public void onCreate() {
        super.onCreate();
        isRunning = false;
    }

    public SpeakService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!isRunning){
            isRunning = true;
            Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(isRunning){
            isRunning = false;
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
