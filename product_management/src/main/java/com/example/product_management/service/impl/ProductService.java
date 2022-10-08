package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IBaseRepository;
import com.example.product_management.repository.impl.ProductRepository;
import com.example.product_management.service.IBaseService;
import com.example.product_management.util.Valid;

import java.util.List;
import java.util.Map;

public class ProductService implements IBaseService<Product> {
    IBaseRepository<Product> productRepository = new ProductRepository();
    Valid valid = new Valid();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(0);
    }
    public List<Product> findItemForCurrentPage(int index){
        index = (index - 1) * 5;
        return productRepository.findAll(index);
    }

    @Override
    public Map<String,String> registry(Product product) {
        Map<String,String> error = valid.getValidation(product);
        if (error.isEmpty()){
            if (productRepository.getObjectByName(product.getName()) != null){
                productRepository.update(product);
            } else {
                productRepository.insert(product);
            }
        }
        return error;
    }

    @Override
    public void deleteOject(String name) {
        productRepository.delete(name);
    }

    @Override
    public List<Product> searchByName(String name, int index) {
        index = (index - 1) * 5;
        return productRepository.searchByName(name, index);
    }

    @Override
    public Product getObjectByName(String name) {
        return productRepository.getObjectByName(name);
    }

    @Override
    public int getNumberPage() {
        int countProductItems = productRepository.countProductItems();
        int itemsPerPage = 5;
        if (countProductItems % itemsPerPage == 0){
            return countProductItems/itemsPerPage;
        }
        return countProductItems/itemsPerPage + 1;
    }
    public int getNumberPage(String name) {
        int countProductItems = productRepository.countProductItems(name);
        int itemsPerPage = 5;
        if (countProductItems % itemsPerPage == 0){
            return countProductItems/itemsPerPage;
        }
        return countProductItems/itemsPerPage + 1;
    }
}
