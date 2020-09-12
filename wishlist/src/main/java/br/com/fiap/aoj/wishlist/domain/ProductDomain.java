package br.com.fiap.aoj.wishlist.domain;


import java.io.Serializable;

public class ProductDomain implements Serializable {

	private static final long serialVersionUID = 9015380026072395472L;

	private String productId;

	private String name;

	private ProductDomain(final Builder builder){
		this.productId = builder.productId;
		this.name = builder.name;
	}

	//Construtor padrão para serialização do mongo
	public ProductDomain(){}

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public static final ProductId builder(){
		return new Builder();
	}

	public static final class Builder implements ProductId, Name, Build{
		private String productId;
		private String name;

		@Override
		public Name productId(final String productId) {
			this.productId = productId;
			return this;
		}

		@Override
		public Build name(final String name) {
			this.name = name;
			return this;
		}

		@Override
		public ProductDomain build() {
			return new ProductDomain(this);
		}
	}

	public interface ProductId{
		public Name productId(final String productId);
	}

	public interface Name{
		public Build name(final String name);
	}

	public interface Build{
		public ProductDomain build();
	}
}