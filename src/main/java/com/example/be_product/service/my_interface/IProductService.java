package com.example.be_product.service.my_interface;
import com.example.be_product.model.Category;
import com.example.be_product.model.Product;
import com.example.be_product.service.core.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends ICrudService<Product> {
    List<Category> showAllCategory();
    Page<Product> showAllProductByPage(Pageable pageable);
}
