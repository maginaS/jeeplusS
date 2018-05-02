/**
 * 
 */
package com.jeeplus.modules.tools.utils;

/**
 * @author MikeSun
 *
 */
public enum JBZL {
	
	
	GRXJBK("感染性疾病科", 1),
	EK("儿科", 2),
	YEBYHK("眼、耳鼻咽喉科", 3), 
	NK("内科", 4),  
	WKFCK("外科、妇（产）科", 5),  
	KQK("口腔科", 6),  
	PFK("皮肤科", 7);  
    // 成员变量  
    private String name;  
    private int index;  
    // 构造方法  
    private JBZL(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
    
    // 普通方法  
    public static String getName(int index) {  
        for (JBZL c : JBZL.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    
    
    public static JBZL getjbzlEnumbyindex(int index) {
    	for(JBZL jz : JBZL.values()) {
    		if(String.valueOf(index).equals(String.valueOf(jz.getIndex()))) {
    			return jz;
    		}
    	}
		return null;
    	
    }
    
//    public static void main(String[] args) {
//		
//	}
    
    
//    JBZL.
   
//    public static JBZL getSexEnumByCode(int index){  
//    	   for(JBZL sexEnum : JBZL.values()){  
//    	     if(StringUtils.equals(String.valueOf(index), JBZL.getSexEnumByCode(index))){  
//    	       return sexEnum;  
//    	     }  
//    	   }  
//    	   return null;  
//    	 }  
    
    // get set 方法  
   
    
    
//    public static void main(String[] args) {
//    	System.out.println("----------->"+JBZL.getjbzlEnumbyindex(1));
//    	JBZL name = JBZL.getjbzlEnumbyindex(1);
//    	System.out.println(name);
//	}
	
	
	

}
