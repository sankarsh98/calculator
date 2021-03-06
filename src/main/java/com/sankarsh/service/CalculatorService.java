package com.sankarsh.service;

import org.springframework.stereotype.Service;

import com.sankarsh.beans.CalculatorBean;

@Service
public class CalculatorService {
	
	public double result(CalculatorBean bean) throws Exception {
		
		String type=bean.getType();
		int k;
		int res=0;
		double res1=0;
		boolean isInt=type.equalsIgnoreCase("integer");
		try {
		switch(bean.getOperation()) {
			case "add": for(Number i:bean.getValues()) {
							if(isInt) {
								res+=i.intValue();
							}else {
								res1+=i.doubleValue();
							}

						}
						break;
						
			case "sub":  k=0;
						for(Number i:bean.getValues()) {
							if(k++==0) {
								if(isInt) {
									res=i.intValue();
								}else {
									res1=i.doubleValue();
								}
							}else {
								if(isInt) {
									res-=i.intValue();
								}else {
									res1-=i.doubleValue();
								}
							}
						}
						break;
				
			case "mul": res=1;
						res1=1;
						for(Number i:bean.getValues()) {
							if(isInt) {
								res*=i.intValue();
							}else {
								res1*=i.doubleValue();
							}
						}
						break;
				
			case "div":	k=0;
						for(Number i:bean.getValues()) {
							if(k++==0) {
								if(isInt) {
									res=i.intValue();
								}else {
									res1=i.doubleValue();
								}
							}else {
								if(isInt) {
									res/=i.intValue();
								}else {
									res1/=i.doubleValue();
								}
							}						
						}
						break;
		}
		}catch (Exception e) {
			throw e;
		}
		if(isInt) {
			return res;
		}else {
			return res1;
		}
		
	}
}
