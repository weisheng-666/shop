package com.xyz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="t_keyword")
@JsonIgnoreProperties(ignoreUnknown = true, value={"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Keyword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "keyword_id")
	private Long keywordId;
	
	private String name;
	private String phone;
	private String email;
	private String address;
	@Column(name = "two_bar_code_url")
	private String twoBarCodeImgUrl;
	@Lob
	@Column(name = "about_us")
	private String aboutUs;
	@Lob
	@Column(name = "user_agreement")
	private String userAgreement;
	@Lob
	@Column(name = "common_problem")
	private String commonProblem;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getKeywordId() {
		return keywordId;
	}
	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTwoBarCodeImgUrl() {
		return twoBarCodeImgUrl;
	}
	public void setTwoBarCodeImgUrl(String twoBarCodeImgUrl) {
		this.twoBarCodeImgUrl = twoBarCodeImgUrl;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public String getUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(String userAgreement) {
		this.userAgreement = userAgreement;
	}
	public String getCommonProblem() {
		return commonProblem;
	}
	public void setCommonProblem(String commonProblem) {
		this.commonProblem = commonProblem;
	}
}
