/**
 * <copyright>
 * 
 * Copyright (c) 2011-2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 * </copyright>
 */
package org.obeonetwork.dsl.bpmn2.impl;

import org.eclipse.emf.ecore.EClass;
import org.obeonetwork.dsl.bpmn2.Bpmn2Package;
import org.obeonetwork.dsl.bpmn2.EventBasedGateway;
import org.obeonetwork.dsl.bpmn2.EventBasedGatewayType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Based Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.bpmn2.impl.EventBasedGatewayImpl#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.bpmn2.impl.EventBasedGatewayImpl#getEventGatewayType <em>Event Gateway Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventBasedGatewayImpl extends GatewayImpl implements EventBasedGateway {
	/**
	 * The default value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIATE_EDEFAULT = false;
	/**
	 * The default value of the '{@link #getEventGatewayType() <em>Event Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventGatewayType()
	 * @generated
	 * @ordered
	 */
	protected static final EventBasedGatewayType EVENT_GATEWAY_TYPE_EDEFAULT = EventBasedGatewayType.PARALLEL;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBasedGatewayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.EVENT_BASED_GATEWAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiate() {
		return (Boolean) eDynamicGet(Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE,
				Bpmn2Package.Literals.EVENT_BASED_GATEWAY__INSTANTIATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiate(boolean newInstantiate) {
		eDynamicSet(Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE,
				Bpmn2Package.Literals.EVENT_BASED_GATEWAY__INSTANTIATE, newInstantiate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBasedGatewayType getEventGatewayType() {
		return (EventBasedGatewayType) eDynamicGet(Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE,
				Bpmn2Package.Literals.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventGatewayType(EventBasedGatewayType newEventGatewayType) {
		eDynamicSet(Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE,
				Bpmn2Package.Literals.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE, newEventGatewayType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
			return isInstantiate();
		case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
			return getEventGatewayType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
			setInstantiate((Boolean) newValue);
			return;
		case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
			setEventGatewayType((EventBasedGatewayType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
			setInstantiate(INSTANTIATE_EDEFAULT);
			return;
		case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
			setEventGatewayType(EVENT_GATEWAY_TYPE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
			return isInstantiate() != INSTANTIATE_EDEFAULT;
		case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
			return getEventGatewayType() != EVENT_GATEWAY_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //EventBasedGatewayImpl
