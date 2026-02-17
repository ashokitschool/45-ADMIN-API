package in.ashokit.rest;

import in.ashokit.dto.ApiResponse;
import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ProductCategoryRestController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/product-category")
    public ResponseEntity<ApiResponse<ProductCategoryDto>> createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {

        ProductCategoryDto productCategoryByName = productCategoryService.getProductCategoryByName(productCategoryDto.getCategoryName());
        if (productCategoryByName != null) {
            ApiResponse<ProductCategoryDto> response = new ApiResponse();
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Product category with the same name already exists");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        ProductCategoryDto createdCategory = productCategoryService.createProductCategory(productCategoryDto);

        ApiResponse<ProductCategoryDto> response = new ApiResponse();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Product category created successfully");
        response.setData(createdCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/product-categories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> getAllProductCategories() {

        List<ProductCategoryDto> categories = productCategoryService.getAllProductCategories();

        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Product categories retrieved successfully");
        response.setData(categories);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/product-category/{categoryId}")
    public ResponseEntity<ApiResponse<ProductCategoryDto>> getProductCategoryById(@PathVariable Integer categoryId) {

        ProductCategoryDto category = productCategoryService.getProductCategoryById(categoryId);

        ApiResponse<ProductCategoryDto> response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Product category retrieved successfully");
        response.setData(category);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/product-category/{categoryId}")
    public ResponseEntity<ApiResponse<ProductCategoryDto>> updateProductCategory(@PathVariable Integer categoryId, @RequestBody ProductCategoryDto productCategoryDto) {

        ProductCategoryDto updatedCategory = productCategoryService.updateProductCategory(categoryId, productCategoryDto);

        ApiResponse<ProductCategoryDto> response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Product category updated successfully");
        response.setData(updatedCategory);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/product-category/{categoryId}/{updatedBy}")
    public ResponseEntity<ApiResponse<ProductCategoryDto>> deleteProductCategory(@PathVariable Integer categoryId, @PathVariable Integer updatedBy) {

        ProductCategoryDto deletedCategory = productCategoryService.deleteProductCategory(categoryId, updatedBy);

        ApiResponse<ProductCategoryDto> response = new ApiResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Product category deleted successfully");
        response.setData(deletedCategory);

        return ResponseEntity.ok(response);
    }

}
