package in.ashokit.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ashokit.dto.ApiResponse;
import in.ashokit.dto.ProductDto;
import in.ashokit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin/")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<ProductDto>> createProduct(@RequestParam("categoryId") Integer categoryId,
                                                                 @RequestParam("product") String productDtoJson,
                                                                 @RequestParam("productImage") MultipartFile productImage) throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();
        ProductDto productDto = objectMapper.readValue(productDtoJson, ProductDto.class);

        ProductDto createdProduct = productService.createProduct(categoryId, productDto, productImage);

        ApiResponse<ProductDto> response = new ApiResponse<>();

        if (createdProduct != null) {
            response.setStatusCode(201);
            response.setMessage("Product created successfully");
            response.setData(createdProduct);
            return ResponseEntity.status(201).body(response);
        } else {
            response.setStatusCode(400);
            response.setMessage("Failed to create product");
            response.setData(null);
            return ResponseEntity.status(400).body(response);
        }
    }
}
