package com.justinwells.joinslab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by justinwells on 10/30/16.
 */

public class customViewAdapter extends RecyclerView.Adapter<customViewHolder> {

    private List<String>list;

    public customViewAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public customViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new customViewHolder(inflater.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(customViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
