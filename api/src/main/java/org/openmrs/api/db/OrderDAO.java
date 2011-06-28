/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.api.db;

import java.util.Date;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Order;
import org.openmrs.OrderGroup;
import org.openmrs.OrderSet;
import org.openmrs.Patient;
import org.openmrs.PublishedOrderSet;
import org.openmrs.User;
import org.openmrs.api.OrderService;
import org.openmrs.api.OrderService.ORDER_STATUS;

/**
 * Order-related database functions
 * <p>
 * This class should never be used directly. It should only be used through the
 * {@link org.openmrs.api.OrderService}
 * 
 * @see org.openmrs.api.OrderService
 */
public interface OrderDAO {
	
	// methods for the Order java pojo object
	
	/**
	 * @see org.openmrs.api.OrderService#saveOrder(Order)
	 */
	public Order saveOrder(Order order) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#purgeOrder(Order)
	 */
	public void deleteOrder(Order order) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#getOrder(Integer, Class)
	 * @see org.openmrs.api.OrderService#getOrder(Integer)
	 * @see org.openmrs.api.OrderService#getDrugOrder(Integer)
	 */
	public <Ord extends Order> Ord getOrder(Integer orderId, Class<Ord> classType) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#getOrders(Class, List, List, ORDER_STATUS, List, List)
	 */
	public <Ord extends Order> List<Ord> getOrders(Class<Ord> orderClassType, List<Patient> patients,
	        List<Concept> concepts, ORDER_STATUS status, List<User> orderers, List<Encounter> encounters, Date asOfDate);
	
	/**
	 * Auto generated method comment
	 * 
	 * @param uuid
	 * @return
	 */
	public Order getOrderByUuid(String uuid);
	
	/**
	 * @see org.openmrs.api.OrderService#getOrderByOrderNumber(java.lang.String)
	 */
	public Order getOrderByOrderNumber(String orderNumber);
	
	/**
	 * Gets the biggest order id used so far.
	 * 
	 * @return the biggest order id used for far or 0 if not a single order exists.
	 */
	public Integer getMaximumOrderId();
	
	/**
	 * @see org.openmrs.api.OrderService#saveOrderGroup(OrderGroup)
	 */
	public OrderGroup saveOrderGroup(OrderGroup orderGroup) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#getOrderGroup(Integer)
	 */
	public OrderGroup getOrderGroup(Integer orderGroupId) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#getOrderGroupByUuid(String)
	 */
	public OrderGroup getOrderGroupByUuid(String uuid) throws DAOException;
	
	/**
	 * @see org.openmrs.api.OrderService#getOrderGroupsByPatient(Patient)
	 */
	public List<OrderGroup> getOrderGroupsByPatient(Patient patient) throws DAOException;
	
	/**
	 * Determines whether the given order is marked as 'activated' in the database (ignoring caches)
	 * 
	 * @param order
	 * @return
	 */
	public boolean isActivatedInDatabase(Order order);
	
	/**
	 * @see OrderService#getOrderSet(Integer)
	 */
	public OrderSet getOrderSet(Integer orderSetId);
	
	/**
	 * @see OrderService#getOrderSetByUuid(String)
	 */
	public OrderSet getOrderSetByUuid(String uuid);
	
	/**
	 * @see OrderService#saveOrderSet(OrderSet)
	 */
	public OrderSet saveOrderSet(OrderSet orderSet);
	
	/**
	 * @see OrderService#publishOrderSet(Concept, OrderSet)
	 */
	public PublishedOrderSet publishOrderSet(Concept asConcept, OrderSet content);
	
	/**
	 * @see OrderService#getPublishedOrderSet(Concept)
	 */
	public PublishedOrderSet getPublishedOrderSet(Concept concept);
	
	/**
	 * @see OrderService#getPublishedOrderSets(String)
	 */
	public List<PublishedOrderSet> getPublishedOrderSets(String query);
	
	/**
	 * Determine the order number of this order as saved in the database (ignoring caches)

	 * @param order
	 * @return
	 */
	public String getOrderNumberInDatabase(Order order);
	
}
