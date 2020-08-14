package com.laucherish.myanimator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                scale();
                alpha();
            }
        });
    }

    private void scale() {
        MyObjectAnimator animator = MyObjectAnimator.ofFloat(text, "scaleX", 1, 2, 1);
        animator.setDuration(3000);
        animator.setInterpolator(new LineInterpolator());
        animator.start();
    }

    private void alpha() {
        MyObjectAnimator animator = MyObjectAnimator.ofFloat(text, "alpha", 1, 0, 1);
        animator.setDuration(3000);
        animator.setInterpolator(new LineInterpolator());
        animator.start();
    }
}
