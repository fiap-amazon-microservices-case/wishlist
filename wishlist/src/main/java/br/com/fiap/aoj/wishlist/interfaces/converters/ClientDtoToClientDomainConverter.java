package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.ClientDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ClientDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ClientDtoToClientDomainConverter implements Converter<ClientDto, ClientDomain> {
	@Override
	public ClientDomain convert(final ClientDto source) {
		return ClientDomain //
				.build() //
				.name(source.getName()) //
				.clientId(source.getClientId()) //
				.builder();
	}
}