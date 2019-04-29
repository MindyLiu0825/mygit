package com.cn.mindy.shop.pojo.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("pageVo")
@Scope("prototype")
public class PageVo implements Serializable{
	

		private static final long serialVersionUID = 5544282910861954161L;
		
	
		private int cid;
		
		private int begin;
		
		private int limit;
	
	    
		
		public PageVo() {
		
		}


		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public int getBegin() {
			return begin;
		}

		public void setBegin(int begin) {
			this.begin = begin;
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}



		@Override
		public String toString() {
			return "PageVo [cid=" + cid + ", begin=" + begin + ", limit="
					+ limit + "]";
		}
	
	
}
