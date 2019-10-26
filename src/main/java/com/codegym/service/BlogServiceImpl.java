package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAllHaveBusiness() {
        return blogRepository.findAll();
    }

    @Override
    public void addHaveBusiness(Blog blog) {
        blogRepository.add(blog);

    }

    @Override
    public void updateHaveBusiness(int id, Blog blog) {
        blogRepository.update(id,blog);
    }

    @Override
    public void removeHaveBusiness(int id) {
        blogRepository.remove(id);
    }

    @Override
    public Blog findByIDHaveBusiness(int id) {
        return blogRepository.findByID(id);
    }
}
