package com.example.be_product.service.core;

import java.util.List;

public interface ICrudService <E>{
    List<E> showAll();
    E save(E e);

    E findById(Long id);

    void removeById(Long id);
}
