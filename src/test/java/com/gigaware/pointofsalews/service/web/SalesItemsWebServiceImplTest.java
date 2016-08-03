/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateAndModifyDTO;
import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SaleItem;
import com.gigaware.pointofsalews.service.SalesItemsService;
import com.gigaware.pointofsalews.service.SalesItemsServiceImpl;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;

/**
 * Unit Test Class for SalesItemsWebServiceImpl
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@RunWith( JUnit4.class )
public class SalesItemsWebServiceImplTest {

	private SalesItemsWebServiceImpl webService = new SalesItemsWebServiceImpl();
	private SalesItemsService itemsService = EasyMock.createStrictMock( SalesItemsServiceImpl.class );

	@Before
	public void setUp(){
		webService.setSalesItemsService( itemsService );
	}
	
	@Test
	public void testGetAllSalesItems(){
		EasyMock.expect( itemsService.getAll() ).andReturn( createSalesItemList() ).once();
		EasyMock.replay( itemsService );
		
		SalesItemWrapper response = webService.getAllSalesItems();
		
		Assert.assertNotNull( response );
		Assert.assertTrue( response.getSalesItems().size() == 3 );
		EasyMock.verify( itemsService );
		
	}
	
	@Test
	public void testGetItemById(){
		EasyMock.expect( itemsService.getById( EasyMock.anyLong() ) ).andReturn(createItem( 10L )).once();
		EasyMock.replay( itemsService );
		
		SalesItemDto response = webService.getItemById( 10L );
		Assert.assertNotNull( response );
		Assert.assertEquals( response.getIdSalesItem().longValue() , 10L );
		EasyMock.verify( itemsService );
		
	}
	
	@Test
	public void testSaveItem(){
		
		SaleItem saleItem = new SaleItem();
		saleItem.setProvider( createProvider( "providerName_01" ) );
		saleItem.setDepartment( createDepartment( "departmentName_01" ) );
		EasyMock.expect( itemsService.save( EasyMock.anyObject( SalesItemCreateAndModifyDTO.class ) ) ).andReturn( saleItem ).once();
		EasyMock.replay( itemsService );
		Assert.assertNotNull( 
				webService.saveItem( 
						createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", 
								"codeBars_01", 10.0F, 1L, 1L) ) ) ;
		EasyMock.verify( itemsService );

	}
	
	private List<SaleItem> createSalesItemList(){
		List<SaleItem> l = new ArrayList<>();
		l.add( createItem( 1L ) );
		l.add( createItem( 2L ) );
		l.add( createItem( 3L ) );
		
		return l;
	}
	
	private SaleItem createItem( Long idItem ){
		SaleItem item = new SaleItem();
		item.setIdItem( idItem );
		item.setProvider( createProvider( "Provider_01" ) );
		item.setDepartment( createDepartment( "Department_01" ) );
		return item;
	}
	
	private Provider createProvider( String businessName ){
		Provider p = new Provider();
		p.setBusinessName( businessName );
		return p;
	}
	
	private Department createDepartment( String departmentName ){
		Department d = new Department();
		d.setDepartmentName( departmentName );
		return d;
	}
	
	private SalesItemCreateAndModifyDTO createSaleItemDto( 
			String itemKey, 
			String itemName, 
			String brand, 
			String codeBars, 
			Float salePrice,
			Long idDepartment,
			Long idProvider){
		
		SalesItemCreateAndModifyDTO dto = new SalesItemCreateAndModifyDTO();
		dto.setItemKey( itemKey );
		dto.setItemName( itemName );
		dto.setBrand( brand );
		dto.setCodeBars( codeBars );
		dto.setSalePrice( salePrice );
		dto.setIdDepartment( idDepartment );
		dto.setIdProvider( idProvider );
		return dto;
	}
	
}