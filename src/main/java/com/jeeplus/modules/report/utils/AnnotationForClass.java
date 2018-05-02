package com.jeeplus.modules.report.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.google.common.collect.Lists;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

public class AnnotationForClass {

public List<Object[]> getAnnotationList(Class<?> cls){
	// Get annotation field 
	// 注解列表（Object[]{ ExcelField, Field/Method }）
	List<Object[]> annotationList = Lists.newArrayList();
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs){
			ExcelField ef = f.getAnnotation(ExcelField.class);
			if (ef != null && (ef.type()==0 || ef.type()==1)){
//				if (groups!=null && groups.length>0){
//					boolean inGroup = false;
//					for (int g : groups){
//						if (inGroup){
//							break;
//						}
//						for (int efg : ef.groups()){
//							if (g == efg){
//								inGroup = true;
//								annotationList.add(new Object[]{ef, f});
//								break;
//							}
//						}
//					}
//				}else{
					annotationList.add(new Object[]{ef, f});
					
//				}
			}
		}
		return annotationList;
	}
}
