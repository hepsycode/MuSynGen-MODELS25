/*
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import py4j.GatewayServer;
import java.io.IOException;
//import java.util.Map;

public class EMFValidator {

    public EMFValidator() {
        // Ensure BPMN plugins and Sirius Ecore models are loaded
        registerEcoreModels();
    }

    private void registerEcoreModels() {
        // Register XMI and Ecore formats
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

        // Dynamically Load BPMN2 Ecore Metamodel from Workspace
        try {
            ResourceSet resourceSet = new ResourceSetImpl();
            
            // 🔹 Change this path to match your BPMN2 Ecore file inside the Eclipse workspace
            String workspacePath = "C:/Users/vitto/Desktop/eclipse-modeling-2019-06-R-win32-x86_64/eclipse-modeling-2024-12-R-win32-x86_64/eclipse/workspace/org.obeonetwork.dsl.bpmn2/model/BPMN20.ecore";
            
            URI bpmnEcoreURI = URI.createFileURI(workspacePath);

            Resource bpmnMetamodel = resourceSet.getResource(bpmnEcoreURI, true);
            bpmnMetamodel.load(null);

            for (EObject eObject : bpmnMetamodel.getContents()) {
                if (eObject instanceof EPackage) {
                    EPackage ePackage = (EPackage) eObject;
                    EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
                    System.out.println("BPMN2 Metamodel Registered: " + ePackage.getNsURI());
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load BPMN2 Ecore: " + e.getMessage());
        }

        // Load all registered metamodels in Sirius/Eclipse runtime
        for (Object obj : EPackage.Registry.INSTANCE.values()) {
            if (obj instanceof EPackage) { // Ensure it's an EPackage before casting
                EPackage ePackage = (EPackage) obj;
                ePackage.eClass(); // Force loading of Ecore packages
                System.out.println("Registered Metamodel: " + ePackage.getNsURI());
            }
        }
    }

    public String validateModel(String modelPath) {
        try {
            ResourceSet resourceSet = new ResourceSetImpl();

            // Load the BPMN model
            Resource modelResource = resourceSet.getResource(URI.createFileURI(modelPath), true);
            modelResource.load(null);

            EObject model = modelResource.getContents().get(0);

            // Validate the model using Sirius Runtime
            Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);
            if (diagnostic.getSeverity() == Diagnostic.OK) {
                return "Validation successful: No errors found.";
            } else {
                return "Validation errors found:\n" + printDiagnostic(diagnostic, "");
            }
        } catch (Exception e) {
            return "Validation error: " + e.getMessage();
        }
    }

    private String printDiagnostic(Diagnostic diagnostic, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(diagnostic.getMessage()).append("\n");
        for (Diagnostic child : diagnostic.getChildren()) {
            sb.append(printDiagnostic(child, indent + "  "));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GatewayServer server = new GatewayServer(new EMFValidator());
        server.start();
        System.out.println("EMF Validator started!");
    }
}
*/

/*
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import py4j.GatewayServer;
import java.io.IOException;

public class EMFValidator {

    public String validateModel(String modelPath, String metamodelPath) {
        try {
            ResourceSet resourceSet = new ResourceSetImpl();

            // REGISTER Ecore Resource Factory (for loading Ecore files)
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

            // REGISTER BPMN Resource Factory (for loading .bpmn files) (.hepsy, .caex)
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bpmn", new XMIResourceFactoryImpl());

            // Load the Metamodel (Ecore file received from Python)
            System.out.println("Loading Metamodel from: " + metamodelPath);
            URI ecoreURI = URI.createFileURI(metamodelPath);
            Resource metamodelResource = resourceSet.getResource(ecoreURI, true);
            metamodelResource.load(null);

            // Register Metamodel in EMF Registry
            for (EObject eObject : metamodelResource.getContents()) {
                if (eObject instanceof EPackage) {
                    EPackage ePackage = (EPackage) eObject;
                    EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
                    System.out.println("Registered Metamodel: " + ePackage.getNsURI());
                }
            }

            // Load the BPMN Model to Validate
            System.out.println("Loading Model from: " + modelPath);
            URI modelURI = URI.createFileURI(modelPath);
            Resource modelResource = resourceSet.getResource(modelURI, true);
            modelResource.load(null);

            // Validate the Model
            EObject model = modelResource.getContents().get(0);
            Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);

            if (diagnostic.getSeverity() == Diagnostic.OK) {
                return "Validation successful: No errors found.";
            } else {
                return "Validation errors found:\n" + printDiagnostic(diagnostic, "");
            }
        } catch (IOException e) {
            return "Error loading metamodel: " + e.getMessage();
        } catch (Exception e) {
            return "Validation error: " + e.getMessage();
        }
    }

    private String printDiagnostic(Diagnostic diagnostic, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(diagnostic.getMessage()).append("\n");
        for (Diagnostic child : diagnostic.getChildren()) {
            sb.append(printDiagnostic(child, indent + "  "));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GatewayServer server = new GatewayServer(new EMFValidator());
        server.start();
        System.out.println("EMF Validator started! Ready to receive models.");
    }
}
*/

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import py4j.GatewayServer;
import java.io.IOException;

public class EMFValidator {

    public String validateModel(String modelPath, String metamodelPath, String fileExtension) {
        try {
            ResourceSet resourceSet = new ResourceSetImpl();

            // REGISTER Ecore Resource Factory (for loading Ecore files)
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

            // REGISTER Resource Factory for the specified file extension
            System.out.println("Registering resource factory for extension: " + fileExtension);
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, new XMIResourceFactoryImpl());

            // Load the Metamodel (Ecore file received from Python)
            System.out.println("Loading Metamodel from: " + metamodelPath);
            URI ecoreURI = URI.createFileURI(metamodelPath);
            Resource metamodelResource = resourceSet.getResource(ecoreURI, true);
            metamodelResource.load(null);

            // Register Metamodel in EMF Registry
            for (EObject eObject : metamodelResource.getContents()) {
                if (eObject instanceof EPackage) {
                    EPackage ePackage = (EPackage) eObject;
                    EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
                    System.out.println("Registered Metamodel: " + ePackage.getNsURI());
                }
            }

            // Load the Model to Validate
            System.out.println("Loading Model from: " + modelPath);
            URI modelURI = URI.createFileURI(modelPath);
            Resource modelResource = resourceSet.getResource(modelURI, true);
            modelResource.load(null);

            // Validate the Model
            EObject model = modelResource.getContents().get(0);
            Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);

            if (diagnostic.getSeverity() == Diagnostic.OK) {
                return "Validation successful: No errors found.";
            } else {
                return "Validation errors found:\n" + printDiagnostic(diagnostic, "");
            }
        } catch (IOException e) {
            return "Error loading metamodel: " + e.getMessage();
        } catch (Exception e) {
            return "Validation error: " + e.getMessage();
        }
    }

    private String printDiagnostic(Diagnostic diagnostic, String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(diagnostic.getMessage()).append("\n");
        for (Diagnostic child : diagnostic.getChildren()) {
            sb.append(printDiagnostic(child, indent + "  "));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GatewayServer server = new GatewayServer(new EMFValidator());
        server.start();
        System.out.println("EMF Validator started! Ready to receive models.");
    }
}