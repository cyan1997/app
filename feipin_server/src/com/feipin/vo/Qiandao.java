package com.feipin.vo;

/**
 * 
 * @author thinkpad 签到信息
 */
public class Qiandao {
	private Integer id;

	private String content;

	private String username;

	private String status; // 备用

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
