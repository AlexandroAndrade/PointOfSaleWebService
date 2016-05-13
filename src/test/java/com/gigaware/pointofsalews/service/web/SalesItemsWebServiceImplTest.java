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

import com.gigaware.pointofsalews.dto.SalesItemDto;
import com.gigaware.pointofsalews.entity.Branch;
import com.gigaware.pointofsalews.entity.Category;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SalesItem;
import com.gigaware.pointofsalews.service.SalesItemsService;
import com.gigaware.pointofsalews.service.SalesItemsServiceImpl;
import com.gigaware.pointofsalews.wrapper.SalesItemWrapper;

/**
 * Unit Test Class for SalesItemsWebServiceImpl
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
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
	
	private List<SalesItem> createSalesItemList(){
		List<SalesItem> l = new ArrayList<>();
		l.add( createItem( 1L ) );
		l.add( createItem( 2L ) );
		l.add( createItem( 3L ) );
		
		return l;
	}
	
	private SalesItem createItem( Long idItem ){
		SalesItem item = new SalesItem();
		item.setIdItem( idItem );
		item.setBranch( createBranch( "Branch_01" ) );
		item.setProvider( createProvider( "Provider_01" ) );
		item.setCategory( createCategory( "Category_01" ) );
		return item;
	}
	
	private Branch createBranch( String branchName){
		Branch b = new Branch();
		b.setBranchName( branchName );
		return b;
	}
	
	private Provider createProvider( String businessName ){
		Provider p = new Provider();
		p.setBusinessName( businessName );
		return p;
	}
	
	private Category createCategory( String categoryName ){
		Category c = new Category();
		c.setCategoryName( categoryName );
		return c;
	}
	
}