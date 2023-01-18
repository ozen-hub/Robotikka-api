package com.bootcamp.robotikka.robotikkaapi.api;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.service.ProductService;
import com.bootcamp.robotikka.robotikkaapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/member/create")
    public ResponseEntity<StandardResponse> createProduct(
            @RequestBody RequestProductDTO dto
    ) {
        CommonResponseDTO savedData = productService.createProduct(dto);
        return new ResponseEntity<>(
                new StandardResponse(savedData.getCode(),
                        savedData.getMessage(), savedData.getData()),
                HttpStatus.CREATED
        );
    }
}
