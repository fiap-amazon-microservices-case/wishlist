package br.com.fiap.aoj.wishlist.data;

import br.com.fiap.aoj.wishlist.domain.WishDomain;
import br.com.fiap.aoj.wishlist.domain.WishId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
import java.util.stream.Stream;

public interface WishRepository extends MongoRepository<WishDomain, WishId> {

	public Stream<WishDomain> findByClientClientId(final String clientId);

}