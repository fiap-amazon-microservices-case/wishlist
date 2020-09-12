package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.ClientDomain;
import br.com.fiap.aoj.wishlist.domain.ProductDomain;
import br.com.fiap.aoj.wishlist.domain.WishDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.WishDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class WishDtoToWishDomainConverter implements Converter<WishDto, WishDomain> {

	private final ClientDtoToClientDomainConverter clientDtoToClientDomainConverter;
	private final ProductDtoToProductDomainConverter productDtoToProductDomainConverter;

	public WishDtoToWishDomainConverter(final ClientDtoToClientDomainConverter clientDtoToClientDomainConverter,
			final ProductDtoToProductDomainConverter productDtoToProductDomainConverter) {
		this.clientDtoToClientDomainConverter = clientDtoToClientDomainConverter;
		this.productDtoToProductDomainConverter = productDtoToProductDomainConverter;
	}

	@Override
	public WishDomain convert(final WishDto source) {
		final ClientDomain clientDomain = clientDtoToClientDomainConverter.convert(source.getClient());
		final ProductDomain productDomain = productDtoToProductDomainConverter.convert(source.getProduct());
		return WishDomain //
				.builder() //
				.client(clientDomain) //
				.product(productDomain) //
				.builder();
	}
}