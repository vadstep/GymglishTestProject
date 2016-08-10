package com.vadstep.gymglishtestproject.Controller.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vadstep.gymglishtestproject.Model.WebLink;
import com.vadstep.gymglishtestproject.R;

import java.util.List;

/**
 * Created by Вадим Степаненко on 10.08.2016.
 */
public class WebAdapter  extends RecyclerView.Adapter<WebAdapter.MyViewHolder> {

    private List<WebLink> urlList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView urlAddress;

        public MyViewHolder(View view) {
            super(view);
            urlAddress = (TextView) view.findViewById(R.id.urlAddress);

        }
    }


    public WebAdapter(List<WebLink> urlList) {
        this.urlList = urlList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weblist_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WebLink url = urlList.get(position);
        holder.urlAddress.setText(url.getUrl());

    }

    @Override
    public int getItemCount() {
        return urlList.size();
    }
}