package com.fenrir.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * vo - 数据
 * @author fenrir
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataVO implements Serializable {
	
	private static final long serialVersionUID = -202009221504L;

    private String applicationName;
	
    private String port;
	
	private BigDecimal decimal;
	
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
	private Timestamp creationTime;
	
}