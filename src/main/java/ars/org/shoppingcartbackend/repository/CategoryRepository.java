package ars.org.shoppingcartbackend.repository;

import ars.org.shoppingcartbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
