package BehaviorPattern.VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {

	public static void main(String[] args) {
		TagNameVisitor postfixVisitor = new PostfixNameVisitorImpl();
		TagNameVisitor prefixVisitor = new PrefixNameVisitorImpl();

		ParentXML_Node parent_node = new ParentXML_Node();
		parent_node.setNodeName("ParentNode");
		LeafXML_Node leaf_node = new LeafXML_Node();
		leaf_node.setNodeName("LeafNode");
		leaf_node.accept(postfixVisitor);
		parent_node.getChildNode().add(leaf_node);
		parent_node.accept(prefixVisitor);
		System.out.println(parent_node.genXML());
	}
}

interface TagNameVisitor {
	public void accept(ParentXML_Node parentNode);

	public void accept(LeafXML_Node leafNode);

}

class PostfixNameVisitorImpl implements TagNameVisitor {
	@Override
	public void accept(ParentXML_Node parentNode) {
		parentNode.setNodeName(parentNode.getNodeName() + "_MyPostfix(parentNode)");
	}

	@Override
	public void accept(LeafXML_Node leafNode) {
		leafNode.setNodeName(leafNode.getNodeName() + "_MyPostfix(leafNode)");
	}
}

class PrefixNameVisitorImpl implements TagNameVisitor {
	@Override
	public void accept(ParentXML_Node parentNode) {
		parentNode.setNodeName("MyPrefix_(parentNode)" + parentNode.getNodeName());
	}

	@Override
	public void accept(LeafXML_Node leafNode) {
		leafNode.setNodeName("MyPrefix_(parentNode)" + leafNode.getNodeName());
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

	public abstract void accept(TagNameVisitor visitor);

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

	@Override
	public void accept(TagNameVisitor visitor) {
		visitor.accept(this);
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

	@Override
	public void accept(TagNameVisitor visitor) {
		visitor.accept(this);
	}

}
