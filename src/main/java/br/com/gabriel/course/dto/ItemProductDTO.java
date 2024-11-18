package br.com.gabriel.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemProductDTO {

    private Integer quantity;
    private Double price;
    private Double subTotal;
}
