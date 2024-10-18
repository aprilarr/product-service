package com.apri.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ProductRequestDto {

        @NotNull(message = "Name is required")
        @NotBlank (message = "Name is required")
        private String name;
        private String description;
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than 0")
        private BigDecimal price;
}
