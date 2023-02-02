package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.dto.paginated.PaginatedProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.paginated.converter.ProductConverter;
import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.ResponseProductDTO;
import com.bootcamp.robotikka.robotikkaapi.entity.Product;
import com.bootcamp.robotikka.robotikkaapi.entity.ProductImages;
import com.bootcamp.robotikka.robotikkaapi.entity.share.FileResource;
import com.bootcamp.robotikka.robotikkaapi.repo.ProductImagesRepo;
import com.bootcamp.robotikka.robotikkaapi.repo.ProductRepo;
import com.bootcamp.robotikka.robotikkaapi.service.ProductService;
import com.bootcamp.robotikka.robotikkaapi.service.process.FileService;
import com.bootcamp.robotikka.robotikkaapi.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ProductImagesRepo productImagesRepo;
    private final Generator generator;
    final private FileService fileService;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductImagesRepo productImagesRepo, Generator generator, FileService fileService) {
        this.productRepo = productRepo;
        this.productImagesRepo = productImagesRepo;
        this.generator = generator;
        this.fileService = fileService;
    }

    @Override
    public CommonResponseDTO createProduct(MultipartFile image, RequestProductDTO dto) throws IOException {
        Product product = new Product(
                generator.generateKey("PI"),
                dto.getDisplayName(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQty(),
                null,
                dto.getSellingPrice(),
                null,
                null
        );

        HashMap<String, String> productsImage =
                fileService.createFile(image, "products", "user-1", 450);

        ProductImages pi=new ProductImages(
                generator.generateKey("I"),
                new FileResource(
                        productsImage.get("directory"),
                        productsImage.get("hash"),
                        productsImage.get("resource"),
                        productsImage.get("originalFile")
                ),
                product
        );

        productRepo.save(product);
        productImagesRepo.save(pi);
        return new CommonResponseDTO(201,"Saved!",null);
    }

    @Override
    public CommonResponseDTO updateProduct(RequestProductDTO dto, String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Product product = selectedProduct.get();
        product.setDescription(dto.getDescription());
        product.setDisplayName(dto.getDisplayName());
        product.setSellingPrice(dto.getSellingPrice());
        product.setUnitPrice(dto.getUnitPrice());
        product.setQty(dto.getQty());
        productRepo.save(product);
        return new CommonResponseDTO(201,"Updated",null);
    }

    @Override
    public ResponseProductDTO findProduct(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseProductDTO(
                selectedProduct.get().getPropertyId(),
                selectedProduct.get().getDisplayName(),
                selectedProduct.get().getDescription(),
                selectedProduct.get().getUnitPrice(),
                selectedProduct.get().getQty(),
                selectedProduct.get().getSellingPrice()
        );
    }

    @Override
    public CommonResponseDTO deleteProduct(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        productRepo.deleteById(selectedProduct.get().getPropertyId());
        return new CommonResponseDTO(204,"Deleted",null);
    }

    @Override
    public PaginatedProductDTO findAll(String text, int page, int size) {
        System.out.println("OK");
        List<ProductConverter> convertableData = productRepo.findAllProductsWithPaginate(
                text,
                PageRequest.of(page, size));
        long pageCountTwo = productRepo.findAllProductsCount(text);
        ArrayList<ResponseProductDTO> dtos = new ArrayList<>();
        for(ProductConverter c: convertableData){
            dtos.add(
                    new ResponseProductDTO(
                            c.getPropertyId(),
                            c.getDisplayName(),
                            c.getDescription(),
                            c.getUnitPrice(),
                            c.getQty(),
                            c.getSellingPrice()
                    )
            );
        }
        return new PaginatedProductDTO(
                pageCountTwo,
                dtos
        );
    }
}
