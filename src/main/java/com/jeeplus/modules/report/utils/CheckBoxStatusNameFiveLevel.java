package com.jeeplus.modules.report.utils;

public enum CheckBoxStatusNameFiveLevel {
	CHECK_ONE("1","良好"),CHECK_TWO("2","好"),CHECK_THREE("3","一般"),CHECK_FOUR("4","差"),CHECK_FIVE("5","很差");
	private String value;
    private String text;
    /** 
     * enum lookup map 
     */  
//    public static final Map<String, String> lookup = new HashMap<String, String>();  
//  
//    static {  
//        for (CheckBoxStatusNameFiveLevel s : EnumSet.allOf(CheckBoxStatusNameFiveLevel.class)) {  
//            lookup.put(s.getValue(), s.getText());  
//        }  
//    }  
    
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private CheckBoxStatusNameFiveLevel(String value,String text){
        this.value = value;
        this.text = text;
    }
	//测试
//	public static void main(String[] args) {
//		Map<String, String> lookup = new HashMap<String, String>();  
//		  
//	        for (CheckBoxStatusNameFiveLevel s : EnumSet.allOf(CheckBoxStatusNameFiveLevel.class)) {  
//	            lookup.put(s.getValue(), s.getText());  
//	        }  
//	        for (String str : lookup.keySet()) {
//				System.out.println(str);
//				System.out.println(lookup.get(str));
//				System.out.println("------");
//			}
//
//		System.out.println(lookup);
//	}
}
