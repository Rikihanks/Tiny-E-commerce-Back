package com.tiny.ecommerce.TinyEcommerce.request;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class ItemRequest {

	private Long id;

	private String itemName;

	private Float itemPrice;

	private String itemPictureUrl;

	private String description;

	public ItemRequest(Long id, String itemName, Float itemPrice, String itemPictureUrl, String description) {
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemPictureUrl = itemPictureUrl;
		this.description = description;
	}

	public ItemRequest() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemPictureUrl() {
		return itemPictureUrl;
	}

	public void setItemPictureUrl(String itemPictureUrl) {
		this.itemPictureUrl = itemPictureUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
