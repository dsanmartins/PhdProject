/*
 * generated by Xtext 2.10.0
 */
package br.ufscar.sas.xtext.sasdsl.validation

import br.ufscar.sas.database.QueryClass
import br.ufscar.sas.view.MainView
import br.ufscar.sas.xtext.sasdsl.sasDsl.ArchitectureDefinition
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLAlternative
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLAnalyzer
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLDomainRule
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLEffector
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLExecutor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLKnowledge
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManaged
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManagerController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLManaging
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMeasuredOutput
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLMonitor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLPlanner
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLReferenceInput
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleAnalyzer
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleExecutor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleKnowledge
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleMController
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleMO
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRuleMonitor
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRulePlanner
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLRules
import br.ufscar.sas.xtext.sasdsl.sasDsl.DSLSensor
import br.ufscar.sas.xtext.sasdsl.sasDsl.SasDslPackage
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.HashMultimap
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class SasDslValidator extends AbstractSasDslValidator {
	
	protected static val ISSUE_CODE_PREFIX = "br.ufscar.abstractions.rules.";
	protected static val ISSUE_CODE_PREFIX_2 = "br.ufscar.abstractions.names.";
	public static val DUCPLICATE_MCONTROLLER_ACCESS = ISSUE_CODE_PREFIX + "AccessSameMController"
	public static val DUCPLICATE_CONTROLLER_ACCESS = ISSUE_CODE_PREFIX + "AccessSameController"
	public static val DUCPLICATE_MONITOR_ACCESS = ISSUE_CODE_PREFIX + "AccessSameMonitor"
	public static val DUCPLICATE_ANALYZER_ACCESS = ISSUE_CODE_PREFIX + "AccessSameAnalyzer"
	public static val DUCPLICATE_PLANNER_ACCESS = ISSUE_CODE_PREFIX + "AccessSamePlanner"
	public static val DUCPLICATE_EXECUTOR_ACCESS = ISSUE_CODE_PREFIX + "AccessSameExecutor"
	public static val DUCPLICATE_RULES = ISSUE_CODE_PREFIX + "DuplicateRules"
	public static val DUCPLICATE_NAMES = ISSUE_CODE_PREFIX + "DuplicateNames"


	@Check
	def checkInMControllerRuleNotAccessTheSame(DSLRuleMController dslRuleMController)
	{
		if (dslRuleMController.mcontroller2 !== null)
			if (dslRuleMController.mcontroller1 == dslRuleMController.mcontroller2)
				error("Manager controllers cannot access themselves", SasDslPackage.eINSTANCE.DSLRuleMController_Mcontroller2, DUCPLICATE_CONTROLLER_ACCESS)
	}

	@Check
	def checkInControllerRuleNotAccessTheSame(DSLRuleController dslRuleController)
	{
		if (dslRuleController.controller2 !== null)
			if (dslRuleController.controller1 == dslRuleController.controller2)
				error("Controllers cannot access themselves", SasDslPackage.eINSTANCE.DSLRuleController_Controller2, DUCPLICATE_CONTROLLER_ACCESS)
	}
	
	@Check
	def checkInMonitorRuleNotAccessTheSame(DSLRuleMonitor dslRuleMonitor)
	{
		if (dslRuleMonitor.monitor2 !== null)
			if (dslRuleMonitor.monitor == dslRuleMonitor.monitor2)
				error("Monitors cannot access themselves", SasDslPackage.eINSTANCE.DSLRuleMonitor_Monitor2, DUCPLICATE_MONITOR_ACCESS)
	}
	
	@Check
	def checkInAnalyzerRuleNotAccessTheSame(DSLRuleAnalyzer dslRuleAnalyzer)
	{
		if (dslRuleAnalyzer.analyzer2 !== null)
			if (dslRuleAnalyzer.analyzer == dslRuleAnalyzer.analyzer2)
				error("Analyzers cannot access themselves", SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Analyzer2, DUCPLICATE_ANALYZER_ACCESS)
	}
	
	@Check
	def checkInPlannerRuleNotAccessTheSame(DSLRulePlanner dslRulePlanner)
	{
		if (dslRulePlanner.planner2 !== null)
			if (dslRulePlanner.planner == dslRulePlanner.planner2)
				error("Planners cannot access themselves", SasDslPackage.eINSTANCE.DSLRulePlanner_Planner2, DUCPLICATE_PLANNER_ACCESS)
	}
	
	@Check
	def checkInExecutorRuleNotAccessTheSame(DSLRuleExecutor dslRuleExecutor)
	{
		if (dslRuleExecutor.executor2 !== null)
			if (dslRuleExecutor.executor == dslRuleExecutor.executor2)
				error("Executors cannot access themselves", SasDslPackage.eINSTANCE.DSLRuleExecutor_Executor2, DUCPLICATE_EXECUTOR_ACCESS)
	}
	
	@Check 
	def void checkNoDuplicateControllers(ArchitectureDefinition r){
		
		checkNoDuplicateRules(r.rules)
	}
	
	@Check 
	def void checkNoDuplicateAbstractions(ArchitectureDefinition r){
		
		checkNoDuplicateManaging(r.managing)
		checkNoDuplicateManaged(r.managed)
	}
	
	def private void checkNoDuplicateManaged(EList<DSLManaged> managed){
	
		val multiMapAbstraction = ArrayListMultimap.create()
		for (m:managed)
		{
			multiMapAbstraction.put(m.name,m)
			val sensor = m.sensor
			for (s:sensor)
		    	multiMapAbstraction.put(s.name,s)
		    val effector = m.effector
			for (e:effector)
		    	multiMapAbstraction.put(e.name,e)
		    val measuredOutput = m.measuredOutput
		    for (mo:measuredOutput)
		    	multiMapAbstraction.put(mo.name,mo)
		
		}
		
			multiMapAbstraction.asMap.forEach[k, v| 
		
			val values = v
			if (values.size > 1 )
			{
				for (abs:values)
				{
					if (abs instanceof DSLManaged)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLManaged_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLSensor)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLSensor_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLEffector)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLEffector_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLMeasuredOutput)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLMeasuredOutput_Name, DUCPLICATE_NAMES)
				}
			}
		]	
	}
		
	def private void checkNoDuplicateManaging(EList<DSLManaging> managing){
		
		val multiMapAbstraction = ArrayListMultimap.create()
		for (m:managing)
		{
			multiMapAbstraction.put(m.name,m)
			val mcontroller = m.managerController
		    for (mc:mcontroller)
		    {
		    	multiMapAbstraction.put(mc.name,mc)
		    	val controller = mc.controller
		    	for (c:controller )
		    	{
		    		multiMapAbstraction.put(c.name,c)
		    		val monitor = c.monitor
		    		for (mo:monitor)
		    			multiMapAbstraction.put(mo.name,mo)
		    		val analyzer = c.analyzer
		    		for (a:analyzer)
		    			multiMapAbstraction.put(a.name,a)
		    		val planner = c.planner
		    		for (p:planner)
		    			multiMapAbstraction.put(p.name,p)
		    		val executor = c.executor
		    		for (e:executor)
		    			multiMapAbstraction.put(e.name,e)
		    		val knowledge = c.knowledge
		    		for (k:knowledge)
		    		{
		    			multiMapAbstraction.put(k.name,k)
		    			val alternative = k.shalt;
		    			for (al:alternative)
		    				multiMapAbstraction.put(al.name,al)
		    			val refInput = k.referenceInput;
		    			for (re:refInput)
		    				multiMapAbstraction.put(re.name,re)
		    		}	
		    	}
		    }
		    
		    val controller = m.controller
		    for (c:controller )
		    {
		    	multiMapAbstraction.put(c.name,c)
		    	val monitor = c.monitor
		    	for (mo:monitor)
		    		multiMapAbstraction.put(mo.name,mo)
		    	val analyzer = c.analyzer
		    	for (a:analyzer)
		    		multiMapAbstraction.put(a.name,a)
		    	val planner = c.planner
		    	for (p:planner)
		    		multiMapAbstraction.put(p.name,p)
		    	val executor = c.executor
		    	for (e:executor)
		    		multiMapAbstraction.put(e.name,e)
		    	val knowledge = c.knowledge
		    	for (k:knowledge)
		    	{
		    		multiMapAbstraction.put(k.name,k)
		    		val alternative = k.shalt;
		    		for (al:alternative)
		    			multiMapAbstraction.put(al.name,k)
		    		val refInput = k.referenceInput;
		    		for (re:refInput)
		    			multiMapAbstraction.put(re.name,re)
		    	}	
		    }
		}
		
		
		multiMapAbstraction.asMap.forEach[k, v| 
		
			val values = v
			if (values.size > 1 )
			{
				for (abs:values)
				{
					if (abs instanceof DSLMonitor)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLMonitor_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLAnalyzer)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLAnalyzer_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLPlanner)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLPlanner_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLExecutor)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLExecutor_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLManaging)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLManaging_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLKnowledge)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLKnowledge_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLReferenceInput)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLReferenceInput_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLManagerController)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLManagerController_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLController)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLController_Name, DUCPLICATE_NAMES)
					if (abs instanceof DSLAlternative)
						error("Same abstraction name",abs, SasDslPackage.eINSTANCE.DSLAlternative_Name, DUCPLICATE_NAMES)
				}
			}
		]
	}
	
	def private void checkNoDuplicateRules(EList<DSLRules> rules){
		
		val multiMapRuleMController = HashMultimap.create()
		val multiMapRuleController = HashMultimap.create()
		
		val multiMapRuleMonitor2Monitor = HashMultimap.create()
		val multiMapRuleMonitor2Analyzer = HashMultimap.create()
		val multiMapRuleMonitor2Sensor = HashMultimap.create()
		val multiMapRuleMonitor2Knowledge = HashMultimap.create() 
		val multiMapRuleMonitor2Planner = HashMultimap.create()
		val multiMapRuleMonitor2Executor = HashMultimap.create()
		 
		val multiMapRuleAnalyzer2Analyzer = HashMultimap.create()
		val multiMapRuleAnalyzer2Monitor = HashMultimap.create()
		val multiMapRuleAnalyzer2Rreference = HashMultimap.create()
		val multiMapRuleAnalyzer2Planner = HashMultimap.create()
		val multiMapRuleAnalyzer2Knowledge= HashMultimap.create()
		val multiMapRuleAnalyzer2Executor= HashMultimap.create()
		val multiMapRuleAnalyzer2Alternative = HashMultimap.create()
		
		val multiMapRulePlanner2Planner = HashMultimap.create()
		val multiMapRulePlanner2Analyzer = HashMultimap.create()
		val multiMapRulePlanner2Executor= HashMultimap.create()
		val multiMapRulePlanner2Knowledge= HashMultimap.create()
		val multiMapRulePlanner2Monitor= HashMultimap.create()
		val multiMapRulePlanner2Alternative= HashMultimap.create()
		
		val multiMapRuleExecutor2Executor = HashMultimap.create()
		val multiMapRuleExecutor2Planner = HashMultimap.create()
		val multiMapRuleExecutor2Effector = HashMultimap.create()
		val multiMapRuleExecutor2Knowledge = HashMultimap.create()
		val multiMapRuleExecutor2Monitor = HashMultimap.create()
		val multiMapRuleExecutor2Analyzer = HashMultimap.create()
		
		
		val multiMapRuleSensor = HashMultimap.create()
		
		
		for(r:rules)
		{
			if (r instanceof DSLRuleController)
				multiMapRuleController.put(r.controller1.name+r.controller2.name,r)
				
			if (r instanceof DSLRuleMController)
				multiMapRuleMController.put(r.mcontroller1.name+r.mcontroller2.name,r)
				
			if (r instanceof DSLRuleMonitor)
			{
				if (r.monitor2 !== null)
					multiMapRuleMonitor2Monitor.put(r.monitor.name+r.monitor2.name,r)	
				if (r.analyzer !== null)
					multiMapRuleMonitor2Analyzer.put(r.monitor.name+r.analyzer.name,r)	
				if (r.sensor !== null)
					multiMapRuleMonitor2Sensor.put(r.monitor.name+r.sensor.name,r)
				if (r.knowledge !== null)	
					multiMapRuleMonitor2Knowledge.put(r.monitor.name+r.knowledge.name,r)	 
				if (r.planner !== null)	
					multiMapRuleMonitor2Planner.put(r.monitor.name+r.planner.name,r)	
				if (r.executor !== null)	
					multiMapRuleMonitor2Executor.put(r.monitor.name+r.executor.name,r)	
			}
			if (r instanceof DSLRuleAnalyzer)
			{
				if (r.analyzer2 !== null)
					multiMapRuleAnalyzer2Analyzer.put(r.analyzer.name+r.analyzer2.name,r)	
				if (r.monitor !== null)
					multiMapRuleAnalyzer2Monitor.put(r.analyzer.name+r.monitor.name,r)	
				if (r.rreference !== null)
					multiMapRuleAnalyzer2Rreference.put(r.analyzer.name+r.rreference.name,r)	
				if (r.planner !== null)
					multiMapRuleAnalyzer2Planner.put(r.analyzer.name+r.planner.name,r)	
				if (r.knowledge !== null)
					multiMapRuleAnalyzer2Knowledge.put(r.analyzer.name+r.knowledge.name,r)	
				if (r.executor !== null)
					multiMapRuleAnalyzer2Executor.put(r.analyzer.name+r.executor.name,r)	
				if (r.shalt !== null)
					multiMapRuleAnalyzer2Executor.put(r.analyzer.name+r.shalt.name,r)	
			}
			
			if (r instanceof DSLRulePlanner)
			{
				if (r.planner2 !== null)
					multiMapRulePlanner2Planner.put(r.planner.name+r.planner2.name,r)	
				if (r.analyzer !== null)
					multiMapRulePlanner2Analyzer.put(r.planner.name+r.analyzer.name,r)	
				if (r.executor !== null)
					multiMapRulePlanner2Executor.put(r.planner.name+r.executor.name,r)	
				if (r.knowledge !== null)
					multiMapRulePlanner2Knowledge.put(r.planner.name+r.knowledge.name,r)	
				if (r.monitor !== null)
					multiMapRulePlanner2Monitor.put(r.planner.name+r.monitor.name,r)	
				if (r.shalt !== null)
					multiMapRulePlanner2Alternative.put(r.planner.name+r.shalt.name,r)	
			}
			if (r instanceof DSLRuleExecutor)
			{
				if (r.executor2 !== null)
					multiMapRuleExecutor2Executor.put(r.executor.name+r.executor2.name,r)	
				if (r.effector !== null)
					multiMapRuleExecutor2Effector.put(r.executor.name+r.effector.name,r)	
				if (r.knowledge !== null)
					multiMapRuleExecutor2Knowledge.put(r.executor.name+r.knowledge.name,r)	
				if (r.executor2 !== null)
					multiMapRuleExecutor2Planner.put(r.executor.name+r.executor2.name,r)	
				if (r.monitor !== null)
					multiMapRuleExecutor2Monitor.put(r.executor.name+r.monitor.name,r)	
				if (r.analyzer !== null)
					multiMapRuleExecutor2Analyzer.put(r.executor.name+r.analyzer.name,r)	
			}
			if (r instanceof DSLRuleMO)
				multiMapRuleSensor.put(r.sensor.name+r.measured.name,r)
		}
		
		for (entry:multiMapRuleController.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleController_Controller2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMController.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMController_Mcontroller2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Monitor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Monitor2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Planner.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Planner, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Executor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Executor, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Analyzer.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Analyzer, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Knowledge.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Knowledge, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleMonitor2Sensor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMonitor_Sensor, DUCPLICATE_RULES)
			}
		}
		
		
		for (entry:multiMapRuleAnalyzer2Analyzer.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Analyzer2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Knowledge.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Knowledge, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Monitor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Monitor, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Planner.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Planner, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Rreference.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Rreference, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Executor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Rreference, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleAnalyzer2Alternative.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Rreference, DUCPLICATE_RULES)
			}
		}
		
		
		for (entry:multiMapRulePlanner2Planner.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Planner2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRulePlanner2Monitor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Monitor, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRulePlanner2Analyzer.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Analyzer, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRulePlanner2Knowledge.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Knowledge, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRulePlanner2Alternative.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Shalt, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRulePlanner2Executor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRulePlanner_Executor, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Executor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Executor2, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Monitor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Monitor, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Analyzer.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Analyzer, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Effector.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Effector, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Knowledge.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Knowledge, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleExecutor2Planner.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleExecutor_Planner, DUCPLICATE_RULES)
			}
		}
		
		for (entry:multiMapRuleSensor.asMap.entrySet)
		{
			val duplicates = entry.value
			if (duplicates.size > 1){
				for (d:duplicates)
					error("Duplicated rule",d, SasDslPackage.eINSTANCE.DSLRuleMO_Measured, DUCPLICATE_RULES)
			}
		}
	}

	@Check
	def checkNotAccessMonitor2Planner(DSLRuleMonitor dslRuleMonitor){
		
		var dslDomain = dslRuleMonitor.monitor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Monitor","Planner");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleMonitor.planner !== null && dslRuleMonitor.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleMonitor_Planner)
		}	

	}
	
	@Check
	def checkNotAccessMonitor2Executor(DSLRuleMonitor dslRuleMonitor){
		
		var dslDomain = dslRuleMonitor.monitor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Monitor","Executor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleMonitor.executor !== null && dslRuleMonitor.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleMonitor_Executor)
		}	

	}
	
	@Check
	def checkNotAccessAnalyzer2Monitor(DSLRuleAnalyzer dslRuleAnalyzer){
		
		var dslDomain = dslRuleAnalyzer.analyzer.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Analyzer","Monitor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleAnalyzer.monitor !== null && dslRuleAnalyzer.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Monitor)
		}	

	}
	
	@Check
	def checkNotAccessPlanner2Monitor(DSLRulePlanner dslRulePlanner){
		
		var dslDomain = dslRulePlanner.planner.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Planner","Monitor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRulePlanner.monitor !== null && dslRulePlanner.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRulePlanner_Monitor)
		}	

	}
	
	@Check
	def checkNotAccessPlanner2Analyzer(DSLRulePlanner dslRulePlanner){
		
		var dslDomain = dslRulePlanner.planner.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Planner","Analyzer");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRulePlanner.analyzer !== null && dslRulePlanner.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRulePlanner_Analyzer)
		}	

	}
	
	@Check
	def checkNotAccessExecutor2Monitor(DSLRuleExecutor dslRuleExecutor){
		
		var dslDomain = dslRuleExecutor.executor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Executor","Monitor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleExecutor.monitor !== null && dslRuleExecutor.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleExecutor_Monitor)
		}	

	}
	
	@Check
	def checkNotAccessExecutor2Analyzer(DSLRuleExecutor dslRuleExecutor){
		
		var dslDomain = dslRuleExecutor.executor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Executor","Analyzer");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleExecutor.analyzer !== null && dslRuleExecutor.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleExecutor_Analyzer)
		}	

	}
	
	@Check
	def checkNotAccessExecutor2Planner(DSLRuleExecutor dslRuleExecutor){
		
		var dslDomain = dslRuleExecutor.executor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Executor","Planner");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleExecutor.planner !== null && dslRuleExecutor.access.equals("must-use") )
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleExecutor_Planner)
		}	

	}
	
	@Check
	def checkNotAccessKnowledge2Monitor(DSLRuleKnowledge dslRuleKnowledge){
		
		var dslDomain = dslRuleKnowledge.knowledge.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Knowledge","Monitor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleKnowledge.monitor !== null && dslRuleKnowledge.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleKnowledge_Monitor)
		}	

	}
	
	@Check
	def checkNotAccessKnowledge2Analyzer(DSLRuleKnowledge dslRuleKnowledge){
		
		var dslDomain = dslRuleKnowledge.knowledge.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Knowledge","Analyzer");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleKnowledge.analyzer !== null && dslRuleKnowledge.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleKnowledge_Analyzer)
		}	

	}
	
	@Check
	def checkNotAccessKnowledge2Planner(DSLRuleKnowledge dslRuleKnowledge){
		
		var dslDomain = dslRuleKnowledge.knowledge.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Knowledge","Planner");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleKnowledge.planner !== null  && dslRuleKnowledge.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleKnowledge_Planner)
		}	

	}
	
	@Check
	def checkNotAccessKnowledge2Executor(DSLRuleKnowledge dslRuleKnowledge){
		
		var dslDomain = dslRuleKnowledge.knowledge.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Knowledge","Executor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleKnowledge.executor !== null && dslRuleKnowledge.access.equals("must-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleKnowledge_Executor)
		}	

	}

	@Check
	def checkAccessMonitor2Planner(DSLRuleMonitor dslRuleMonitor){
		
		var dslDomain = dslRuleMonitor.monitor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Monitor","Analyzer");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleMonitor.analyzer !== null && dslRuleMonitor.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleMonitor_Analyzer)
			
		}	
		
	}
	
	@Check
	def checkAccessAnalyzer2Planner(DSLRuleMonitor dslRuleAnalyzer){
		
		var dslDomain = dslRuleAnalyzer.analyzer.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Analyzer","Planner");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleAnalyzer.planner !== null && dslRuleAnalyzer.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Planner)
			
		}	
		
	}
	
	@Check
	def checkAccessAnalyzer2Executor(DSLRuleMonitor dslRuleAnalyzer){
		
		var dslDomain = dslRuleAnalyzer.analyzer.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Analyzer","Executor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleAnalyzer.executor !== null && dslRuleAnalyzer.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Executor)
		}	
		
	}
	
	@Check
	def checkAccessPlanner2Executor(DSLRulePlanner dslRulePlanner){
		
		var dslDomain = dslRulePlanner.planner.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Planner","Executor");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRulePlanner.executor !== null && dslRulePlanner.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRulePlanner_Executor)
			
		}	
	}
	
	@Check
	def checkAccessMonitor2Knowledge(DSLRuleMonitor dslRuleMonitor){
		
		var dslDomain = dslRuleMonitor.monitor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Monitor","Knowledge");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleMonitor.knowledge !== null && dslRuleMonitor.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleMonitor_Knowledge)
			
		}	
	}
	
	@Check
	def checkAccessAnalyzer2Knowledge(DSLRuleAnalyzer dslRuleAnalyzer){
		
		var dslDomain = dslRuleAnalyzer.analyzer.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Analyzer","Knowledge");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleAnalyzer.knowledge !== null && dslRuleAnalyzer.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleAnalyzer_Knowledge)
			
		}	
	}
	
	@Check
	def checkAccessPlanner2Knowledge(DSLRulePlanner dslRulePlanner){
		
		var dslDomain = dslRulePlanner.planner.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Planner","Knowledge");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRulePlanner.knowledge !== null && dslRulePlanner.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRulePlanner_Knowledge)
			
		}	
	}
	
	@Check
	def checkAccessExecutor2Knowledge(DSLRuleExecutor dslRuleExecutor){
		
		var dslDomain = dslRuleExecutor.executor.eContainer.eContents.filter(DSLDomainRule).toList
		if (!dslDomain.isEmpty)
		{
			val queryClass = new QueryClass(MainView.getDatabaseUrl())
			val rule = queryClass.ruleIsActive("Executor","Knowledge");
			if (Boolean.valueOf(rule.get(1))) 
				if (dslRuleExecutor.knowledge !== null && dslRuleExecutor.access.equals("must-not-use"))
					warning("The rule is violating the domain rule number  " + rule.get(0), SasDslPackage.eINSTANCE.DSLRuleExecutor_Knowledge)
			
		}	
	}
	
}
