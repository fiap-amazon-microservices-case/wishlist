package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.ProductDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ProductDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ProductDomainToProductDtoConverter implements Converter<ProductDomain, ProductDto> {

	@Override
	public ProductDto convert(final ProductDomain source) {
		final ProductDto productDto = new ProductDto();
		productDto.setName(source.getName());
		productDto.setProductId(source.getProductId());

		return productDto;
	}
}
