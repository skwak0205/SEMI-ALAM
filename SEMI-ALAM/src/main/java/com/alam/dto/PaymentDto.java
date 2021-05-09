package com.alam.dto;

import java.util.Date;

public class PaymentDto {
	private int payment_no;
	private String buyer_id;
	private String buyer_tel;
	private int class_no;
	private String seller_id;
	private String class_title;
	private String class_video;
	private int class_price;
	private int class_category;
	private Date buy_date;
	
	public PaymentDto() {
		
	}

	public PaymentDto(int payment_no, String buyer_id, String buyer_tel, int class_no, String seller_id,
			String class_title, String class_video, int class_price, int class_category, Date buy_date) {
		this.payment_no = payment_no;
		this.buyer_id = buyer_id;
		this.buyer_tel = buyer_tel;
		this.class_no = class_no;
		this.seller_id = seller_id;
		this.class_title = class_title;
		this.class_video = class_video;
		this.class_price = class_price;
		this.class_category = class_category;
		this.buy_date = buy_date;
	}

	public int getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_tel() {
		return buyer_tel;
	}

	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}

	public int getClass_no() {
		return class_no;
	}

	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getClass_title() {
		return class_title;
	}

	public void setClass_title(String class_title) {
		this.class_title = class_title;
	}

	public String getClass_video() {
		return class_video;
	}

	public void setClass_video(String class_video) {
		this.class_video = class_video;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}

	public int getClass_category() {
		return class_category;
	}

	public void setClass_category(int class_category) {
		this.class_category = class_category;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
}
