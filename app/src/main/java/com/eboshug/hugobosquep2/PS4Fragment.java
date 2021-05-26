package com.eboshug.hugobosquep2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PS4Fragment extends Fragment {
    private static final String TAG = "PS4Fragment";
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ps4_fragment, container, false);

        GameDataHelper db = new GameDataHelper(view.getContext());

        this.recyclerView = view.findViewById(R.id.recyclerViewPS4);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.recyclerView.setAdapter(new RecyclerAdapter(db.getPS4Games(), view.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        db.close();

        return view;
    }
}
