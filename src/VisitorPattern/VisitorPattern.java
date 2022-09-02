package VisitorPattern;

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
