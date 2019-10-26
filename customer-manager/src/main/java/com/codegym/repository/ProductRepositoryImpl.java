package com.codegym.repository;

import com.codegym.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext //tiêm, khởi tạo đã làm ở application config
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void add(Product product) {
        em.persist(product); //persist là 1 phương thức của hbn sẽ tạo ra câu lệnh insert into

    }
}
