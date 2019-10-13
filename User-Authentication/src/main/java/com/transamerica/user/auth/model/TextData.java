package com.transamerica.user.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TextData")
public class TextData {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
