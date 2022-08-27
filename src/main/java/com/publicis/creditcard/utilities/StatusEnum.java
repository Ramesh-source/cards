package com.publicis.creditcard.utilities;

public enum StatusEnum {
	
  SUCCESS("SUCCESS"), FAIL("FAIL"), ERROR("ERROR"), NODATA("NODATA");
	
	private final String status;
	
	private StatusEnum(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
