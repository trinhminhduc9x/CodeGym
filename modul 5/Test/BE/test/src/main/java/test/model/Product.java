package test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    private Integer id;
    private String name;
    private String manufacture;
    private Integer price;
    private Integer priceNumber;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Category> categories;

}
