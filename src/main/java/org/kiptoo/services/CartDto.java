package org.kiptoo.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;
    private CustomerDto customer;
    private String status;
}
