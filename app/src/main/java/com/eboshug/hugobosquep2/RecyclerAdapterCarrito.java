package com.eboshug.hugobosquep2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterCarrito extends RecyclerView.Adapter<RecyclerAdapterCarrito.ViewHolder> {

    private List<VideoGame> listaVideojuegos;
    private Context context;

    public RecyclerAdapterCarrito(List<VideoGame> listaVideojuegos, Context context) {
        this.listaVideojuegos = listaVideojuegos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_carrito, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoGame game = this.listaVideojuegos.get(position);
        holder.textView.setText(game.getNombre());
        holder.preview.setImageResource(game.getImg_id());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameDataHelper db = new GameDataHelper(context);
                db.removeFromShoppingList(listaVideojuegos.get(position));
                listaVideojuegos.remove(position);
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
        private Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.itemName);
            this.preview = itemView.findViewById(R.id.preview);
            this.delete = itemView.findViewById(R.id.delete);
        }

    }

}
