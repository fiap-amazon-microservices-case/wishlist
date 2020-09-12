package br.com.fiap.aoj.wishlist.interfaces.converters;

import br.com.fiap.aoj.wishlist.domain.ClientDomain;
import br.com.fiap.aoj.wishlist.interfaces.dtos.ClientDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ClientDomainToClientDtoConverter implements Converter<ClientDomain, ClientDto> {

	@Override
	public ClientDto convert(final ClientDomain source) {
		final ClientDto clientDto = new ClientDto();
		clientDto.setClientId(source.getClientId());
		clientDto.setName(source.getName());

		return clientDto;
	}
}