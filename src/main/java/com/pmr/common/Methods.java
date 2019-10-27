/**
 * 
 */
package com.pmr.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pmr
 *
 */
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Methods {
	private String accessModifier;
	private boolean staticMethod;
	private boolean finalMethod;
	private String returnType;
	private String name;
	@JsonProperty("args")
	private List<Args> args;

	public String getAccessModifier() {
		return accessModifier;
	}

	public boolean getStaticMethod() {
		return staticMethod;
	}

	public boolean getFinalMethod() {
		return finalMethod;
	}

	public String getReturnType() {
		return returnType;
	}

	public String getName() {
		return name;
	}

	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public void setStaticMethod(boolean staticMethod) {
		this.staticMethod = staticMethod;
	}

	public void setFinalMethod(boolean finalMethod) {
		this.finalMethod = finalMethod;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Args> getArgs() {
		return args;
	}

	public void setArgs(List<Args> args) {
		this.args = args;
	}
}
