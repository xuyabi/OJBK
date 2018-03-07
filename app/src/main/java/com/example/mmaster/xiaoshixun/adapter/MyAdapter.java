package com.example.mmaster.xiaoshixun.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mmaster.xiaoshixun.MyApp;
import com.example.mmaster.xiaoshixun.R;
import com.example.mmaster.xiaoshixun.bean.Student;
import com.example.mmaster.xiaoshixun.bean.User;
import com.example.mmaster.xiaoshixun.gen.StudentDao;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mMaster
 * on 2018/3/6.
 * at 北京
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<User.StudentsBean.StudentBean> student;
    private Context mc;

    public MyAdapter(List<User.StudentsBean.StudentBean> student, Context mc) {
        this.student = student;
        this.mc = mc;
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mc).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
        holder.content.setText(student.get(position).getContent());
        holder.name.setText(student.get(position).getName());
        Picasso.with(mc).load(student.get(position).getImg()).into(holder.img);

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDao studentDao = MyApp.getMyApp().getDaoSession().getStudentDao();
                Student student1 = new Student();
                student1.setImg(student.get(position).getImg());
                student1.setContent(student.get(position).getContent());
                student1.setName(student.get(position).getName());
                studentDao.insert(student1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView content;
        private final CheckBox cb;

        public ViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.contenet);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            cb = itemView.findViewById(R.id.cb);
        }
    }
}
