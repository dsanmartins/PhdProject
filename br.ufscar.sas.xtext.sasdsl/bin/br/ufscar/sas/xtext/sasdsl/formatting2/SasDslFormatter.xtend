
package br.ufscar.sas.xtext.sasdsl.formatting2

import br.ufscar.sas.xtext.sasdsl.sasDsl.ArchitectureDefinition
import br.ufscar.sas.xtext.sasdsl.services.SasDslGrammarAccess
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage

class SasDslFormatter extends AbstractFormatter2 {
	
	@Inject extension SasDslGrammarAccess
	
	def dispatch void format(ArchitectureDefinition architecture, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		
		val lastManaging = architecture.managing.last
		
		for (managing : architecture.managing){
			
			if (managing == lastManaging)
				managing.append[setNewLines(1)]
			else
				managing.append[setNewLines(2)]
		}
		
		val lastManaged = architecture.managed.last
		
		for (managed : architecture.managed){
			
			if (managed == lastManaged)
				managed.append[setNewLines(1)]
			else
				managed.append[setNewLines(2)]
		}
		
		
		val open1 = architecture.regionFor.keyword("{")
		val close1 = architecture.regionFor.keyword("}")
		open1.append[newLine]
		interior(open1,close1)[indent]
		
		for (managing: architecture.managing)
		{
			val open2 = managing.regionFor.keyword("{")
			val close2 = managing.regionFor.keyword("}")
			open2.append[newLine]
			interior(open2,close2)[indent]
		}
		
		for (managing: architecture.managing)
		{
			for (controller : managing.controller)
			{
				val open2 = controller.regionFor.keyword("{")
				val close2 = controller.regionFor.keyword("}")
				open2.append[newLine]
				interior(open2,close2)[indent]
			}
		}
		
		for (managing: architecture.managing)
		{
			for (mcontroller : managing.managerController)
			{
				val open2 = mcontroller.regionFor.keyword("{")
				val close2 = mcontroller.regionFor.keyword("}")
				open2.append[newLine]
				interior(open2,close2)[indent]
			}
		}
		
		for (managing: architecture.managing)
		{
			for (controller : managing.controller)
			{
				for (knowledge : controller.knowledge){
					
					val open2 = knowledge.regionFor.keyword("{")
					val close2 = knowledge.regionFor.keyword("}")
					open2.append[newLine]
					interior(open2,close2)[indent]
				}
			}
		}
	
		
		for (managed: architecture.managed)
		{
			val open2 = managed.regionFor.keyword("{")
			val close2 = managed.regionFor.keyword("}")
			open2.append[newLine]
			interior(open2,close2)[indent]
		}
		
		
	} 
}
 
