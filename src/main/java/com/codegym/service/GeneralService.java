package com.codegym.service;

import java.util.List;

public interface GeneralService<E> {

    List<E> findAllHaveBusiness();

    void addHaveBusiness(E e);

    void updateHaveBusiness(int id,E e);

    void removeHaveBusiness(int id);

    E findByIDHaveBusiness(int id);
}
