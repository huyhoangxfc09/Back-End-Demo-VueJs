package com.example.be_product.repository;

import com.example.be_product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Locale;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
