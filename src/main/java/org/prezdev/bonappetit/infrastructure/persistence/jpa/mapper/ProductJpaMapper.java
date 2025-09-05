package org.prezdev.bonappetit.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.prezdev.bonappetit.domain.model.Product;
import org.prezdev.bonappetit.infrastructure.persistence.jpa.entity.product.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductJpaMapper {
    Product toDomain(ProductEntity entity);

    ProductEntity toEntity(Product domain);
}
