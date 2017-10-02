package slorah.com.a8_ball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import me.anwarshahriar.calligrapher.Calligrapher;

public class SplashScreen extends AppCompatActivity{

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);

        //set page font
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "gabriola.ttf", true);

        gestureObject = new GestureDetectorCompat(this, new SplashScreen.LearnGesture());
        //here learnGesture is class file

    }//end onCreate

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }//end of onTouchEvent

    //now create the gesture Object class
    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        //SimpleOnGestureListener listens for what we want to do and how

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            if (event2.getX() > event1.getX()) {
                //left to right swipe
                //Nothing will happen since this is the first screen
            } else if (event2.getX() < event1.getX()) {
                //right to left swipe
                Intent myIntent = new Intent(SplashScreen.this, ContentWarningScreen.class);

                startActivity(myIntent);
                finish();
            }
            return true;
        }
    }//end LearnGesture

}
