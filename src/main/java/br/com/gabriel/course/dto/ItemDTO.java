package br.com.gabriel.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDTO {

    private Double price;
    private Integer quantity;
    private ProductDTO product;
    private Double subTotal;
}
