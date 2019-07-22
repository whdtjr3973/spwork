package com.biz.iolist.medel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	
	private String p_code;//	varchar2(5 byte)
	private String p_name;//	nvarchar2(50 char)
	private int p_iprice;//	number
	private int p_oprice;//	NUMBER

}
