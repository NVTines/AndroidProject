package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class OfficialImgActivity extends AppCompatActivity {

    TextView txtImgCity, txtImgRole, txtImgName;
    ImageView imgFullSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_img);
        reference();
        Intent intent = getIntent();
        txtImgCity.setText(intent.getStringExtra("city"));
        txtImgName.setText(intent.getStringExtra("name"));
        txtImgRole.setText(intent.getStringExtra("role"));

        setBackgroundByParty(intent.getStringExtra("party"));

        setImg(intent.getStringExtra("img"));
    }

    private void reference(){
        txtImgCity =findViewById(R.id.txtImgCity);
        txtImgRole = findViewById(R.id.txtImgRole);
        txtImgName = findViewById(R.id.txtImgName);

        imgFullSize = findViewById(R.id.imgFullSize);
    }

    private void setBackgroundByParty(String party){
        switch (party) {
            case "Democratic Party":
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(OfficialImgActivity.this, R.color.blue));
                break;
            case "Republican Party":
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(OfficialImgActivity.this, R.color.red));
                break;
            case "Nonpartisan":
                getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(OfficialImgActivity.this, R.color.black));
                break;
        }
    }

    private void setImg(String img){
        if(!img.equals("")){
            Picasso picasso = new Picasso.Builder(OfficialImgActivity.this).listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    final String changedUrl = img.replace("http:", "https:");
                    picasso.load(changedUrl)
                            .error(R.drawable.broken)
                            .placeholder(R.drawable.placeholder)
                            .into(imgFullSize);
                }
            }).build();

            picasso.load(img)
                    .error(R.drawable.broken)
                    .placeholder(R.drawable.placeholder)
                    .into(imgFullSize);
        }
    }

}