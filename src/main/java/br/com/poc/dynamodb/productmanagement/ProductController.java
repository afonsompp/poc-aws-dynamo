package br.com.poc.dynamodb.productmanagement;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostMapping
	public ResponseEntity<ProductResponse> saveProduct(
			@RequestBody @Valid ProductRequest productRequest) {
		var savedProduct = productRepository.save(productRequest.toProduct());

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedProduct.getId())
				.toUri();

		return ResponseEntity.created(location).body(new ProductResponse(savedProduct));

	}
}
