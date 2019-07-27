package br.ufscar.sas.modelgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphContainer;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

public class ArchitectureVisualization extends ViewPart {

	public static final String ID = "de.vogella.zest.jface.view";
	Map<String, List<String>>  nodes;
	Composite parent;
	private Graph graphObj;


	@Override
	public void createPartControl(Composite parent) {

		graphObj = new Graph(parent, SWT.NONE);


	}

	public void setListNodes(Map<String, List<String>> nodes, List<String> relations) {

		this.clearGraph(graphObj);
		List<String> memory1 = new ArrayList<String>();
		List<String> memory2 = new ArrayList<String>();
		memory1.addAll(nodes.get("root"));
		memory2.addAll(nodes.get("root"));

		while (!memory1.isEmpty())
		{
			String node = memory1.remove(0);
			List<String> children = nodes.get(node);
			Collections.reverse(children);
			if (!children.isEmpty())
			{
				//If they are root nodes
				if (memory2.contains(new String(node)))
				{
					memory2.remove(new String(node));
					if (!nodes.get(node).isEmpty())
						new GraphContainer(graphObj,SWT.NONE).setText(node);
					else
						new GraphNode(graphObj, SWT.NONE, node); 
					node = "";
				}

				if (!node.equals(""))
				{	
					String parentOfParent = this.getParent(node, nodes);
					if (!nodes.get(node).isEmpty())
						this.addNodeToContainer(parentOfParent, node, true);
					else
						this.addNodeToContainer(parentOfParent, node, false);
				}

				for (String child : children)
					memory1.add(0, child);
			}
			else
			{
				String parentOfParent = this.getParent(node, nodes);
				if (!parentOfParent.equals("root"))
					this.addNodeToContainer(parentOfParent, node, false);

			}
		}

		for (String memory: memory2)
		{
			if (!nodes.get(memory).isEmpty())
				new GraphContainer(graphObj,SWT.NONE).setText(memory);
			else
				new GraphNode(graphObj, SWT.NONE, memory); 
		}

		if (!relations.isEmpty())
		{
			for (String relation: relations) {

				String line[] = relation.split(Pattern.quote("-"));
				GraphNode from = this.getNode(line[0]);
				GraphNode to = this.getNode(line[1]);
				List<String> rel = Arrays.asList(line[2].split(Pattern.quote(" ")));
				Map<String, Long> counted = rel.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

				for (String key :counted.keySet() )
				{
					GraphConnection graphconnection = new GraphConnection(graphObj, ZestStyles.CONNECTIONS_DIRECTED, from, to);
					graphconnection.setText(counted.get(key).toString() + " " + key);
				}
			}
		}

		graphObj.redraw();
		graphObj.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		graphObj.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent selectionEventObj) {
				System.out.println(selectionEventObj);
			}
		});
	}

	public void setFocus() {
	}

	public String getParent(String node, Map<String, List<String>> nodes ) {

		for (String key:nodes.keySet() )
		{
			for (String child: nodes.get(key) )
				if (child.equals(node))
					return key;
		}
		return null; 
	}

	private void addNodeToContainer(String parent, String nameOfNode, boolean hasChildren) {

		List<GraphNode> memory = new ArrayList<GraphNode>();
		for (int i=0; i< graphObj.getNodes().size(); i++)
			memory.addAll(graphObj.getNodes());

		String nodeName = "";
		while (!memory.isEmpty())
		{
			GraphNode node = (GraphNode) memory.remove(0);
			if (node instanceof GraphContainer)
			{
				GraphContainer graphContainer = (GraphContainer) node;
				nodeName = graphContainer.getText();

				List<GraphNode> children = graphContainer.getNodes();
				Collections.reverse(children);
				if (!children.isEmpty())
				{
					for (int i =0; i< children.size(); i++)
						memory.add(0, children.get(i));
				}

				if (nodeName.equals(parent)) {
					if (hasChildren)
						new GraphContainer((GraphContainer) node,SWT.NONE).setText(nameOfNode);
					else
						new GraphNode( (GraphContainer) node, SWT.NONE).setText(nameOfNode);
					break;
				}
			}
			else
			{
				if (node instanceof GraphNode)
				{
					GraphNode graphNode = (GraphNode) node;
					System.out.println(graphNode.getText());
				}
			}
		}
	}

	private GraphNode getNode(String name) {

		List<GraphNode> memory = new ArrayList<GraphNode>();
		for (int i=0; i< graphObj.getNodes().size(); i++)
			memory.addAll(graphObj.getNodes());

		String nodeName = "";
		while (!memory.isEmpty())
		{
			GraphNode node = (GraphNode) memory.remove(0);
			if (node instanceof GraphContainer)
			{
				GraphContainer graphContainer = (GraphContainer) node;
				nodeName = graphContainer.getText();

				List<GraphNode> children = graphContainer.getNodes();
				Collections.reverse(children);
				if (!children.isEmpty())
				{
					for (int i =0; i< children.size(); i++)
						memory.add(0, children.get(i));
				}

				if (nodeName.equals(name)) {
					return node;
				}
			}
			else
			{
				if (node instanceof GraphNode)
				{
					if (node.getText().equals(name))
					{
						GraphNode graphNode = (GraphNode) node;
						return node;
					}
				}
			}
		}
		return null;
	}

	public void clearGraph( Graph graph )
	{       
		Object[] objects = graph.getConnections().toArray() ;           
		for (int i = 0 ; i < objects.length; i++)
		{
			GraphConnection graCon = (GraphConnection) objects[i];
			if(!graCon.isDisposed())
				graCon.dispose();
		}            

		objects = graph.getNodes().toArray();       
		for (int i = 0; i < objects.length; i++)
		{
			GraphNode graNode = (GraphNode) objects[i];
			if(!graNode.isDisposed())
				graNode.dispose();
		}
	}


}	
