package org.sanjay.javabrains.messanger.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	String errorMessage;
	int errorCode;
	String documentationLink;

	public ErrorMessage() {

	}

	public ErrorMessage(String errorMessage, int errorCode, String documentationLink) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentationLink = documentationLink;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentationLink() {
		return documentationLink;
	}

	public void setDocumentationLink(String documentationLink) {
		this.documentationLink = documentationLink;
	}

}
