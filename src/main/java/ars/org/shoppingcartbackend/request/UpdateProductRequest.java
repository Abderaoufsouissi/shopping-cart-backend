package ars.org.shoppingcartbackend.request;

import ars.org.shoppingcartbackend.model.Category;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
