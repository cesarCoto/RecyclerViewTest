package com.coto.cesar.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Actityimagen extends AppCompatActivity {

    private  TextView textViewSub;
    private ImageView imageViewSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actityimagen);


        imageViewSub = findViewById(R.id.image1);
        textViewSub = findViewById(R.id.textView1);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String urlImagen = bundle.getString("imagen");
            String title = bundle.getString("nombre");
            String descripcion = bundle.getString("descripcion");

            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(title);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }


            Glide.with(this)
                    .load(urlImagen)
                    .into(imageViewSub);

            textViewSub.setText(descripcion);
        }
    }
}
