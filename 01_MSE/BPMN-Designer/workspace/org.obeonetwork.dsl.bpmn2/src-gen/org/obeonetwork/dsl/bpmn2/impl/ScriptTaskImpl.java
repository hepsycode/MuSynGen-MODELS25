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
import org.obeonetwork.dsl.bpmn2.ScriptTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.bpmn2.impl.ScriptTaskImpl#getScriptFormat <em>Script Format</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.bpmn2.impl.ScriptTaskImpl#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScriptTaskImpl extends TaskImpl implements ScriptTask {
	/**
	 * The default value of the '{@link #getScriptFormat() <em>Script Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_FORMAT_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.SCRIPT_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptFormat() {
		return (String) eDynamicGet(Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT,
				Bpmn2Package.Literals.SCRIPT_TASK__SCRIPT_FORMAT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptFormat(String newScriptFormat) {
		eDynamicSet(Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT, Bpmn2Package.Literals.SCRIPT_TASK__SCRIPT_FORMAT,
				newScriptFormat);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScript() {
		return (String) eDynamicGet(Bpmn2Package.SCRIPT_TASK__SCRIPT, Bpmn2Package.Literals.SCRIPT_TASK__SCRIPT, true,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScript(String newScript) {
		eDynamicSet(Bpmn2Package.SCRIPT_TASK__SCRIPT, Bpmn2Package.Literals.SCRIPT_TASK__SCRIPT, newScript);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT:
			return getScriptFormat();
		case Bpmn2Package.SCRIPT_TASK__SCRIPT:
			return getScript();
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
		case Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT:
			setScriptFormat((String) newValue);
			return;
		case Bpmn2Package.SCRIPT_TASK__SCRIPT:
			setScript((String) newValue);
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
		case Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT:
			setScriptFormat(SCRIPT_FORMAT_EDEFAULT);
			return;
		case Bpmn2Package.SCRIPT_TASK__SCRIPT:
			setScript(SCRIPT_EDEFAULT);
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
		case Bpmn2Package.SCRIPT_TASK__SCRIPT_FORMAT:
			return SCRIPT_FORMAT_EDEFAULT == null ? getScriptFormat() != null
					: !SCRIPT_FORMAT_EDEFAULT.equals(getScriptFormat());
		case Bpmn2Package.SCRIPT_TASK__SCRIPT:
			return SCRIPT_EDEFAULT == null ? getScript() != null : !SCRIPT_EDEFAULT.equals(getScript());
		}
		return super.eIsSet(featureID);
	}

} //ScriptTaskImpl
