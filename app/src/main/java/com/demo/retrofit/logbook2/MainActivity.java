package com.demo.retrofit.logbook2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    int check;
    ArrayList<String> url;
    TextInputLayout urlEnter;
    TextView numberPage;

    int i = 0;
    int current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEnter = findViewById(R.id.textInputLayout);
        img = findViewById(R.id.imageView);
        numberPage = findViewById(R.id.textView);

        url = new ArrayList<String>();
        url.add("https://wallpaper.dog/large/5531074.png");
        url.add("https://wallpaper.dog/large/5531110.jpg");
        url.add("https://wallpaper.dog/large/5531114.png");
        url.add("https://wallpaper.dog/large/5531129.jpg");
        url.add("https://wallpaper.dog/large/5531132.jpg");
        url.add("https://wallpaper.dog/large/5531138.jpg");
        url.add("https://wallpaper.dog/large/5531169.jpg");
        url.add("https://wallpaper.dog/large/5531183.jpg");

        check = url.size();
        extracted();
    }

    private void extracted() {
        Picasso.get()
                .load(url.get(i))
                .into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.i("numberPage:", String.valueOf(i));
                    }

                    @Override
                    public void onError(Exception e) {
                        url.remove(url.get(i));
                        i = current;
                        Toast.makeText(MainActivity.this, "Url not return Img", Toast.LENGTH_SHORT).show();
                        extracted();
                    }
                });
        numberPage.setText((i+1)+"/"+url.size());
    }

    public void nextImg(View view){
        i++;
        if (i >=url.size())
            i = 0;
        current = i;
        extracted();
    }

    public void previousImg(View view){
        i--;
        if (i <0)
            i = url.size() -1;
        current = i;
        extracted();
    }
    public void addLink(View view){
        String urlStr = urlEnter.getEditText().getText().toString();
        url.add(urlStr);
        if (check < url.size()){
            i = url.size() -1;
            extracted();
        } else {
            Toast.makeText(this, "Add to ArrayList Fail", Toast.LENGTH_SHORT).show();
        }
    }

}