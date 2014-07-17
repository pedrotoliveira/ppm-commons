package com.ppm.commons.samples;

import java.io.Serializable;

import org.w3c.dom.Document;

import com.ppm.commons.annotation.ToStringStyle;
import com.ppm.commons.annotation.ToStringStyle.Style;

/**
 * A Fake Router Context just only for test!
 * 
 * DO NOT USE THIS CLASS for other things...
 * 
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
public class FakeRouterContext<Request, Response> implements Serializable {
	
	private static final long serialVersionUID = 3273535740462452497L;
	
	public static final String BPAG_PAYMENT_METHOD_CONFIG_KEY = "egw.bpag.router.?.?";
	
	@ToStringStyle(value=Style.CALL_TO_STRING)
	protected Document requestDocument;
	@ToStringStyle(value=Style.CALL_TO_STRING)
	protected Document responseDocument;	
	protected Request requestObject;
	protected Response responseObject;		
	protected boolean exceptionFlow = false;
	protected Class<?> exceptionCommand = null;
	protected Throwable exceptionThrown = null;
	
	public Document getRequestDocument() {
		return requestDocument;
	}

	public void setRequestDocument(Document requestDocument) {
		this.requestDocument = requestDocument;
	}

	public Document getResponseDocument() {
		return responseDocument;
	}

	public void setResponseDocument(Document responseDocument) {
		this.responseDocument = responseDocument;
	}

	public Request getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(Request requestObject) {
		this.requestObject = requestObject;
	}

	public Response getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Response responseObject) {
		this.responseObject = responseObject;
	}

	/**
	 * @return the exceptionFlow
	 */
	public boolean isExceptionFlow() {
		return exceptionFlow;
	}

	/**
	 * @param exceptionFlow the exceptionFlow to set
	 */
	public void setExceptionFlow(boolean exceptionFlow) {
		this.exceptionFlow = exceptionFlow;
	}

	public Class<?> getExceptionCommand() {
		return exceptionCommand;
	}

	public void setExceptionCommand(Class<?> exceptionCommand) {
		this.exceptionCommand = exceptionCommand;
	}
	
	/**
	 * @return the exceptionThrown
	 */
	public Throwable getExceptionThrown() {
		return exceptionThrown;
	}

	/**
	 * @param exceptionThrown the exceptionThrown to set
	 */
	public void setExceptionThrown(Throwable exceptionThrown) {
		this.exceptionThrown = exceptionThrown;
	}
}
