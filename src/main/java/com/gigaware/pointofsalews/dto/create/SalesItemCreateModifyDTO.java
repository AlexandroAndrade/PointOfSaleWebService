/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto.create;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sun.xml.txw2.annotation.XmlElement;


/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "salesItemCreate" )
@XmlAccessorType( XmlAccessType.FIELD )
@JsonIgnoreProperties( ignoreUnknown = true )
public class SalesItemCreateModifyDTO implements Serializable {

	/**
	 * AspctJ
	 */
	private static final long serialVersionUID = 6955326315863736109L;
	
	private String itemKey;
	private String itemName;
	private Long idProvider;
	private Long idDepartment;
	private String codeBar;
	private String branch;
	
	/**
	 * @return the itemKey
	 */
	public String getItemKey() {
		return itemKey;
	}
	
	/**
	 * @param itemKey the itemKey to set
	 */
	public void setItemKey(final String itemKey) {
		this.itemKey = itemKey;
	}
	
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * @return the idProvider
	 */
	public Long getIdProvider() {
		return idProvider;
	}
	
	/**
	 * @param idProvider the idProvider to set
	 */
	public void setIdProvider(final Long idProvider) {
		this.idProvider = idProvider;
	}
	
	/**
	 * @return the idDepartment
	 */
	public Long getIdDepartment() {
		return idDepartment;
	}
	
	/**
	 * @param idDepartment the idDepartment to set
	 */
	public void setIdDepartment(final Long idDepartment) {
		this.idDepartment = idDepartment;
	}
	
	/**
	 * @return the codeBar
	 */
	public String getCodeBar() {
		return codeBar;
	}
	
	/**
	 * @param codeBar the codeBar to set
	 */
	public void setCodeBar(final String codeBar) {
		this.codeBar = codeBar;
	}
	
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(final String branch) {
		this.branch = branch;
	}

}
