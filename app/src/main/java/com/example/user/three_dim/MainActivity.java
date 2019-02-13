package com.example.user.three_dim;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private float mStartX;
    private float mStartY;

    private float mEndX;
    private float mEndY;
    int mImageIndex;

    ImageView threed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // mContext = this;
        setContentView(R.layout.activity_main);
         threed = (ImageView) findViewById(R.id.threedim);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN):

                mStartX = (int) event.getX();
                mStartY = (int) event.getY();
                return true;

            case (MotionEvent.ACTION_MOVE):

                mEndX = (int) event.getX();
                mEndY = (int) event.getY();

                if ((mEndX - mStartX) > 3) {
                    mImageIndex++;
                    if (mImageIndex > 38)
                        mImageIndex = 0;

                    threed.setImageLevel(mImageIndex);

                }
                if ((mEndX - mStartX) < -3) {
                    mImageIndex--;
                    if (mImageIndex < 0)
                        mImageIndex = 38;

                    threed.setImageLevel(mImageIndex);

                }
                mStartX = (int) event.getX();
                mStartY = (int) event.getY();
                return true;

            case (MotionEvent.ACTION_UP):
                mEndX = (int) event.getX();
                mEndY = (int) event.getY();

                return true;

            case (MotionEvent.ACTION_CANCEL):
                return true;

            //case (MotionEvent.ACTION_OUTSIDE):
              //  return true;

            default:

                return super.onTouchEvent(event);
        }
    }
}
