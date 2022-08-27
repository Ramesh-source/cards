package com.publicis.creditcard.utilities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String statusMsg;
	private String statusCode;
	private T data;

	public ResponseDTO(T data, StatusEnum status, String statusCode) {
		this(data, status.getStatus(), statusCode);
	}

	public ResponseDTO(T data, String status, String statusCode) {
		this.data = data;
		this.statusMsg = status;
		this.statusCode = statusCode;
	}

}
