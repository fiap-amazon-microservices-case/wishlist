package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.ProductDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ProductDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ProductDtoToProductDomainConverter implements Converter<ProductDto, ProductDomain> {

	@Override
	public ProductDomain convert(final ProductDto source) {
		return ProductDomain //
				.builder() //
				.productId(source.getProductId()) //
				.name(source.getName()) //
				.build();
	}
}
