package com.future.saf.sample.rocketmq.transaction.exception;

public class BizException extends RuntimeException {

	private static final long serialVersionUID = -7191943946113072586L;

	/**
	 * 错误编码
	 */
//	private int errorCode;

	public BizException(String message) {
		super(message);
	}

//    public BizException(ErrorCode errorCode) {
//        super(errorCode.getErrorMsg());
//        this.setErrorCode(errorCode.getErrorCode());
//    }

//	public BizException(int errorCode, String message) {
//		super(message);
//		this.setErrorCode(errorCode);
//	}

//	public int getErrorCode() {
//		return errorCode;
//	}
//
//	public void setErrorCode(int errorCode) {
//		this.errorCode = errorCode;
//	}
}
