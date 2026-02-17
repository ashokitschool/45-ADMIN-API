package in.ashokit.service;

import in.ashokit.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {

    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);

    public List<ProductCategoryDto> getAllProductCategories();

    public ProductCategoryDto getProductCategoryById(Integer categoryId);

    public ProductCategoryDto getProductCategoryByName(String categoryName);

    public ProductCategoryDto updateProductCategory(Integer categoryId, ProductCategoryDto productCategoryDto);

    public ProductCategoryDto deleteProductCategory(Integer categoryId, Integer updatedBy);


}
