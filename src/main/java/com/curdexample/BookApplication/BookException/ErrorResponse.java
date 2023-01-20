package com.curdexample.BookApplication.BookException;

public class ErrorResponse {



        private int code;
        private String errorMsg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public ErrorResponse() {
        }

        public ErrorResponse(int code, String errorMsg) {
            this.code = code;
            this.errorMsg = errorMsg;
        }

}
