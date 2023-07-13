package com.example.be_product.controller;

import com.example.be_product.model.Category;
import com.example.be_product.model.Product;
import com.example.be_product.service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("home/products")
public class ProductController {
    @Autowired
    private IProductService productService;

//    Hiển thị tất cả sản phẩm
    @GetMapping
    public ResponseEntity<List<Product>> showAllProduct(){
        List<Product> products = productService.showAll();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }

//    Truy xuất 1 sản phẩm theo idProduct
    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> findByIdProduct(@PathVariable("idProduct")Long idProduct){
        Product product = productService.findById(idProduct);
        if (product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Thêm/Sửa sản phẩm
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product productUpdate = productService.save(product);
        if (productUpdate!=null){
            return new ResponseEntity<>(productUpdate,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xóa sản phẩm
    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Product> deleteByIdProduct(@PathVariable("idProduct")Long idProduct){
        Product product = productService.findById(idProduct);
        if (product!=null){
            productService.removeById(idProduct);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    Hiển thị tất cả Category
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> showAllCategory(){
        List<Category> categories = productService.showAllCategory();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(categories,HttpStatus.OK);
        }
    }
}
