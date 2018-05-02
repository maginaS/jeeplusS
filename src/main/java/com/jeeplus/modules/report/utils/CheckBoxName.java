package com.jeeplus.modules.report.utils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

public class CheckBoxName {
	
	public CheckBoxName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String changeName(Object o){
		if(!o.toString().equals(CheckBoxStatusName.CHECKNO.getValue()) && !o.toString().equals(CheckBoxStatusName.CHECKYES.getValue())){
			return null;
		}else if(o.toString().equals(CheckBoxStatusName.CHECKNO.getValue())){
			return CheckBoxStatusName.CHECKNO.getText();
		}else if(o.toString().equals(CheckBoxStatusName.CHECKYES.getValue())){
			return CheckBoxStatusName.CHECKYES.getText();
		}else{
			return "";	
		}
	}
	
	public String changeName(Object o,String checkString){
		if(o.toString().trim() == null || o.toString().trim() == "" || checkString == null || checkString == ""){
			return "";
		}
		if(!o.toString().equals(checkString)){
			return null;
		}else if(o.toString().equals(checkString)){
			return checkString;
		}else{
			return "";	
		}
	}
	
	public String changeNameForMap(Object o) {
		Map<String, String> map = new HashMap<String, String>();
		for (CheckBoxStatusNameFiveLevel s : EnumSet.allOf(CheckBoxStatusNameFiveLevel.class)) {
			map.put(s.getValue(), s.getText());
		}
		for (String str : map.keySet()) {
			if (o.toString().trim().equals(str)) {
				return map.get(str);
			}
		}
		return null;
	}
	
	public static Map<String, String> getEnum(Class<T> enumT) {
		if (!enumT.isEnum()){ //不是枚举则返回""  
	        return null;  
	    }
		T[] enums = enumT.getEnumConstants(); 
	    
		if (enums == null || enums.length <= 0) {  
	        return null;  
	    }  
		String valueMathod = "getValue"; 
		Map<String, String> map = new HashMap<String, String>();
		for(T t :enums){
			map.put(t.toString(), getMethodValue(valueMathod, t).toString());
			//getMethodValue(valueMathod, t);
		}
//		
		return map;
	}
	/**
	 * 未实现
	 * TODU 将枚举作为参数传入,匹配
	 * @param o
	 * @param enumT
	 * @return
	 */
	public String changeName122(Object o,Class<T> enumT) {
		if (!enumT.isEnum()){ //不是枚举则返回""  
	        return "";  
	    }
		T[] enums = enumT.getEnumConstants(); 
	    
		if (enums == null || enums.length <= 0) {  
	        return "";  
	    }  
		String valueMathod = "getValue"; 
		Map<String, String> map = new HashMap<String, String>();
		for(T t :enums){
			map.put(t.toString(), getMethodValue(valueMathod, t).toString());
			//getMethodValue(valueMathod, t);
		}
//		for (T s : EnumSet.allOf(T.class)) {
//			map.put(s.getValue(), s.getText());
//		}
		for (String str : map.keySet()) {
			if (o.toString().trim().equals(str)) {
				return map.get(str);
			}
		}
		return null;
	}
	
	
	/**
	 * 根据反射，通过方法名称获取方法值，忽略大小写的
	 * @param methodName
	 * @param obj
	 * @param args
	 * @return return value
	 */
	private static <T> Object getMethodValue(String methodName, T obj,
			Object... args) {
		Object resut = "";
		// boolean isHas = false;
		try {
			/********************************* start *****************************************/
			Method[] methods = obj.getClass().getMethods(); //获取方法数组，这里只要共有的方法
			if (methods.length <= 0) {
				return resut;
			}
			// String methodstr=Arrays.toString(obj.getClass().getMethods());
			// if(methodstr.indexOf(methodName)<0){ //只能粗略判断如果同时存在 getValue和getValues可能判断错误
			// return resut;
			// }
			// List<Method> methodNamelist=Arrays.asList(methods); //这样似乎还要循环取出名称
			Method method = null;
			for (int i = 0, len = methods.length; i < len; i++) {
				if (methods[i].getName().equalsIgnoreCase(methodName)) { //忽略大小写取方法
					// isHas = true;
					methodName = methods[i].getName(); //如果存在，则取出正确的方法名称
					method = methods[i];
					break;
				}
			}
			// if(!isHas){
			// return resut;
			// }
			/*************************** end ***********************************************/
			// Method method = obj.getClass().getDeclaredMethod(methodName); ///确定方法
			if (method == null) {
				return resut;
			}
			resut = method.invoke(obj, args); //方法执行
			if (resut == null) {
				resut = "";
			}
			return resut; //返回结果
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resut;
	}
}
