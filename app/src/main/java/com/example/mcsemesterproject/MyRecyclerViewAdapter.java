package com.example.mcsemesterproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    List<Room> roomList;
    Activity mAct;
    Context context;

    public MyRecyclerViewAdapter(List<Room> roomList, Activity mAct, Context context) {
        this.roomList = roomList;
        this.mAct = mAct;
        this.context = context;
    }
    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roomlayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data=roomList.get(position);
        holder.roomNumber.setText(holder.data.getRoomNumber());
        holder.roomRating.setText(String.valueOf(holder.data.getRoomRating()));
        holder.roomReviews.setText(holder.data.getRoomReviews());
        holder.roomInfo.setText(holder.data.getRoomInfo());
        holder.roomPrice.setText(holder.data.getRoomPrice());
        holder.roomImage.setImageResource(holder.data.getRoomImageName());

        holder.btnBookRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Payment.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView roomImage;
        TextView roomNumber;
        TextView roomRating;
        TextView roomReviews;
        TextView roomInfo;
        TextView roomPrice;
        Room data;
        Button btnBookRoom;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roomImage = itemView.findViewById(R.id.roomImage);
            roomNumber = itemView.findViewById(R.id.roomNumber);
            roomRating = itemView.findViewById(R.id.roomRating);
            roomReviews = itemView.findViewById(R.id.roomReviews);
            roomInfo = itemView.findViewById(R.id.roomInfo);
            roomPrice = itemView.findViewById(R.id.roomPrice);
            btnBookRoom = itemView.findViewById(R.id.btnRoomBook);
        }
    }

}
