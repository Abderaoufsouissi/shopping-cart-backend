package ars.org.shoppingcartbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy ="category" , cascade = CascadeType.ALL , orphanRemoval = true )
    List<Product> products;


    public Category(String name) {
        this.name = name;
    }
}
