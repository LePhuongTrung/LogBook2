package com.demo.retrofit.logbook2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    int check;
    List<String> url;
    TextInputLayout urlEnter;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);
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
        Glide.with(MainActivity.this)
                .load(url.get(i))
                .centerCrop()
                .into(img);
    }

    public void nextImg(View view){
        i++;
        if (i >=url.size())
            i = 0;
        extracted();
    }

    public void previousImg(View view){
        i--;
        if (i <0)
            i = url.size() -1;
        extracted();
    }
    public void addLink(View view){
        urlEnter = findViewById(R.id.textInputLayout);

        url.add(urlEnter.getEditText().getText().toString());
        if (check < url.size()){
            Toast.makeText(this, "Add Succeed", Toast.LENGTH_SHORT).show();
            i = url.size() -1;
            extracted();
        } else {
            Toast.makeText(this, "Add Fail", Toast.LENGTH_SHORT).show();
        }
    }
}