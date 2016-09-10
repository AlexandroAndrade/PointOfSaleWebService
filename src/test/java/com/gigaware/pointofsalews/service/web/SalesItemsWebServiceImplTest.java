/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.createStrictMock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.ietf.jgss.Oid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateDTO;
import com.gigaware.pointofsalews.dto.create.SalesItemUpdateDTO;
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
	private SalesItemsService itemsService = createStrictMock( SalesItemsServiceImpl.class );

	@Before
	public void setUp(){
		webService.setSalesItemsService( itemsService );
	}
	
	@Test
	public void testGetAllSalesItems(){
		expect( itemsService.getAll() ).andReturn( createSalesItemList() ).once();
		replay( itemsService );
		
		SalesItemWrapper response = webService.getAllSalesItems();
		
		assertNotNull( response );
		assertTrue( response.getSalesItems().size() == 3 );
		verify( itemsService );
		
	}
	
	@Test
	public void testGetItemById(){
		expect( itemsService.getById( anyLong() ) ).andReturn(createItem( 10L )).once();
		replay( itemsService );
		
		SalesItemDto response = webService.getItemById( 10L );
		assertNotNull( response );
		assertEquals( response.getIdSalesItem().longValue() , 10L );
		verify( itemsService );
		
	}
	
	@Test
	public void testGetItemByItemKey() {
		expect( itemsService.getByItemKey( anyObject( String.class ) ) ).andReturn( createItem( 1L ) ).once();
		replay( itemsService );
		assertNotNull( webService.getItemByItemKey( "key_01" ) );
		verify( itemsService );
	}
	
	@Test
	public void testGetByInventoryLessThan() {
		expect( itemsService.getByInventoryLessThan( anyInt() ) ).andReturn( createSalesItemList() ).once();
		replay( itemsService );
		assertNotNull( webService.getByInventoryLessThan( 100 ) );
		verify( itemsService );
	}
	
	@Test
	public void testSaveItem(){
		
		SaleItem saleItem = new SaleItem();
		saleItem.setProvider( createProvider( "providerName_01" ) );
		saleItem.setDepartment( createDepartment( "departmentName_01" ) );
		expect( itemsService.save( anyObject( SalesItemCreateDTO.class ) ) ).andReturn( saleItem ).once();
		replay( itemsService );
		assertNotNull( 
				webService.saveItem( 
						createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", 
								"codeBars_01", 10.0F, 1L, 1L) ) ) ;
		verify( itemsService );

	}
	
	@Test
	public void testUpdateItem() {
		expect( itemsService.update( anyObject( SalesItemUpdateDTO.class ) ) ).andReturn( createItem( 1L ) ).once();
		replay( itemsService );
		assertNotNull( webService.updateItem( createSaleItemUpdateDto( 1L, "itemKey_01", "itemName_01", "brand_01", 
				"codeBars_01", 10.0F, 1L, 1L ) ) );
		verify( itemsService );
	}
	
	@Test
	public void testDeleteItem() {
		expect( itemsService.delete( anyLong() ) ).andReturn( createItem( 1L ) ).once();
		replay( itemsService );
		
		assertNotNull( webService.deleteItem( 1L ) );
		verify( itemsService );
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
	
	private SalesItemCreateDTO createSaleItemDto( 
			String itemKey, 
			String itemName, 
			String brand, 
			String codeBars, 
			Float salePrice,
			Long idDepartment,
			Long idProvider){
		
		SalesItemCreateDTO dto = new SalesItemCreateDTO();
		dto.setItemKey( itemKey );
		dto.setItemName( itemName );
		dto.setBrand( brand );
		dto.setCodeBars( codeBars );
		dto.setSalePrice( salePrice );
		dto.setIdDepartment( idDepartment );
		dto.setIdProvider( idProvider );
		return dto;
	}
	
	private SalesItemUpdateDTO createSaleItemUpdateDto(
			Long idItem,
			String itemKey, 
			String itemName, 
			String brand, 
			String codeBars, 
			Float salePrice,
			Long idDepartment,
			Long idProvider){
		
		SalesItemUpdateDTO dto = new SalesItemUpdateDTO();
		dto.setIdItem( idItem );
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
