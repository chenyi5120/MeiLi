package com.chen.meili.entity;

import java.io.Serializable;

/**
 * 
 * @author CHEN
 *
 */
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName; // 用户名
	private String password; // 用户密码
	private String nickName;// 昵称
	private String userNumber;// 手机号
	private String userEmail;// 邮箱
	private String iconUrl;// 头像
	private char sex;// 用户性别

	public UserEntity() {
		super();
	}

	public UserEntity(String userName, String password, String nickName, String userNumber, String userEmail,
			String iconUrl, char sex) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.userNumber = userNumber;
		this.userEmail = userEmail;
		this.iconUrl = iconUrl;
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", password=" + password + ", nickName=" + nickName
				+ ", userNumber=" + userNumber + ", userEmail=" + userEmail + ", iconUrl=" + iconUrl + ", sex=" + sex
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + sex;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userNumber == null) ? 0 : userNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (iconUrl == null) {
			if (other.iconUrl != null)
				return false;
		} else if (!iconUrl.equals(other.iconUrl))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex != other.sex)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userNumber == null) {
			if (other.userNumber != null)
				return false;
		} else if (!userNumber.equals(other.userNumber))
			return false;
		return true;
	}

}
