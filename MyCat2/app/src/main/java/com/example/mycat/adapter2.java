package com.example.mycat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter2 extends RecyclerView.Adapter {

    ArrayList<Cats2> pArray2;
    Context c;

    public adapter2(ArrayList<Cats2> pArray2, Context c) {
        this.pArray2 = pArray2;
        this.c = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.activity_adopte_cats_details,parent,false);
        ViewHolder vh2 = new ViewHolder (v);

        return vh2;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {


        ((ViewHolder)holder).Gender.setText (pArray2.get (position).getGender ()+"");
        ((ViewHolder)holder).Breed2.setText (pArray2.get (position).getBreed2 ()+"");
        ((ViewHolder)holder).Age.setText (pArray2.get (position).getAge ()+"");
        ((ViewHolder)holder).Details_cat2.setText (pArray2.get (position).getDetails2 ()+"");


        ((ViewHolder)holder).view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent i = new Intent (c,adopteCats_inside.class);

                i.putExtra("Cats2",pArray2.get (position));

                c.startActivity (i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return pArray2.size ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Gender ;
        public TextView Age ;
        public View view ;
        public TextView Details_cat2;
        public TextView Breed2;
        public ImageView fav_image;



        public ViewHolder(@NonNull View itemView) {
            super (itemView);

            view = itemView;

            Breed2 = itemView.findViewById(R.id.breed_textView_details2);
            Age = itemView.findViewById(R.id.age_textView_details2);
            Details_cat2 = itemView.findViewById(R.id.details_textView_details2);
            Gender = itemView.findViewById(R.id.gender_textView_details2);
            fav_image = itemView.findViewById (R.id.fav2);

            fav_image.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    fav_image.setBackgroundResource (R.drawable.ic_baseline_favorite_24);
                }
            });

        }

    }
}


