# An Architectural Conformance Checking

### Brief Description

The purpose of this application is to aid software engineers on detecting architectural anomalies in adaptive systems (ASs). Engineers have to identify main abstractions of an AS and specify the planned architecture by means a domain specific language. After that, the application is able to identify and recommend possible architectural anomalies.

### Applictation Details

The application was developed in several eclipse plugins in order to separate the functionalities and maintain them properly. 
The developing environment:  Eclipse 2018-12 (v4.10).
The list of plugins are:

  - AspectJ with equinox weaving
  - EMF tools
  - PlantUML
  - Modisco
  - Xtext
  - Xtend
  - GEF - ZEST
  - Sirius
  - OCL classic
  - SWT Toolkit
 
In order to run it, run as eclipse application and configure the following properties:

Run as -> Run configurations:

1. Program Arguments:

    `-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl} -consoleLog-clearPersistedState -persistState false`

2. VM arguments:
`
	-Dosgi.framework.extensions=org.eclipse.equinox.weaving.hook
	-Daj.weaving.verbose=true
	-Dorg.aspectj.weaver.showWeaveInfo=true
	-Dorg.aspectj.osgi.verbose=true
`
3. Plugins:

	`org.eclipse.equinox.weaving.aspectj, start-level:1 Auto-start: true`

4. Note that `org.eclipse.equinox.weaving.hook must` be in the same directory as `org.eclipse.osgi.`
