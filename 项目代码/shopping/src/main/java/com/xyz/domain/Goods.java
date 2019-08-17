package com.xyz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="t_goods")
@JsonIgnoreProperties(ignoreUnknown = true, value={"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Goods {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "goods_id")
	private Long goodsId;
	
	@Column(name = "img_url")
	private String imgUrl;
	private String name;
	private String type;
	private Float price;
	private String produce;
	private int num;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProduce() {
		return produce;
	}
	public void setProduce(String produce) {
		this.produce = produce;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", imgUrl=" + imgUrl + ", name=" + name + ", type=" + type + ", price="
				+ price + ", produce=" + produce + ", num=" + num + "]";
	}
	
}
