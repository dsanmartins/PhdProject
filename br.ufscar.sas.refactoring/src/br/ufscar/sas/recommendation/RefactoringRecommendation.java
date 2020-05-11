package br.ufscar.sas.recommendation;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.ufscar.sas.dataconstraint.DataConstraint;

public class RefactoringRecommendation {


	public boolean generateRecommendation(IFile kdmPath, String projectUrl, String projectWorkspace) throws Exception {

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource kdmInResource = resourceSet.getResource(URI.createURI(kdmPath.getFullPath().toString()), true);	
		
		DataConstraint dataConstraint = new DataConstraint(projectUrl);
		List<String> anomalies =  dataConstraint.getAnomaliesIdentifiedExistence();
		if (!anomalies.isEmpty()) {
			for (String anomaly: anomalies) {

				String rule = anomaly.split(Pattern.quote("|"))[0];
				String type = rule.split(Pattern.quote("_"))[0];
				String abstraction = rule.split(Pattern.quote("_"))[1];
				String number = rule.split(Pattern.quote("_"))[2];
				
				if (type.equals("composite")) 
				{
					if (abstraction.equals("SelfHealingAlt"))
					{
						SelfHealingRecommendation selfHealingRecomendation = new SelfHealingRecommendation();
						selfHealingRecomendation.recomendation(resourceSet,kdmInResource, abstraction+"_"+number, projectWorkspace, rule);
					}
					
					if (abstraction.equals("ReferenceInput"))
					{
						ReferenceInputRecommendation referenceInputRecommendation = new ReferenceInputRecommendation();
						referenceInputRecommendation.recomendation(resourceSet,kdmInResource, abstraction+"_"+number, projectWorkspace, rule);
					}
				}
				else {
					if (type.equals("exist")) {
						
						if (abstraction.equals("Effector"))
						{
							MixedExecutorEffectorRecommendation mixedExecutorEffectorRecommendation = new MixedExecutorEffectorRecommendation();
							mixedExecutorEffectorRecommendation.recomendation(resourceSet, kdmInResource, abstraction+"_"+number, projectWorkspace, rule);
						}
					}
				}
			}
		}
		
		if (!anomalies.isEmpty())
			return true;
		else {
			return false;
		}
	}
}
