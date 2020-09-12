package br.com.fiap.aoj.wishlist.applications;

import br.com.fiap.aoj.wishlist.data.WishRepository;
import br.com.fiap.aoj.wishlist.domain.WishDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FindWishUseCase {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddWishUseCase.class);

	private final WishRepository wishRepository;

	public FindWishUseCase(final WishRepository wishRepository) {
		this.wishRepository = wishRepository;
	}

	public Stream<WishDomain> find(final String clientId){
		LOGGER.debug("m=find(clientId={})", clientId);

		return wishRepository.findByClientClientId(clientId);
	}
}