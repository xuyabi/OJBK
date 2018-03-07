package com.example.mmaster.xiaoshixun.bean;

import java.util.List;

/**
 * Created by mMaster
 * on 2018/3/6.
 * at 北京
 */

public class User {

    /**
     * Students : {"Student":[{"name":"张三","content":"学生简介学生简介学生简介学生简介学生简介","img":"http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg"},{"name":"李四","content":"这是一个好学生，好好学习，特别努力","img":"http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg"},{"name":"王五","content":"喜欢读书，喜欢英语，认真学习的时候特别多","img":"http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg"},{"name":"赵六","content":"长的好看，个头大","img":"http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg"},{"name":"孙七","content":"努力学习，认真工作","img":"http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg"},{"name":"Alss","content":"学习好，是一个三好学生，班花","img":"http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg"},{"name":"哇哈哈","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg"},{"name":"hander","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg"},{"name":"EventBus","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg"},{"name":"Android","content":"喜欢英语，擅长代码","img":"http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg"}]}
     */

    private StudentsBean Students;

    public StudentsBean getStudents() {
        return Students;
    }

    public void setStudents(StudentsBean Students) {
        this.Students = Students;
    }

    public static class StudentsBean {
        private List<StudentBean> Student;

        public List<StudentBean> getStudent() {
            return Student;
        }

        public void setStudent(List<StudentBean> Student) {
            this.Student = Student;
        }

        public static class StudentBean {
            /**
             * name : 张三
             * content : 学生简介学生简介学生简介学生简介学生简介
             * img : http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg
             */

            private String name;
            private String content;
            private String img;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
