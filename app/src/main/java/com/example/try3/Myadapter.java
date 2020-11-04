package com.example.try3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Myadapter extends FirebaseRecyclerAdapter<model,Myadapter.viewholder> {

    public Myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull model model) {

        // get texts
        holder.itm_name.setText(model.getItem_name());
        holder.item_wt.setText(model.getItem_wt());
        holder.item_price.setText(model.getItem_price());
        Glide.with(holder.img_item.getContext()).load(model.getItem_img()).into(holder.img_item);

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // import activity here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_home,parent,false);
        return new viewholder(view);

    }

    class viewholder extends RecyclerView.ViewHolder{

        Button btn_plus,btn_minus;
        TextView itm_name,item_wt,item_price;
        ImageView img_item;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            //buttons
           btn_plus = (Button)itemView.findViewById(R.id.btn_add);
           btn_minus = (Button)itemView.findViewById(R.id.btn_del);

            //img
            img_item = (ImageView)itemView.findViewById(R.id.itm_img);

            //text
            itm_name = (TextView)itemView.findViewById(R.id.itm_txt);
            item_wt = (TextView)itemView.findViewById(R.id.itm_wt);
            item_price = (TextView)itemView.findViewById(R.id.itm_price);


        }
    }
}
