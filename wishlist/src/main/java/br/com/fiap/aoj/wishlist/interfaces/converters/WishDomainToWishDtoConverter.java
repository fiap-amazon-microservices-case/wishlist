package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.WishDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ClientDto;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ProductDto;
import br.com.fiap.aoj.wishlist.interfaces.dtos.WishDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WishDomainToWishDtoConverter implements Converter<WishDomain, WishDto> {

	private final ClientDomainToClientDtoConverter clientDomainToClientDtoConverter;
	private final ProductDomainToProductDtoConverter productDomainToProductDtoConverter;

	public WishDomainToWishDtoConverter(final ClientDomainToClientDtoConverter clientDomainToClientDtoConverter,
			final ProductDomainToProductDtoConverter productDomainToProductDtoConverter) {
		this.clientDomainToClientDtoConverter = clientDomainToClientDtoConverter;
		this.productDomainToProductDtoConverter = productDomainToProductDtoConverter;
	}

	@Override
	public WishDto convert(final WishDomain source) {
		final WishDto wishDto = new WishDto();
		wishDto.setCreatedAt(source.createdAt());
		wishDto.setProduct(buildProduct(source));
		wishDto.setClient(buildClient(source));

		return wishDto;
	}

	private ProductDto buildProduct(final WishDomain source) {
		return productDomainToProductDtoConverter.convert(source.getProduct());
	}

	private ClientDto buildClient(final WishDomain source) {
		return clientDomainToClientDtoConverter.convert(source.getClient());
	}
}