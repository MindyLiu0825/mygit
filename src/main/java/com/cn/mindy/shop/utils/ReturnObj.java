package com.cn.mindy.shop.utils;


/**
 * 将返回的信息封装在c此类的对象中
 */
public class ReturnObj {

        private boolean success;
        private String message;

        public ReturnObj() {

        }

        public ReturnObj(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}
