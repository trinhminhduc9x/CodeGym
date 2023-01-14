package test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    private Integer id;
    private Integer number;
    private String productDay;
    private String startDay;
    private String endDay;

    @ManyToOne()
    @JoinColumn(name = "product_Id", referencedColumnName = "id")
    @JsonBackReference
    private Product product;
}
