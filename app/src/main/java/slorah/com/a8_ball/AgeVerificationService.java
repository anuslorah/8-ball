package slorah.com.a8_ball;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class AgeVerificationService extends Service {

    private final IBinder binder = new AgeVerificationBinder();

    public class AgeVerificationBinder extends Binder {
        AgeVerificationService getAgeVerifiation() {
            return AgeVerificationService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public AgeVerificationService() {
    }

    @Override
    public void onCreate() {

    }


}
