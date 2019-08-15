package br.ufscar.sas.transformation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPackage.Literals;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

public class AdaptiveSystemUMLProfile {

	private final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	public void createProfile(String path) throws IOException {

		UMLPackage.eINSTANCE.getName();
		ResourceSet resource_set = UMLResourcesUtil.init( new ResourceSetImpl() );
		resource_set.getPackageRegistry().put( UMLPackage.eNS_URI, UMLPackage.eINSTANCE );
		resource_set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,UMLResource.Factory.INSTANCE);
		Map<URI, URI> _resourceSetURIMap = resource_set.getURIConverter().getURIMap();
		
		URI uri = URI.createURI("platform:/plugin/org.eclipse.uml2.uml.resources");
		_resourceSetURIMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
		_resourceSetURIMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
		_resourceSetURIMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));

		Resource resource = resource_set.getResource( URI.createURI( UMLResource.UML_METAMODEL_URI ), true );
		Model umlMetamodel =  (Model) EcoreUtil.getObjectByType(resource.getContents(), Literals.PACKAGE);;
				
		final Profile sasProfile = UMLFactory.eINSTANCE.createProfile();
		sasProfile.setName("Adaptive System UML Profile");
		final Stereotype monitor = sasProfile.createOwnedStereotype( "Monitor",false );
		final Stereotype analyzer = sasProfile.createOwnedStereotype( "Analyzer",false );
		final Stereotype planner = sasProfile.createOwnedStereotype( "Planner",false );
		final Stereotype executor = sasProfile.createOwnedStereotype( "Executor",false );
		final Stereotype knowledge = sasProfile.createOwnedStereotype( "Knowledge",false );
		final Stereotype referenceInput = sasProfile.createOwnedStereotype( "Reference Input",false );
		final Stereotype measuredOutput = sasProfile.createOwnedStereotype( "Measured Output",false );
		final Stereotype clManager = sasProfile.createOwnedStereotype( "CL Manager",false );
		final Stereotype cl = sasProfile.createOwnedStereotype( "Control Loop",false );
		final Stereotype sensor = sasProfile.createOwnedStereotype( "Sensor",false );
		final Stereotype effector = sasProfile.createOwnedStereotype( "Effector",false );
		final Stereotype managedSubsystem = sasProfile.createOwnedStereotype( "Managing Subsystem",false );
		final Stereotype managingSubsystem = sasProfile.createOwnedStereotype( "Managed Subsystem",false );
		final Stereotype selfHealingAlt = sasProfile.createOwnedStereotype( "Self-Healing Alternative",false );
		
		monitor.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		analyzer.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		planner.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		executor.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		knowledge.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		referenceInput.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		measuredOutput.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		clManager.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		cl.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		sensor.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		effector.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		managedSubsystem.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		managingSubsystem.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		selfHealingAlt.createExtension(referenceMetaclass( umlMetamodel, sasProfile, UMLPackage.Literals.PACKAGE.getName() ), true );
		
		sasProfile.define();
		final File outputFile = new File(path + "AdaptiveSystemProfile.uml" );
		final URI outputUri = URI.createFileURI( outputFile.getAbsolutePath() );
		final Resource resource2 = RESOURCE_SET.createResource( outputUri );
		resource2.getContents().add( sasProfile );
		resource2.save( null );
		
	}
	
	private Class referenceMetaclass( final Model umlMetamodel,	final Profile profile,final String name )
	{
		final Class metaclass = (Class) umlMetamodel.getOwnedType( name );
		if ( !profile.getReferencedMetaclasses().contains( metaclass ) )
			profile.createMetaclassReference( metaclass );

		return metaclass;
	}
}
