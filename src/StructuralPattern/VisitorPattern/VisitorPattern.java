package VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {

	public static void main(String[] args) {
		TagNameVisitor visitor = new TagNameVisitorImpl();
		ParentXML_Node parent_node = new ParentXML_Node();
		parent_node.setNodeName("ParentNode");
		LeafXML_Node leaf_node = new LeafXML_Node();
		leaf_node.setNodeName("LeafNode");
		leaf_node.addPostfix(visitor);
		parent_node.getChildNode().add(leaf_node);
		parent_node.addPrefix(visitor);
		System.out.println(parent_node.genXML());
	}
}

interface TagNameVisitor {

	public void addTagNamePostfix(XML_Node node);

	public void addTagNamePrefix(XML_Node node);
}

class TagNameVisitorImpl implements TagNameVisitor {

	@Override
	public void addTagNamePostfix(XML_Node node) {
		node.setNodeName(node.getNodeName() + "_MyPostfix");
	}

	@Override
	public void addTagNamePrefix(XML_Node node) {
		node.setNodeName("MyPrefix_" + node.getNodeName());
	}
}

abstract class XML_Node {

	String nodeName;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public abstract String genXML();

	public String genStartNode() {
		return "<" + nodeName + "> \n";
	}

	public String genEndNode() {
		return "</" + nodeName + "> \n";
	}
}

class ParentXML_Node extends XML_Node {

	List<XML_Node> childNode = new ArrayList<>();

	public List<XML_Node> getChildNode() {
		return childNode;
	}

	public void setChildNode(List<XML_Node> childNode) {
		this.childNode = childNode;
	}

	@Override
	public String genXML() {
		StringBuilder xmlBuilder = new StringBuilder();
		xmlBuilder.append(genStartNode());
		this.childNode.forEach(node -> xmlBuilder.append(node.genXML()));
		xmlBuilder.append(genEndNode());
		return xmlBuilder.toString();
	}
}

class LeafXML_Node extends XML_Node {

	@Override
	public String genXML() {
		StringBuilder xmlBuilder = new StringBuilder();
		xmlBuilder.append(genStartNode());
		xmlBuilder.append(genEndNode());
		return xmlBuilder.toString();
	}

	public String genStartNode() {

		return "\t" + super.genStartNode();
	}

	public String genEndNode() {
		return "\t" + super.genEndNode();
	}

}
