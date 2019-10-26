package com.codegym.model;

public class Blog {
    //1 blog có 3 thuộc tính là id, tên blog và nội dung blog
    // định thêm tên t/g....mà mình nghĩ nên làm đơn giản thôi
    public int id;
    private String name;
    private String content;

    public Blog() {
    }
    public Blog(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
