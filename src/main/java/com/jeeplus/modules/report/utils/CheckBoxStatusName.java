package com.jeeplus.modules.report.utils;

public enum CheckBoxStatusName {
	CHECKNO("0","否"),CHECKYES("1","是");
	private String value;
    private String text;

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

	private CheckBoxStatusName(String value,String text){
        this.value = value;
        this.text = text;
    }
}
