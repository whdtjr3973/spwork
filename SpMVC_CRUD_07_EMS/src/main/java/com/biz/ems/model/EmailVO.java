package com.biz.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailVO {

    private long ems_seq;
	@NotBlank(message="* 보내는 Email은 필수 입니다.")
	@Email(message="* Email형식이 잘못되었습니다.")	
    private String ems_to_email;
	@NotBlank(message="* 받는 Email은 필수 입니다.")
	@Email(message="* Email형식이 잘못되었습니다.")
    private String ems_from_email;
	@NotBlank(message="* 보내는 사람 항목은 필수 입니다.")
    private String ems_to_name;
    private String ems_from_name;
    private String ems_send_date;
    private String ems_send_time;
    @NotBlank(message="* 제목을 입력해주세요.")
    private String ems_subject;
    @NotBlank(message="* 내용을 입력해주세요.")
    private String ems_content;
    private String ems_file1;
    private String ems_file2;

}
