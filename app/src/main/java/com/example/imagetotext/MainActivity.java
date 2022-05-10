package com.example.imagetotext;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    Button getText;
    String uriString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              imageView=findViewById(R.id.imageView);
        Button select=findViewById(R.id.select);
        getText=findViewById(R.id.gettext);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });
        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, textScreen.class);
                intent.putExtra("uri", uriString);
                startActivity(intent);
            }
        });

    }
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    imageView.setImageURI(uri);
                    uriString=uri.toString();

                }
            });

}