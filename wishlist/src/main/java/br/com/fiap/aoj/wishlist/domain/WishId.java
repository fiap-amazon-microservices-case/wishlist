package br.com.fiap.aoj.wishlist.domain;

import java.io.Serializable;

public class WishId implements Serializable {

	private static final long serialVersionUID = -4382420909560484131L;

	private String clientId;

	private String productId;

	private WishId(final String clientId, final String productId){
		this.clientId = clientId;
		this.productId = productId;
	}

	public static final WishId of(final String clientId, final String productId){
		return new WishId(clientId, productId);
	}
	
	//Construtor padrão para serialização do mongo
	public WishId(){}

	public String getProductId() {
		return productId;
	}

	public String getClientId() {
		return clientId;
	}
}
