package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRepositoryImpl implements BlogRepository {
    private static List<Blog> blogList = new ArrayList<>();

    static {
        blogList.add(new Blog(0, "T di hoc", "Hom nay lanh quaaaaaa"));
        blogList.add(new Blog(1, "T ve nha", "Mua qua huhuhu"));
        blogList.add(new Blog(2, "T di ngu", "Moi ngay ngu 10h tot cho suc khoe"));
    }

    @Override
    public List<Blog> findAll() {
        return blogList;
    }

    @Override
    public void add(Blog blog) {
        blogList.add(blog);
    }

    @Override
    public void update(int id, Blog blog) {
        blogList.set(id, blog);
    }

    @Override
    public void remove(int id) {
        blogList.remove(id);
    }

    @Override
    public Blog findByID(int id) {
        return blogList.get(id);
    }
}
