package br.com.fiap.aoj.wishlist.interfaces;

import br.com.fiap.aoj.wishlist.applications.FindWishUseCase;
import br.com.fiap.aoj.wishlist.applications.AddWishUseCase;
import br.com.fiap.aoj.wishlist.domain.WishDomain;
import br.com.fiap.aoj.wishlist.interfaces.converters.WishDomainToWishDtoConverter;
import br.com.fiap.aoj.wishlist.interfaces.converters.WishDtoToWishDomainConverter;
import br.com.fiap.aoj.wishlist.interfaces.dtos.WishDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "${api.version.v1:/v1}/wishes")
class WishesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WishesController.class);

	private final AddWishUseCase addWishUseCase;
	private final FindWishUseCase findWishUseCase;
	private final WishDtoToWishDomainConverter wishDtoToWishDomainConverter;
	private final WishDomainToWishDtoConverter wishDomainToWishDtoConverter;

	WishesController(final AddWishUseCase addWishUseCase,
			final FindWishUseCase findWishUseCase,
			final WishDtoToWishDomainConverter wishDtoToWishDomainConverter,
			final WishDomainToWishDtoConverter wishDomainToWishDtoConverter) {
		this.addWishUseCase = addWishUseCase;
		this.findWishUseCase = findWishUseCase;
		this.wishDtoToWishDomainConverter = wishDtoToWishDomainConverter;
		this.wishDomainToWishDtoConverter = wishDomainToWishDtoConverter;
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Mono<WishDto> add(@RequestBody @Valid final WishDto wishDto){
		LOGGER.debug("m=add(ticketDto={})", wishDto);

		final WishDomain wishDomain = wishDtoToWishDomainConverter.convert(wishDto);
		return addWishUseCase.add(wishDomain) //
			.map(wishDomainToWishDtoConverter::convert) //
			.map(Mono::just) //
			.orElseGet(() -> Mono.error(new IllegalArgumentException()));
	}

	@GetMapping
	@ResponseStatus(OK)
	public Flux<WishDto> find(@RequestParam("clientId") String clientId){
		LOGGER.debug("m=find(clientId={})", clientId);

		return Flux //
				.fromStream(findWishUseCase.find(clientId) //
				.map(wishDomainToWishDtoConverter::convert));
	}
}