package com.publicis.creditcard.utilities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomErrorResponse {

	String errorCode;
	String errorMsg;
}
