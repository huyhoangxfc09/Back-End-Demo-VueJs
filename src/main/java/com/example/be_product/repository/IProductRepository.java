package com.example.be_product.repository;

import com.example.be_product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Long> {
//    Hiển thị tất cả sản phẩm
    @Query(value = "select p from Product  p where p.status = true ")
    List<Product> showAllProduct();

//    Xóa sản phẩm chuyển trạng thái thành false
    @Modifying
    @Query(value = "update Product  p set p.status = false where p.id = :id")
    void removeProductById(@Param("id")Long id);


}


