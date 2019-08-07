package com.biz.bbs.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ScriptAssert(lang="javascript",
				script="_this.m_password == _this.m_re_password",
				reportOn = "m_re_password",
				message = "비밀번호와 비밀번호 확인이 일치하지 않습니다.")
public class MemberVO {
	@NotBlank(message = "* 사용자 ID는 반드시 입력해야 합니다.")
	@NotNull(message = "* 사용자 ID는 반드시 입력해야 합니다.")
	@Size(min=5,max=15,message = "* 사용자 ID는 5자 이상 15자 이하여야합니다.")
	private String m_userid;
	
	private String m_password;
	private String m_re_password;
	
	private String m_name;
	@Email(message = "* 이메일 형식을 확인 하세요")
	private String m_email;
	@Pattern(regexp = "\\d{1,15}", message="*전화번호는 숫자 1자리부터 15자리까지만 사용 가능합니다.")
	private String m_tel;
	private String m_role;
}