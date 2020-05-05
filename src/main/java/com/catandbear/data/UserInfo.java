package com.catandbear.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {

	private String userName;
	private String passWord;
	private String userType;
	private String email;
	private String mobileNum;
	private String confiremed;

}
