/*******************************************************************************
 * Copyright (c)  2016 Daniel San Martin Santibanez.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Daniel San Martin Santibanez - initial API and implementation and/or initial documentation
 *  
 *******************************************************************************/
package br.ufscar.sas.ocl;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.infra.query.ModelQuery;
import org.eclipse.gmt.modisco.infra.query.ModelQuerySet;
import org.eclipse.gmt.modisco.infra.query.core.AbstractModelQuery;
import org.eclipse.gmt.modisco.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.gmt.modisco.infra.query.runtime.ModelQueryResult;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KDMModel;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;

@SuppressWarnings("deprecation")
public class OCLQuery {
	
	KDMModel context;
	
	
	public OCLQuery (Resource rs)
	{
		Segment kdmSegment =  (Segment) rs.getContents().get(0);	
		EList <KDMModel> lKdmModel = kdmSegment.getModel();
		context = lKdmModel.get(0);
	}
	
	public Iterator<ClassUnit> getClasses() throws Exception
	{
		ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton(); 
		ModelQuerySet modelQuerySet = catalog.getModelQuerySet("Query");
		ModelQuery modelQuery = modelQuerySet.getQuery("getClasses");
		AbstractModelQuery myModelQuery = catalog.getModelQueryImpl(modelQuery);
		ModelQueryResult result = myModelQuery.evaluate(context);
		if (result.getException() != null)
		{
			throw new Exception();
		}
		@SuppressWarnings("unchecked")
		Iterator<ClassUnit> it = ((HashSet <ClassUnit>) result.getValue()).iterator();
		
		return it;
	}
}
