package com.example.mmaster.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mmaster.xiaoshixun.adapter.MyAdapter;
import com.example.mmaster.xiaoshixun.adapter.YouAdapter;
import com.example.mmaster.xiaoshixun.bean.Student;
import com.example.mmaster.xiaoshixun.bean.User;
import com.example.mmaster.xiaoshixun.gen.StudentDao;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class LieBiao extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recy;
    private Button liebiao;
    private Button shoucang;
    private MyAdapter adapter;
    private List<User.StudentsBean.StudentBean> student;
    private String path = "http://172.16.54.20:8080/data.txt";
    private List<Student> listdata;
    private YouAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lie_biao);
        initView();
        initData();


    }

    private void initListener() {
        adapter1.setonlistener(new YouAdapter.onlistener() {
            @Override
            public void itemlistener(int position) {
                Intent intent = new Intent(LieBiao.this,XiangQing.class);
                intent.putExtra("content",listdata.get(position).getContent());
                intent.putExtra("img",listdata.get(position).getImg());
                intent.putExtra("name",listdata.get(position).getName());
                startActivity(intent);
            }

            @Override
            public void itemlonglistener(int position) {
                listdata.remove(position);
                StudentDao studentDao = MyApp.getMyApp().getDaoSession().getStudentDao();
                studentDao.deleteByKey(listdata.get(position).getId());
                adapter1.notifyDataSetChanged();
            }
        });
    }


    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    String s = new String(response.getBytes("iso-8859-1"), "utf-8");
                    User user = gson.fromJson(s, User.class);
                    student = user.getStudents().getStudent();
                    adapter = new MyAdapter(student, LieBiao.this);
                    LinearLayoutManager manager = new LinearLayoutManager(LieBiao.this, LinearLayoutManager.VERTICAL, false);
                    recy.setLayoutManager(manager);
                    recy.setAdapter(adapter);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }
    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        liebiao = (Button) findViewById(R.id.liebiao);
        shoucang = (Button) findViewById(R.id.shoucang);
        liebiao.setOnClickListener(this);
        shoucang.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.liebiao:
                adapter = new MyAdapter(student, LieBiao.this);
                LinearLayoutManager manager = new LinearLayoutManager(LieBiao.this, LinearLayoutManager.VERTICAL, false);
                recy.setLayoutManager(manager);
                recy.setAdapter(adapter);
                break;
            case R.id.shoucang:
                StudentDao studentDao = MyApp.getMyApp().getDaoSession().getStudentDao();
                listdata = studentDao.loadAll();
                adapter1 = new YouAdapter(listdata, LieBiao.this);
                LinearLayoutManager manager1 = new LinearLayoutManager(LieBiao.this, LinearLayoutManager.VERTICAL, false);
                recy.setLayoutManager(manager1);
                recy.setAdapter(adapter1);
                initListener();
                break;
        }
    }
}
