/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import static com.gigaware.pointofsalews.exception.ExceptionConstant.EMPTY_REQUIRED_FIELD;

import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_ALREADY_EXISTS_BY_ITEM_KEY;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_BRAND;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_ALREADY_EXISTS_BY_ITEM_NAME;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_ALREADY_EXISTS_BY_CODE_BARS;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_ALREADY_EXISTS_TITLE;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_KEY;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_NAME;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_CODE_BARS;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_DEPARTMENT_ID;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_VALUE_ITEM_PROVIDER_ID;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_EMPTY_NUMERIC_VALUE_ITEM_SALE_PRICE;

import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_NOT_FOUND_TITLE;
import static com.gigaware.pointofsalews.exception.ExceptionConstant.SALES_ITEM_NOT_FOUND_BY_ID_DESCRIPTON;

import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import com.gigaware.pointofsalews.dao.BranchDao;
import com.gigaware.pointofsalews.dao.DepartmentDao;
import com.gigaware.pointofsalews.dao.ProviderDao;
import com.gigaware.pointofsalews.dao.SalesItemDao;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateAndModifyDTO;
import com.gigaware.pointofsalews.entity.Branch;
import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.entity.Inventory;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SaleItem;
import com.gigaware.pointofsalews.exception.PointOfSaleException;
import com.gigaware.pointofsalews.util.NumberUtils;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@Service( "salesItemsService" )
@Transactional
public class SalesItemsServiceImpl 
    implements SalesItemsService, Serializable {

    /**
	 * AspectJ
	 */
	private static final long serialVersionUID = -6409384080987894544L;
	
	@Autowired
    private SalesItemDao salesItemDao;
    
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private ProviderDao providerDao;
	
    @Override
    public List<SaleItem> getAll() {
        return ( List<SaleItem> ) salesItemDao.getAll();
    }
    
	@Override
	public SaleItem getById(Long id) {

		SaleItem item = salesItemDao.getById(id);
		
		if(item == null){
			throw new PointOfSaleException(
					NOT_FOUND, 
					SALES_ITEM_NOT_FOUND_TITLE, 
					String.format( SALES_ITEM_NOT_FOUND_BY_ID_DESCRIPTON, id ) 
					);
		}
		return item;
	}
	
	@Override
	public List<SaleItem> getByInventoryLessThan( Integer inventoryLessThan) {
		return salesItemDao.getByInventoryLessThan( new Float( inventoryLessThan.floatValue() ) );
	}
	
    @Override
    public SaleItem save( SalesItemCreateAndModifyDTO saleItemDto ) {
    	
    	SalesItemsServiceImpl.checkEmptyValues( saleItemDto );

    	if( salesItemDao.getByItemKey( saleItemDto.getItemKey() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_ITEM_KEY , saleItemDto.getItemKey() ) );
    	}

    	if( salesItemDao.getByItemName( saleItemDto.getItemName() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_ITEM_NAME , saleItemDto.getItemName() ) );
    	}

    	if( salesItemDao.getByCodeBars( saleItemDto.getCodeBars() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_CODE_BARS , saleItemDto.getCodeBars() ) );
    	}
    	
    	
    	//Generate Inventory equals to Zero in every branch
    	SaleItem itemToPersist = new SaleItem( saleItemDto );
    	
    	Department dep = departmentDao.getById( saleItemDto.getIdDepartment() );
    	itemToPersist.setDepartment( dep );
 
    	Provider prov = providerDao.getById( saleItemDto.getIdProvider() );
    	itemToPersist.setProvider( prov );

    	List<Branch> branchesList = branchDao.getAll();
    	for( Branch branch : branchesList ){
    		Inventory inv = new Inventory();
    		inv.setBranch( branch );
    		inv.setInventory( 0.0F );
    		inv.setSaleItem( itemToPersist );
    		inv.setSaleItem( itemToPersist );
    		itemToPersist.getInventory().add( inv );
    	}
    	
    	salesItemDao.save( itemToPersist );
    	return itemToPersist;
    	
    }

    private static void checkEmptyValues( SalesItemCreateAndModifyDTO saleItemDto ){
    	
    	validateEmptyValue( 
    			saleItemDto.getItemKey(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_KEY, 
    			CONFLICT);
    	
    	validateEmptyValue( 
    			saleItemDto.getItemName(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_NAME,
    			CONFLICT);
    	
    	validateEmptyValue( 
    			saleItemDto.getCodeBars(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_CODE_BARS,
    			CONFLICT);
    	
    	validateEmptyValue( 
    			saleItemDto.getIdDepartment(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_DEPARTMENT_ID,
    			CONFLICT);
    	
    	validateEmptyValue( 
    			saleItemDto.getIdProvider(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_PROVIDER_ID,
    			CONFLICT);
    	
    	validateEmptyValue( 
    			saleItemDto.getBrand(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_BRAND,
    			CONFLICT);

    	validateEmptyValue( 
    			saleItemDto.getSalePrice(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_NUMERIC_VALUE_ITEM_SALE_PRICE,
    			CONFLICT);


    }
    
    private static void validateEmptyValue( String field, String errorMessageTitle, String errorMessageDescription, Status errorCode ){
    	if( StringUtils.isEmpty( field ) ) {
    		throw new PointOfSaleException( errorCode, errorMessageTitle, errorMessageDescription );
    	}
    }

    private static void validateEmptyValue( Long field, String errorMessageTitle, String errorMessageDescription, Status errorCode ){
    	if( ! NumberUtils.isPositive( field  ) ) {
    		throw new PointOfSaleException( errorCode, errorMessageTitle, errorMessageDescription );
    	}
    }

    private static void validateEmptyValue( Float field, String errorMessageTitle, String errorMessageDescription, Status errorCode ){
    	if( ! NumberUtils.isPositive( field  ) ) {
    		throw new PointOfSaleException( errorCode, errorMessageTitle, errorMessageDescription );
    	}
    }


    
    @Override
    public void saveAll( List<SalesItemCreateAndModifyDTO> salesItems ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update( SaleItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete( SaleItem t ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * For Unit Test only
     * @param salesItemDao the salesItemDao to set
     */
    public void setSalesItemDao( SalesItemDao salesItemDao ) {
        this.salesItemDao = salesItemDao;
    }

    /**
     * For unit Test Only
     * @param branchDao the branchDao to set
     */
	public void setBranchDao( BranchDao branchDao ) {
		this.branchDao = branchDao;
	}

	/**
	 * For Unit Test only
	 * @param departmentDao the departmentDao to set
	 */
	public void setDepartmentDao( DepartmentDao departmentDao ) {
		this.departmentDao = departmentDao;
	}

	
	/**
	 * For Unit Test Only
	 * @param providerDao the providerDao to set
	 */
	public void setProviderDao( ProviderDao providerDao ) {
		this.providerDao = providerDao;
	}
	
	

}