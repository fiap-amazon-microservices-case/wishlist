package br.com.fiap.aoj.wishlist.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.*;

public class WishDto {

	@Valid
	@NotNull(message = "Campo obrigatório")
	private ClientDto client;

	@JsonProperty(access = READ_ONLY)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createdAt;

	@Valid
	@NotNull(message = "Campo obrigatório")
	private ProductDto product;


	public ClientDto getClient() {
		return client;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
}
