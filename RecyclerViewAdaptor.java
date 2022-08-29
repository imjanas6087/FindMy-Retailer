package com.example.findmyretailer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MyHolder> {
    ArrayList<Details> details;
    Context context;
    ClickEvent clickEvent;

    public RecyclerViewAdaptor( Context context,ArrayList<Details> details, ClickEvent clickEvent) {
        this.details = details;
        this.context = context;
        this.clickEvent = clickEvent;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view,parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.text_RetailerName.setText(details.get(position).getRetailerName());
        holder.text_RetailerId.setText(details.get(position).getRetailerId());
        holder.text_RetailerAddress.setText(details.get(position).getAddress());
        holder.text_RetailerPinCode.setText(details.get(position).getPhno());
        holder.text_RetailerContactNumber.setText(details.get(position).getContactNumb());
        holder.click_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEvent.methodShare(details.get(holder.getAdapterPosition()).getLAtitude(),details.get(holder.getAdapterPosition()).getLongitude(),
                        details.get(holder.getAdapterPosition()).getAddress());
            }
        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView text_RetailerId, text_RetailerName, text_RetailerAddress, text_RetailerPinCode
                ,text_RetailerContactNumber;
        CardView click_event;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text_RetailerName =  itemView.findViewById(R.id.text_name);
            text_RetailerId = itemView.findViewById(R.id.text_RetailerId);
            text_RetailerAddress = itemView.findViewById(R.id.text_RetailerAddress);
            text_RetailerPinCode= itemView.findViewById(R.id.text_RetailerPinCode);
            text_RetailerContactNumber = itemView.findViewById(R.id.text_RetailerContactNumber);
            click_event = itemView.findViewById(R.id.click_event);

        }
    }
}
