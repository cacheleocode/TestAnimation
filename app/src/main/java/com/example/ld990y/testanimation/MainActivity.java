package com.example.ld990y.testanimation;

import android.animation.AnimatorListenerAdapter;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.view.KeyEvent;
import android.view.View;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

public class MainActivity extends AppCompatActivity {
    private TextView testTextView;
    private View testShapeView;
    private String OriginalText;
    private Integer OriginalWidth;
    private String NewText;
    private Integer NewWidth;
    private ValueAnimator widthAnimator;

    private AnimatedVectorDrawable saveIconAVD;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveIconAVD = (AnimatedVectorDrawable) getDrawable(R.drawable.save_icon);
        image = (ImageView) findViewById(R.id.imageView);

        image.setImageDrawable(saveIconAVD);


        testTextView = findViewById(R.id.testTextView);

        testShapeView = findViewById(R.id.testShapeView);

        OriginalText = "Bookmark This";

        OriginalWidth = 200;

        NewText = "Remove from Bookmarks";

        NewWidth = 400;


        testTextView.setText(OriginalText);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                return true;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d("test", "well then");



                if (testTextView.getText() == OriginalText) {
                    saveIconAVD.start();

                    testShapeView.animate()
                            .scaleX((float) 2)
                            .setDuration(150)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    testShapeView.animate()
                                            .scaleX((float) 1.8)
                                            .setDuration(75);

                                    testTextView.setText(NewText);
                                }
                            });
                } else {
                    saveIconAVD.start();


                    testShapeView.animate()
                            .scaleX((float) 2)
                            .setDuration(150)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    testShapeView.animate()
                                            .scaleX(1)
                                            .setDuration(75);

                                    testTextView.setText(OriginalText);
                                }
                            });
                }





                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
}
