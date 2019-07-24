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

// @Data
public class IolistVO {
	
	private Long io_seq;//	NUMBER
	private String io_date;//	VARCHAR2(10)
	private String io_pcode;//	nVARCHAR2(50)
	private String io_ccode;//	nVARCHAR2(50)
	private String io_ceo;//	nVARCHAR2(50)
	private String io_inout;//	VARCHAR2(1)
	private int io_amt;//	NUMBER
	private int io_price;//	NUMBER
	private int io_total;//	NUMBER

}
