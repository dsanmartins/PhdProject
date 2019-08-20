package br.ufscar.sas.transformation;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IEqualityHelperFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.EqualityHelper;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;


import com.google.common.cache.Cache;
import com.google.common.cache.LoadingCache;

public class ComputeModelDiff {


	public void compute(IFile current, IFile planned) {

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		resourceSet1.getResource(URI.createURI(current.getFullPath().toString()), true);
		resourceSet2.getResource(URI.createURI(planned.getFullPath().toString()), true);


		IEqualityHelperFactory helperFactory = new DefaultEqualityHelperFactory() {
			@Override
			public org.eclipse.emf.compare.utils.IEqualityHelper createEqualityHelper() {

				final LoadingCache<EObject, URI> cache = EqualityHelper.createDefaultCache(getCacheBuilder());
				return new EqualityHelper(cache) {
					@Override
					public boolean matchingValues(Object object1, Object object2) {

						if (object1 instanceof Package && object2 instanceof Package) {
							Package package1 = (Package) object1;
							Package package2 = (Package) object2;
							if (package1.getName().equals(package2.getName()))
								return true;
							else 
								return false;
						}
						return super.matchingValues(object1, object2);
					}
				};
			}
		};



		// Configure EMF Compare
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		// Compare the two models
		IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);
		Comparison comparison = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build().compare(scope);
		
		EList<Diff> diff = comparison.getDifferences();
		for (Diff diff2 : diff)
		{
			System.out.println(diff2);
			
			if (diff2.getMatch().getLeft() instanceof Package)
			{
				Package package1 = (Package) diff2.getMatch().getLeft();
				System.out.println("Current Package :"+package1.getName());
			}
			else {
				System.out.println("Current Package is null");
			}
			
			if (diff2.getMatch().getRight() instanceof Package)
			{
				Package package1 = (Package) diff2.getMatch().getRight();
				System.out.println("Planned Package :"+package1.getName());
			}
			else {
				System.out.println("Planned Package is null");
			}
			
			if (diff2.getMatch().getLeft() instanceof Dependency)
			{
				Dependency dependency = (Dependency) diff2.getMatch().getLeft();
				System.out.println("Dependency Current :" + dependency.getClients().get(0).getName()  + " -> " + dependency.getSuppliers().get(0).getName());
			}
			else {
				System.out.println("Dependency Current is null");
			}
			
			if (diff2.getMatch().getRight() instanceof Dependency)
			{
				Dependency dependency = (Dependency) diff2.getMatch().getRight();
				System.out.println("Dependency Planned :" + dependency.getClients().get(0).getName()  + " -> " + dependency.getSuppliers().get(0).getName());
			}
			else {
				System.out.println("Dependency Planned is null");
			}
			
			System.out.println("-----------------------");
		}
	}
}
