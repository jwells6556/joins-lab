package com.justinwells.joinslab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by justinwells on 10/30/16.
 */

public class customViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public customViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(android.R.id.text1);
    }
}
