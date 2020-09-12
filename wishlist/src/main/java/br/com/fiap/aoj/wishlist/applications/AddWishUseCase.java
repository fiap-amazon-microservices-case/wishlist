package br.com.fiap.aoj.wishlist.applications;

import br.com.fiap.aoj.wishlist.data.WishRepository;
import br.com.fiap.aoj.wishlist.domain.WishDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddWishUseCase {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddWishUseCase.class);

	private final WishRepository wishRepository;

	public AddWishUseCase(final WishRepository wishRepository) {
		this.wishRepository = wishRepository;
	}

	public Optional<WishDomain> add(final WishDomain wishDomain){
		try{
			LOGGER.debug("m=add(ticketDomain={})", wishDomain);

			return Optional.of(wishRepository.save(wishDomain));
		}catch (Exception exception){
			LOGGER.error("ex(message={}, cause={})", exception.getMessage(), exception);
			return Optional.empty();
		}
	}
}