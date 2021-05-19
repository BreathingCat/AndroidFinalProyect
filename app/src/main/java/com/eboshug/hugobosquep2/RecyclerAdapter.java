package com.eboshug.hugobosquep2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<VideoGame> listaVideojuegos;
    private Context context;

    public RecyclerAdapter(List<VideoGame> listaVideojuegos, Context context) {
        this.listaVideojuegos = listaVideojuegos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoGame game = this.listaVideojuegos.get(position);
        holder.textView.setText(game.getNombre());
        holder.preview.setImageResource(game.getImg_id());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoGameDetail.class);
                intent.putExtra("game", game);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listaVideojuegos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView preview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.itemName);
            this.preview = itemView.findViewById(R.id.preview);
        }

    }

}
