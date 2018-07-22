package com.alex.app_clean.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.app_clean.R;
import com.alex.app_clean.activity.PictureDetailActivity;
import com.alex.app_clean.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alexander on 09/01/18.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.MiViewHolder> {

    private List<Picture> pictures;
    private int layout;
    private Activity activity;

    public PictureAdapterRecyclerView(List<Picture> pictures, int layout, Activity activity) {
        this.pictures = pictures;
        this.layout = layout;
        this.activity = activity;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
      MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        holder.bind(pictures.get(position));

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{

    private ImageView pictureCard;
    private TextView usernameCard;
    private TextView timeCard;
    private TextView likeNumberCard;

    public MiViewHolder(View itemView) {
        super(itemView);

        pictureCard = itemView.findViewById(R.id.imgP1ID);
        usernameCard =itemView.findViewById(R.id.tvP1ID);
        timeCard = itemView.findViewById(R.id.tvP3ID);
        likeNumberCard = itemView.findViewById(R.id.tvP4ID);
    }

    public void bind(Picture picture){
        usernameCard.setText(picture.getUserName());
        timeCard.setText(picture.getTime());
        likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(pictureCard);

        pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,
                            activity.getString(R.string.transitionname_picture)).toBundle());
                }else{
                    activity.startActivity(intent);
                }


            }
        });

    }
}




}
