package com.coto.cesar.recyclerviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagenAdapter extends RecyclerView.Adapter<ImagenAdapter.ViewHolder> {


    ArrayList<Imagen> imagenArrayList;
    OnclickImageListener listener;
    Context context;


    public ImagenAdapter(ArrayList<Imagen> imagenArrayList, OnclickImageListener listener) {
        this.imagenArrayList = imagenArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);

        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Imagen imagen = imagenArrayList.get(position);
        holder.setListener(imagen,listener);

        if(imagen.getUrlImage() != null){

            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);
            options.placeholder(R.mipmap.ic_launcher);
            options.centerCrop();

            Glide.with(context)
                    .load(imagen.getUrlImage())
                    .apply(options)
                    .into(holder.imageViewCard);
        }else{
            holder.imageViewCard.setImageDrawable(ContextCompat
                    .getDrawable(context,R.mipmap.ic_launcher_round));
        }

    }

    public void addView(Imagen imagen){

        if(!imagenArrayList.contains(imagen)){
            imagenArrayList.add(imagen);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return imagenArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewCard)
        ImageView imageViewCard;
        @BindView(R.id.containerImage)
        RelativeLayout containerImage;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }
        void setListener(final Imagen imagen, final OnclickImageListener listener){
            containerImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickImageListener(imagen);
                }
            });

        }
    }
}
