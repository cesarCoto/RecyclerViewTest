package com.coto.cesar.recyclerviewtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment implements  OnclickImageListener{


    @BindView(R.id.recyclerViewImage)
    RecyclerView recyclerViewImage;
    Unbinder unbinder;

    ImagenAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        confyAdapter();
        confyRecycler();
        addImage();

        return view;
    }


    private void addImage(){
        String [] nombre  = {"Hola", "mundo", "esto", "es", "recyclerview", "en android"};
        String [] urlImagenes = {
                "https://wallpaperclicker.com/storage/wallpaper/COOL-WALLPAPER-7037-21909636.jpg",
                "https://cn.pling.com/img/c/4/2/6/c135377a0932e613d7c62c7d000781ead7a9.jpg",
                "https://wallpaperclicker.com/storage/wallpaper/COOL-WALLPAPER-7037-21909636.jpg",
                "https://cn.pling.com/img/c/4/2/6/c135377a0932e613d7c62c7d000781ead7a9.jpg",
                "https://wallpaperclicker.com/storage/wallpaper/COOL-WALLPAPER-7037-21909636.jpg",
                "https://cn.pling.com/img/c/4/2/6/c135377a0932e613d7c62c7d000781ead7a9.jpg"};
        String [] descripcion  = {
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",
                "Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello HelloHelloHello",};


        for(int i =0; i<6; i++){
            Imagen imagen = new Imagen(i+1,nombre[i],descripcion[i],urlImagenes[i]);
            adapter.addView(imagen);
        }

    }
    private void confyAdapter(){
        adapter = new ImagenAdapter(new ArrayList<Imagen>(),this);
    }
    private void confyRecycler(){
        recyclerViewImage.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerViewImage.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClickImageListener(Imagen imagen) {


       Intent showDetails = new Intent(getContext(),Actityimagen.class);
        showDetails.putExtra("imagen",String.valueOf(imagen.getUrlImage()));
        showDetails.putExtra("nombre", String.valueOf(imagen.getName()));
        showDetails.putExtra("descripcion",String.valueOf(imagen.getDescription()));

        startActivity(showDetails);



    }
}
