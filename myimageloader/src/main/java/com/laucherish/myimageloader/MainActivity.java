package com.laucherish.myimageloader;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.laucherish.myimageloader.imageloader.ImageLoader;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String url = "http://image.mhxk.com/feature/1743848_2_1.jpg-noresize.webp";

    private ImageView iv1,iv2,iv3, iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);

        ImageLoader.getInstance().displayImage(url, iv1);
    }

    public void onClick2(View view) {
        ImageLoader.getInstance().displayImage(url, iv2);
    }

    public void onClick3(View view) {
        ImageLoader.getInstance().displayImage(url, iv3);
    }
}
