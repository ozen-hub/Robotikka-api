package com.bootcamp.robotikka.robotikkaapi.service;

import com.bootcamp.robotikka.robotikkaapi.dto.paginated.PaginatedProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.ResponseProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    public CommonResponseDTO createProduct(MultipartFile image, RequestProductDTO dto) throws IOException;
    public CommonResponseDTO updateProduct(RequestProductDTO dto, String id);
    public ResponseProductDTO findProduct(String id);

    CommonResponseDTO deleteProduct(String id);
    PaginatedProductDTO findAll(String text, int page, int size);
}
