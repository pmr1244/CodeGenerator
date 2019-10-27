/**
 * 
 */
package com.pmr.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author pmr
 *
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variables {
	private String accessModifier;
	private boolean staticVariable;
	private boolean finalVariable;
	private String type;
	private String name;
	private Object initialValue;

	public String getAccessModifier() {
		return accessModifier;
	}

	public boolean getStaticVariable() {
		return staticVariable;
	}

	public boolean getFinalVariable() {
		return finalVariable;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Object getInitialValue() {
		return initialValue;
	}

	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public void setStaticVariable(boolean staticVariable) {
		this.staticVariable = staticVariable;
	}

	public void setFinalVariable(boolean finalVariable) {
		this.finalVariable = finalVariable;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInitialValue(Object initialValue) {
		this.initialValue = initialValue;
	}
}
