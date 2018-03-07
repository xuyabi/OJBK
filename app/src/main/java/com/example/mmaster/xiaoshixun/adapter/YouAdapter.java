package com.example.mmaster.xiaoshixun.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mmaster.xiaoshixun.R;
import com.example.mmaster.xiaoshixun.bean.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mMaster
 * on 2018/3/6.
 * at 北京
 */

public class YouAdapter extends RecyclerView.Adapter<YouAdapter.ViewHolder>{
    private List<Student> listdata;
    private Context mc;
    private onlistener listener;

    public YouAdapter(List<Student> listdata, Context mc) {
        this.listdata = listdata;
        this.mc = mc;
    }

    @Override
    public YouAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mc).inflate(R.layout.item1, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(YouAdapter.ViewHolder holder, final int position) {
        holder.content.setText(listdata.get(position).getContent());
        holder.name.setText(listdata.get(position).getName());
        Picasso.with(mc).load(listdata.get(position).getImg()).into(holder.img);
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemlistener(position);
            }
        });
        holder.content.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.itemlonglistener(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView name;
        private final TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.contenet);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }
    public interface onlistener{
        void itemlistener(int position);
        void itemlonglistener(int position);
    }
    public void setonlistener(onlistener listener){
        this.listener=listener;
    }
}
