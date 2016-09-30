/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.gigaware.pointofsalews.dao.BranchDao;
import com.gigaware.pointofsalews.dao.DepartmentDao;
import com.gigaware.pointofsalews.dao.ProviderDao;
import com.gigaware.pointofsalews.dao.SalesItemDao;
import com.gigaware.pointofsalews.dto.item.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.entity.Branch;
import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.entity.Inventory;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SaleItem;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "helloWorldWebService")
@Transactional
public class HelloWorldServiceImpl 
	implements HelloWorldService, Serializable {

//	@Autowired
//	private SalesItemWebService salesItemWebService;
	
	@Autowired
	private ProviderDao providerDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private SalesItemDao salesItemDao;

	/**
	 * AspectJ
	 */
	private static final long serialVersionUID = -2970873301857903034L;
	
	@Override
	public String helloWorld() {
		return "Hola Chiki, te quiero (F) !!!";
	}
	
	@Override
	public String getSystemProperty() {
		
		final StringBuilder sb = new StringBuilder();
		for( Map.Entry<Object, Object> prop : System.getProperties().entrySet() ){
			sb.append( prop.getKey().toString() + " -> " + prop.getValue().toString() + " \n");
		}
		return sb.toString();

	}
	

	
	
	private static final String letters = "abcdefhgijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final Random r = new Random();
	
	private static final int sizeOfStrings = 20;
	private static final int inventoryMaxSize = 100;
	private static final int inventoryMinSize = 50;
	private static final int salePriceMax = 100;
	private static final int salePriceMin = 50;
	
	private List<Provider> providers;
	private List<Department> departments;
	private List<Branch> branches;
	
	@Override
	public String createSaleItems( int n ) {
		
		if( CollectionUtils.isEmpty( providers ) ){
			providers   = providerDao.getAll();
		}

		if( CollectionUtils.isEmpty( departments ) ){
			departments = departmentDao.getAll();
		}
		
		if( CollectionUtils.isEmpty( branches ) ){
			branches = branchDao.getAll();
		}

		for( int i = 1; i <= n; i++ ){
			createDTO();
		}
		return "" + n + " SaleItems Were Created...";
	}
	
	private String createRandomString() {
		StringBuilder sb = new StringBuilder( sizeOfStrings );
		try{
		
			for( int i = 1; i <= sizeOfStrings; i++ ) {
				sb.append( letters.charAt( r.nextInt( letters.length() ) ) );
			}
		}catch( Exception e ) {
			System.out.println( "Exception !!! -> " + e.getMessage() );
		}	
			
		return sb.toString();
	}
	
	private void createDTO(){
		SaleItem item = new SaleItem();
		item.setItemKey( createRandomString() );
		item.setItemName( createRandomString() );
		item.setBrand( createRandomString() );
		item.setCodeBars( createRandomString() );
		
		Department d = departments.get( r.nextInt( departments.size() ) );
		item.setDepartment( d );
		
		Provider p = providers.get( r.nextInt( providers.size() ) );
		item.setProvider( p );
		
		for(Branch b : branches ){
			Inventory inv = new Inventory();
			inv.setBranch( b );
			
			int inventoryInt;
			try{
				inventoryInt = r.nextInt( inventoryMaxSize - inventoryMinSize ) + inventoryMinSize; 
			}catch( Exception e ){
				System.out.println( "Exception !!! -> " + e.getMessage() );
				inventoryInt = 8877;
			}
			
			inv.setInventory( Float.parseFloat( "" + inventoryInt ) );
			inv.setSaleItem( item );
			item.getInventory().add( inv );
		}
		
		int salePrice = r.nextInt( salePriceMax - salePriceMin ) + salePriceMin;
		item.setSalePrice( Float.parseFloat( "" + salePrice ) );
		item.setAverageCost( 0.0F );
		salesItemDao.save( item );
		

	}
	
	
}
