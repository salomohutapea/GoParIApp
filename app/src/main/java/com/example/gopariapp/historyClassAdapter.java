package com.example.gopariapp;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class historyClassAdapter extends FirestoreRecyclerAdapter<historyClass, historyClassAdapter.historyClassHolder> {

    public historyClassAdapter(@NonNull FirestoreRecyclerOptions<historyClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull historyClassHolder holder, int position, @NonNull historyClass model) {
        holder.textViewactivity.setText(model.getActivity());
        holder.textViewcurrencyRp.setText(model.getCurrencyRp());
        holder.textViewcurrencyUsd.setText(model.getCurrencyUsd());
        holder.textViewtime.setText(model.getTime());
    }

    @NonNull
    @Override
    public historyClassHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_content,parent, false);
        return new historyClassHolder(v);
    }

    class historyClassHolder extends RecyclerView.ViewHolder {
        TextView textViewactivity;
        TextView textViewcurrencyRp;
        TextView textViewcurrencyUsd;
        TextView textViewtime;
        public historyClassHolder(View itemView){
            super(itemView);
            textViewactivity=itemView.findViewById(R.id.cardHistoryTitle);
            textViewcurrencyRp=itemView.findViewById(R.id.cardHistoryRupiah);
            textViewcurrencyUsd=itemView.findViewById(R.id.cardHistoryUsd);
            textViewtime=itemView.findViewById(R.id.cardHistoryTime);
        }
    }
}
