package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    String[] names,description;
    int[] images;
    Context context;
    private static ClickListener clickListener;

    public CustomAdapter(String[] names, String[] description, int[] images, Context context) {
        this.names = names;
        this.description = description;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.nameText.setText(names[position]);
        holder.descText.setText(description[position]);
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }


    //inner class for holding the views inside the recycler view
    //we are going to use interfaces to do the jobs of the listeners
    class CustomViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener,View.OnLongClickListener{

        TextView nameText,descText;
        ImageView imageView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameId);
            descText = itemView.findViewById(R.id.descriptionId);
            imageView = itemView.findViewById(R.id.imageId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"onclickIN "+getAdapterPosition(),Toast.LENGTH_LONG).show();
            clickListener.OnClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.OnLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        CustomAdapter.clickListener = clickListener;
    }

    interface ClickListener{
        public void OnClick(int position, View v);
        public void OnLongClick(int position, View v);
    }
}
