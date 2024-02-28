package org.example.productthymeleaf.service;

import org.example.productthymeleaf.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1, new Product(1, "Nước ngọt", 15.2F, "Rất ngọt", "Quảng Ngãi"));
        productMap.put(2, new Product(2, "Bánh ChoCoBay", 25.80F, "Vị socola", "Quảng Nam"));
        productMap.put(3, new Product(3, "Bia Huda", 19.0F, "Cay Nồng", "Đà Nẵng"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry: productMap.entrySet()){
            if (entry.getValue().getName().equalsIgnoreCase(name)){
                products.add(entry.getValue());
            }
        }
        return products;
    }
}
