package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/show-blog")
    public ModelAndView findAll() {
        List<Blog> blogList = blogService.findAllHaveBusiness();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("message", "Danh sach Blog");
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog newBlog) {
        blogService.addHaveBusiness(newBlog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        //đoạn này là để đẩy lên view "blog" một blog mới trống, k cần xóa đi nhập lại
        modelAndView.addObject("message", "Da them 1 blog");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Blog blogDelete = blogService.findByIDHaveBusiness(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("blog", blogDelete);
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog) {
        blogService.removeHaveBusiness(blog.getId());
        ModelAndView modelAndView = new ModelAndView("/delete");
        return modelAndView;
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        //lấy ra blog muốn edit theo id
       Blog blogEdit = blogService.findByIDHaveBusiness(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blogEdit);
        return modelAndView;
    }
    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog")Blog blog1){   //lấy về "blog" từ client sau đó gán cho blog1
        ModelAndView modelAndView = new ModelAndView("/edit");
        blogService.updateHaveBusiness(blog1.getId(),blog1);
        modelAndView.addObject("blog",blog1);   //Đẩy blog1 lên view gán cho "blog"
        modelAndView.addObject("message","Updated!!!");
        return modelAndView;
    }




}
