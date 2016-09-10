/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import static com.gigaware.pointofsalews.exception.ExceptionConstant.*;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import com.gigaware.pointofsalews.constant.PosConstants;
import com.gigaware.pointofsalews.dao.BranchDao;
import com.gigaware.pointofsalews.dao.DepartmentDao;
import com.gigaware.pointofsalews.dao.ProviderDao;
import com.gigaware.pointofsalews.dao.SalesItemDao;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.dto.create.SalesItemUpdateDTO;
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
import org.springframework.util.CollectionUtils;

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
	public SaleItem getByItemKey( String itemKey ) {
		validateEmptyValue( itemKey, EMPTY_REQUIRED_FIELD, SALES_ITEM_EMPTY_VALUE_ITEM_KEY, BAD_REQUEST );
		SaleItem item = salesItemDao.getByItemKey( itemKey );
		if( item == null ) {
			throw new PointOfSaleException( 
					NOT_FOUND, SALES_ITEM_NOT_FOUND_TITLE, 
					String.format( SALES_ITEM_NOT_FOUND_BY_ITEM_KEY, itemKey ) );
		}
		return item;
	}
	
	@Override
	public List<SaleItem> getByInventoryLessThan( Integer inventoryLessThan) {
		return salesItemDao.getByInventoryLessThan( new Float( inventoryLessThan.floatValue() ) );
	}
	
    @Override
    public SaleItem save( SalesItemCreateDTO itemDTO ) {
    	
    	SalesItemsServiceImpl.checkEmptyValues( itemDTO );

    	if( salesItemDao.getByItemKey( itemDTO.getItemKey() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_ITEM_KEY , itemDTO.getItemKey() ) );
    	}

    	if( salesItemDao.getByItemName( itemDTO.getItemName() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_ITEM_NAME , itemDTO.getItemName() ) );
    	}

    	if( salesItemDao.getByCodeBars( itemDTO.getCodeBars() ) != null ){
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_BY_CODE_BARS , itemDTO.getCodeBars() ) );
    	}
    	
    	//Generate Inventory equals to Zero in every branch
    	SaleItem itemToPersist = new SaleItem( itemDTO );
    	
    	validateDepartment( itemDTO, itemToPersist );
    	validateProvider( itemDTO, itemToPersist );

    	List<Branch> branchesList = branchDao.getAll();
    	for( Branch branch : branchesList ){
    		Inventory inv = new Inventory();
    		inv.setBranch( branch );
    		inv.setInventory( 0.0F );
    		inv.setSaleItem( itemToPersist );
    		itemToPersist.getInventory().add( inv );
    	}
    	
    	salesItemDao.save( itemToPersist );
    	return itemToPersist;
    	
    }
    
    @Override
    public SaleItem update( SalesItemUpdateDTO itemDTO ) {
    	
    	SalesItemsServiceImpl.checkEmptyValues( itemDTO );
    	validateEmptyValue( itemDTO.getIdItem(), EMPTY_REQUIRED_FIELD, SALES_ITEM_EMPTY_VALUE_ITEM_ID, BAD_REQUEST );
    	
    	//TODO Need to modify getDifferent Query
    	//this is working for Happy Path as of now
    	List<SaleItem> saleItems = 
    			salesItemDao.getDifferent( 
    					itemDTO.getItemName(), 
    					itemDTO.getCodeBars() );
    	
    	if( ! CollectionUtils.isEmpty( saleItems ) ) {
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_ALREADY_EXISTS_TITLE, 
    				String.format( SALES_ITEM_ALREADY_EXISTS_DIFFERENT, 
    									itemDTO.getItemName(), 
    									itemDTO.getCodeBars() ) ) ;
    	}
    	
    	SaleItem itemToUpdate = salesItemDao.getById( itemDTO.getIdItem() );
    	
    	if( itemToUpdate == null ) {
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_NOT_FOUND_BY_ITEM_KEY, 
    				String.format( SALES_ITEM_NOT_FOUND_BY_ITEM_KEY , itemDTO.getItemKey() ) );
    	}

    	validateDepartment( itemDTO, itemToUpdate );
    	validateProvider( itemDTO, itemToUpdate );

    	itemToUpdate.setItemKey(     itemDTO.getItemKey()   );
    	itemToUpdate.setItemName(    itemDTO.getItemName()  );
    	itemToUpdate.setBrand(       itemDTO.getBrand()     );
    	itemToUpdate.setCodeBars(    itemDTO.getCodeBars()  );
    	itemToUpdate.setSalePrice(   itemDTO.getSalePrice() );
    	
    	salesItemDao.update( itemToUpdate );
    	return itemToUpdate;
    }


    private static void checkEmptyValues( SalesItemCreateDTO saleItemDto ){
    	
    	validateEmptyValue( 
    			saleItemDto.getItemKey(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_KEY, 
    			BAD_REQUEST);
    	
    	validateEmptyValue( 
    			saleItemDto.getItemName(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_NAME,
    			BAD_REQUEST);
    	
    	validateEmptyValue( 
    			saleItemDto.getCodeBars(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_CODE_BARS,
    			BAD_REQUEST);
    	
    	validateEmptyValue( 
    			saleItemDto.getIdDepartment(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_DEPARTMENT_ID,
    			BAD_REQUEST);
    	
    	validateEmptyValue( 
    			saleItemDto.getIdProvider(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_PROVIDER_ID,
    			BAD_REQUEST);
    	
    	validateEmptyValue( 
    			saleItemDto.getBrand(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_VALUE_ITEM_BRAND,
    			BAD_REQUEST);

    	validateEmptyValue( 
    			saleItemDto.getSalePrice(), 
    			EMPTY_REQUIRED_FIELD, 
    			SALES_ITEM_EMPTY_NUMERIC_VALUE_ITEM_SALE_PRICE,
    			BAD_REQUEST);


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

    private void validateDepartment( SalesItemCreateDTO itemDTO, SaleItem saleItem ) {
    	Department dep = departmentDao.getById( itemDTO.getIdDepartment() );
    	if( dep == null ) {
    		throw new PointOfSaleException( 
    				NOT_FOUND, 
    				DEPARTMENT_NOT_FOUND_TITLE, 
    				String.format( DEPARTMENT_NOT_FOUND_BY_ID_DESCRIPTON, itemDTO.getIdDepartment() ) ) ;
    	}
    	saleItem.setDepartment( dep );
    }
    
    private void validateProvider( SalesItemCreateDTO itemDTO, SaleItem saleItem ) {
    	Provider prov = providerDao.getById( itemDTO.getIdProvider() );
    	if( prov == null ) {
    		throw new PointOfSaleException( 
    				NOT_FOUND, 
    				PROVIDER_NOT_FOUND_TITLE, 
    				String.format( PROVIDER_NOT_FOUND_BY_ID_DESCRIPTON, itemDTO.getIdProvider() ) ) ;
    		
    	}
    	saleItem.setProvider( prov );
    }
    
    @Override
    public void saveAll( List<SalesItemCreateDTO> salesItems ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SaleItem delete( Long idItem ) {
    	
    	validateEmptyValue( idItem, EMPTY_REQUIRED_FIELD, SALES_ITEM_EMPTY_VALUE_ITEM_ID, BAD_REQUEST );
    	SaleItem itemToDelete = salesItemDao.getById( idItem );
    	
    	if( itemToDelete == null ) {
    		throw new PointOfSaleException( 
    				CONFLICT, 
    				SALES_ITEM_NOT_FOUND_TITLE, 
    				String.format( SALES_ITEM_NOT_FOUND_BY_ID_DESCRIPTON, idItem ) );
    	}
    	
    	salesItemDao.delete( itemToDelete );
    	return itemToDelete;
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