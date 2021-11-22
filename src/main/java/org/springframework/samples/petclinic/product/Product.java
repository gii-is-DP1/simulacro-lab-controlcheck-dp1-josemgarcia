package org.springframework.samples.petclinic.product;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import org.springframework.samples.petclinic.model.NamedEntity;
import javax.validation.constraints.DecimalMin;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product extends NamedEntity {
    
    @DecimalMin(value="0")
    double price;

    @ManyToOne
    @JoinColumn(name="type")
    ProductType productType;
}
