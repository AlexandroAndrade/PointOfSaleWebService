/**
 * Copyright (c) 2016, Gigaware Solutions.
 */
package com.gigaware.pointofsalews.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyLong;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.gigaware.pointofsalews.dao.BranchDao;
import com.gigaware.pointofsalews.dao.BranchDaoImpl;
import com.gigaware.pointofsalews.dao.DepartmentDao;
import com.gigaware.pointofsalews.dao.DepartmentDaoImpl;
import com.gigaware.pointofsalews.dao.ProviderDao;
import com.gigaware.pointofsalews.dao.ProviderDaoImpl;
import com.gigaware.pointofsalews.dao.SalesItemDao;
import com.gigaware.pointofsalews.dao.SalesItemDaoImpl;
import com.gigaware.pointofsalews.dto.create.SalesItemCreateAndModifyDTO;
import com.gigaware.pointofsalews.entity.Branch;
import com.gigaware.pointofsalews.entity.Department;
import com.gigaware.pointofsalews.entity.Inventory;
import com.gigaware.pointofsalews.entity.Provider;
import com.gigaware.pointofsalews.entity.SaleItem;
import com.gigaware.pointofsalews.exception.PointOfSaleException;

/**
 * Unit Test Class for {@link SalesItemsServiceImpl}
 * @author Alex Andrade ( yngwie_alex@hotmail.com )
 */
@RunWith( JUnit4.class )
public class SalesItemsServiceImplTest {
	
	private SalesItemsServiceImpl service;
	private SalesItemDao salesItemDao;
	private BranchDao branchDao;
	private DepartmentDao departmentDao;
	private ProviderDao providerDao;
	
	
	@Before
	public void setUp() {
		service = new SalesItemsServiceImpl();

		salesItemDao = createStrictMock( SalesItemDaoImpl.class );
		service.setSalesItemDao( salesItemDao );
		
		branchDao = createStrictMock( BranchDaoImpl.class );
		service.setBranchDao( branchDao );
		
		departmentDao = createStrictMock( DepartmentDaoImpl.class );
		service.setDepartmentDao( departmentDao );
		
		providerDao = createStrictMock( ProviderDaoImpl.class );
		service.setProviderDao( providerDao );
	}
	
	@After
	public void tearDown(){
		service = null;
		salesItemDao = null;
		branchDao = null;
		departmentDao = null;
		providerDao = null;
	}
	
	@Test
	public void testGetAll(){
		expect( salesItemDao.getAll() ).andReturn( new ArrayList<SaleItem>() ).once();
		replay( salesItemDao );
		Assert.assertNotNull( service.getAll() );
		verify( salesItemDao );
	}
	
	@Test
	public void testGetById(){
		expect( salesItemDao.getById( EasyMock.anyLong() ) ).andReturn( new SaleItem() ).once();
		replay( salesItemDao );
		assertNotNull( service.getById( 1L ) );
		verify( salesItemDao );
	}
	
	@Test( expected = PointOfSaleException.class )
	public void testGetById_NullItem(){
		expect( salesItemDao.getById( EasyMock.anyLong() ) ).andReturn( null ).once();
		replay( salesItemDao );
		assertNotNull( service.getById( 1L ) );
		verify( salesItemDao );
	}
	
	@Test 
	public void testSave_HappyPath(){
		expect( salesItemDao.getByItemKey ( anyObject( String.class ) ) ).andReturn( null ).once();
		expect( salesItemDao.getByItemName( anyObject( String.class ) ) ).andReturn( null ).once();
		expect( salesItemDao.getByCodeBars( anyObject( String.class ) ) ).andReturn( null ).once();
		
		expect( departmentDao.getById( anyLong() ) ).andReturn( new Department() ).once();
		expect( providerDao.getById( anyLong() ) ).andReturn( new Provider() ).once();
		expect( branchDao.getAll() ).andReturn( createBranches()  ).once();
		salesItemDao.save( anyObject( SaleItem.class ) );
		
		replay( salesItemDao, departmentDao, providerDao, branchDao );
		
		SaleItem saleItem = service.save( 
				createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 10.0F, 1L, 1L) );
		assertNotNull( saleItem );
		assertTrue( saleItem.getInventory().size() == 3 );
		for( Inventory inv : saleItem.getInventory() ){
			assertTrue( inv.getInventory().floatValue() == 0.0F );
		}
		verify( salesItemDao, departmentDao, providerDao, branchDao );
	}

	@Test(expected = PointOfSaleException.class )
	public void testSave_DuplicatedByItemKey(){
		expect( salesItemDao.getByItemKey ( anyObject( String.class ) ) ).andReturn( new SaleItem() ).once();
		replay( salesItemDao );
		SaleItem saleItem = service.save( 
				createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 10.0F, 1L, 1L) );
		verify( salesItemDao );
	}

	@Test(expected = PointOfSaleException.class )
	public void testSave_DuplicatedByItemName(){
		expect( salesItemDao.getByItemKey ( anyObject( String.class ) ) ).andReturn( null ).once();
		expect( salesItemDao.getByItemName( anyObject( String.class ) ) ).andReturn( new SaleItem() ).once();
		replay( salesItemDao );
		SaleItem saleItem = service.save( 
				createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 10.0F, 1L, 1L) );
		verify( salesItemDao );
	}
	
	@Test(expected = PointOfSaleException.class )
	public void testSave_DuplicatedByCodeBars(){
		expect( salesItemDao.getByItemKey ( anyObject( String.class ) ) ).andReturn( null ).once();
		expect( salesItemDao.getByItemName( anyObject( String.class ) ) ).andReturn( null ).once();
		expect( salesItemDao.getByCodeBars( anyObject( String.class ) ) ).andReturn( new SaleItem() ).once();
		replay( salesItemDao );
		SaleItem saleItem = service.save( 
				createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 10.0F, 1L, 1L) );
		verify( salesItemDao );
	}

	@Test( expected = PointOfSaleException.class )
	public void testSave_EmptyStringValue() {
		service.save( createSaleItemDto( "", "itemName_01", "brand_01", "codeBars_01", 10.0F, 1L, 1L) );
	}
	
	@Test( expected = PointOfSaleException.class )
	public void testSave_InvalidLongValue() {
		service.save( createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 10.0F, 0L, 1L) );
	}

	@Test( expected = PointOfSaleException.class )
	public void testSave_InvalidFloatValue() {
		service.save( createSaleItemDto( "itemKey_01", "itemName_01", "brand_01", "codeBars_01", 0.0F, 1L, 1L) );
	}
	
	@Test( expected = UnsupportedOperationException.class )
	public void testSaveAll(){
		service.saveAll( new ArrayList<SalesItemCreateAndModifyDTO>() );
	}

	@Test( expected = UnsupportedOperationException.class )
	public void testUpdate(){
		service.update( new SaleItem() );
	}

	@Test( expected = UnsupportedOperationException.class )
	public void testDelete(){
		service.delete( new SaleItem() );
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
	
	private List<Branch> createBranches(){
		List<Branch> l = new ArrayList<>();
		l.add( createBranch( "BranchName_01" ) );
		l.add( createBranch( "BranchName_02" ) );
		l.add( createBranch( "BranchName_03" ) );
		return l;
	}
	
	private Branch createBranch( String branchName ){
		Branch b = new Branch();
		b.setBranchName( branchName );
		return b;
	}

	
}













