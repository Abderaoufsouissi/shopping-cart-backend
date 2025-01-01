package ars.org.shoppingcartbackend.service.product;

import ars.org.shoppingcartbackend.model.Product;
import ars.org.shoppingcartbackend.request.AddProductRequest;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    Product addProduct(AddProductRequest product);
    void updateProduct(Product product,Long idProduct);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand,String name);
}
