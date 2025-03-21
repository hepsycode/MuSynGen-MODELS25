/**
 * Copyright (c) 2011-2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 */
package org.obeonetwork.bpmn2.design;

import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.helper.graphicalfilters.HideFilterHelper;
import org.obeonetwork.dsl.bpmn2.BoundaryEvent;
import org.obeonetwork.dsl.bpmn2.FlowNode;
import org.obeonetwork.dsl.bpmn2.Lane;
import org.obeonetwork.dsl.bpmn2.MessageFlow;
import org.obeonetwork.dsl.bpmn2.Participant;
import org.obeonetwork.dsl.bpmn2.Process;

/**
 * @author vrichard
 * 
 *         <p>
 *         Services to be applied to a DDiagramElementContainer and relative to
 *         the expand/collapse state of the DDiagramElementContainer.
 *         </p>
 * 
 *         <p>
 *         Expand/collapse operations are done revealing/hiding elements
 *         contained in the DDiagramElementContainer.
 *         </p>
 * 
 *         <p>
 *         A DDiagramElementContainer is considered collapsed if if at least one
 *         of its child is hidden.
 *         </p>
 */
public class ExpandCollapseService {

	private static final String IS_COLLAPSED_ANNOTATION = "IsCollapsed";

	public EObject getSourceRef(DSemanticDiagram diagram, MessageFlow messageFlow) {
		EObject result = getElement(diagram, messageFlow.getSourceRef());
		return result;
	}

	public EObject getTargetRef(DSemanticDiagram diagram, MessageFlow messageFlow) {
		EObject result = getElement(diagram, messageFlow.getTargetRef());
		return result;
	}

	public EObject getElement(DSemanticDiagram diagram, EObject result) {
		if (result instanceof Participant) {
			return result;
		}
		if (result instanceof FlowNode) {
			Process process = ServiceHelper.getProcess(result);
			if (process == null) {
				return null;
			}
			ECrossReferenceAdapter eCrossReferenceAdapter = ServiceHelper.getCrossReferenceAdapter(process);
			// first check if there is an adapter (RCP case)
			if (eCrossReferenceAdapter != null) {
				Collection<Setting> inverseReferences = eCrossReferenceAdapter.getInverseReferences(process);
				for (Setting setting : inverseReferences) {
					EObject object = setting.getEObject();
					if (object instanceof Participant) {
						Lane lane = getLane((FlowNode) result);
						if (lane != null) {
							DDiagramElementContainer laneView = null;
							for (DDiagramElementContainer d : diagram.getContainers()) {
								if (d.getTarget().equals(lane)) {
									laneView = d;
								}
							}
							if (laneView == null || laneView.getGraphicalFilters() == null
									|| laneView.getGraphicalFilters().size() == 0) {
								return result;
							}
							return object;
						}
					}
				}
			}

		}
		return result;
	}

	private Lane getLane(FlowNode flowNode) {
		Lane result = null;
		if (flowNode != null) {
			if (flowNode.getLanes() != null && !flowNode.getLanes().isEmpty() && flowNode.getLanes().get(0) != null) {
				result = flowNode.getLanes().get(0);
			} else if (flowNode.eContainer() instanceof FlowNode) {
				result = getLane((FlowNode) flowNode.eContainer());
			}
		}
		return result;

	}

	/**
	 * Toggle the expand/collapse state of the given DDiagramElementContainer.
	 * 
	 * @param elementContainer
	 * @return elementContainer
	 */
	public DDiagramElementContainer toggleCollapse(final DDiagramElementContainer elementContainer) {

		if (isCollapsed(elementContainer)) {
			unsetCollapsed(elementContainer);
			expand(elementContainer);
		} else {
			setCollapsed(elementContainer);
			collapse(elementContainer);
		}

		return elementContainer;
	}

	/**
	 * Hide all the direct child of the given DDiagramElementContainer and force a
	 * refresh of the parent diagram.
	 * 
	 * @param elementContainer
	 * @return elementContainer
	 */
	public static DDiagramElementContainer collapse(final DDiagramElementContainer elementContainer) {
		for (DDiagramElement child : elementContainer.getElements()) {
			if ((child.eContainer() == elementContainer) && !(child.getTarget() instanceof BoundaryEvent)) {
				HideFilterHelper.INSTANCE.hide(child);
			}
		}

		// Do a refresh programmatically to update the representation. The
		// "force" option of the tool in the odesign doesn't work in this case
		// as the modification is not semantic.
		DialectManager.INSTANCE.refresh(elementContainer.getParentDiagram(), new NullProgressMonitor());

		return elementContainer;
	}

	/**
	 * Reveal all the direct child of the given DDiagramElementContainer and force a
	 * refresh of the parent diagram.
	 * 
	 * @param elementContainer
	 * @return elementContainer
	 */
	public static DDiagramElementContainer expand(final DDiagramElementContainer elementContainer) {
		for (DDiagramElement child : elementContainer.getElements()) {
			if (child.eContainer() == elementContainer) {
				HideFilterHelper.INSTANCE.reveal(child);
			}
		}

		// Do a refresh programmatically to update the representation. The
		// "force" option of the tool in the odesign doesn't work in this case
		// as the modification is not semantic.
		DialectManager.INSTANCE.refresh(elementContainer.getParentDiagram(), new NullProgressMonitor());

		return elementContainer;
	}

	public static boolean isCollapsed(DDiagramElementContainer elementContainer) {
		return elementContainer.getOwnedStyle().getCustomFeatures().contains(IS_COLLAPSED_ANNOTATION);
	}

	public static boolean isNotCollapsed(DDiagramElementContainer elementContainer) {
		return !isCollapsed(elementContainer);
	}

	public static void setCollapsed(DDiagramElementContainer elementContainer) {
		elementContainer.getStyle().getCustomFeatures().add(IS_COLLAPSED_ANNOTATION);
	}

	public static void unsetCollapsed(DDiagramElementContainer elementContainer) {
		elementContainer.getStyle().getCustomFeatures().remove(IS_COLLAPSED_ANNOTATION);
	}

}
