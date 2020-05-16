package com.catandbear.data.entity.changepw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputEntity {

	private String username;
	private String oldpassword;
	private PasswordsGroup passwordsgroup;
	@Data
	public class PasswordsGroup{
		public String password;
		public String pwconfirm;
	}
}
