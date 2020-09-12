package br.com.fiap.aoj.wishlist.domain;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class WishDomain implements Serializable {

	private static final long serialVersionUID = 1649219665299117651L;

	@MongoId
	private WishId wishId;

	private ClientDomain client;

	private ProductDomain product;

	private LocalDateTime createdAt;

	private WishDomain(final Builder builder){
		this.wishId = WishId.of(builder.client.getClientId(), builder.product.getProductId());
		this.client = builder.client;
		this.product = builder.product;
		this.createdAt = builder.createdAt;
	}

	//Construtor padrão para serialização do mongo
	public WishDomain(){}

	public WishId getWishId() {
		return wishId;
	}

	public ClientDomain getClient() {
		return client;
	}

	public ProductDomain getProduct() {
		return product;
	}

	public LocalDateTime createdAt() {
		return createdAt;
	}


	public static final Client builder(){
		return new Builder();
	}

	public static final class Builder implements Client, Product, Build{
		private ClientDomain client;
		private ProductDomain product;
		private LocalDateTime createdAt = LocalDateTime.now();

		@Override
		public Product client(final ClientDomain clientDomain) {
			this.client = clientDomain;
			return this;
		}

		@Override
		public Build product(final ProductDomain productDomain) {
			this.product = productDomain;
			return this;
		}

		@Override
		public Build createdAt(final LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		@Override
		public WishDomain builder() {
			return new WishDomain(this);
		}
	}

	public interface Client{
		public Product client(final ClientDomain clientDomain);
	}

	public interface Product{
		public Build product(final ProductDomain productDomain);
	}

	public interface Build{
		public Build createdAt(final LocalDateTime createdAt);
		public WishDomain builder();
	}
}
