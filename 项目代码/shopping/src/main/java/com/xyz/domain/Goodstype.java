package com.xyz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="t_goods_type")
@JsonIgnoreProperties(ignoreUnknown = true, value={"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Goodstype {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "goods_type_id")
	private Long goodstypeId;
	
	private String name;

	public Long getGoodstypeId() {
		return goodstypeId;
	}

	public void setGoodstypeId(Long goodstypeId) {
		this.goodstypeId = goodstypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
