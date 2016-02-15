/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sun.xml.txw2.annotation.XmlElement;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@XmlElement( value = "branch")
@XmlAccessorType( XmlAccessType.FIELD )
public class BranchDto implements Serializable {

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -948748416562501750L;
	
	private Long idBranch;
	private String branchName;
	public Long getIdBranch() {
		return idBranch;
	}
	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

	
}
