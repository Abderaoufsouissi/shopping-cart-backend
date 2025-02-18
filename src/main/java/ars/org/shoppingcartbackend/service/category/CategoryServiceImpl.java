package ars.org.shoppingcartbackend.service.category;

import ars.org.shoppingcartbackend.exceptions.AlreadyExistsException;
import ars.org.shoppingcartbackend.exceptions.RessourceNotFoundException;
import ars.org.shoppingcartbackend.model.Category;
import ars.org.shoppingcartbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;



    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).
                orElseThrow(()->new RessourceNotFoundException("Category not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);

    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.ofNullable(category)
                .filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save) // Save the valid category
                .orElseThrow(() -> new AlreadyExistsException(category.getName() + " already exists"));
    }


    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id)).map(oldCategory->{
            oldCategory.setName(category.getName());
            return categoryRepository.save(oldCategory);}).
                orElseThrow(()->new RessourceNotFoundException("Category not found"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).
                ifPresentOrElse(categoryRepository :: delete,
                        ()->{throw new RessourceNotFoundException("Category not found");});

    }
}
