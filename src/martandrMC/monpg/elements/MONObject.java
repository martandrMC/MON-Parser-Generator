package martandrMC.monpg.elements;

import java.util.ArrayList;

public class MONObject implements MONElement {
	
	private ArrayList<MONPrimitive> primitive_children = new ArrayList<>();
	private ArrayList<MONElement> structured_children = new ArrayList<>();
	private String name;
	
	public MONObject(String name) {
		this.name = name;
	}
	
	public MONObject addChild(MONElement element) {
		char firstchar = element.getSelfMetaString().charAt(0);
		if(firstchar == 'O' || firstchar == 'A') structured_children.add(element);
		else primitive_children.add((MONPrimitive)element);
		return this;
	}
	
	@Override
	public String getDataString() {
		if(structured_children.size() == 0) {
			String result = "";
			for(MONPrimitive p : primitive_children) result += p.getDataString() + ", ";
			result = result.substring(0, result.length()-2);
			return result.length() == 1 ? "{}" : "{" + result + "}";
		}else {
			String result = "\t";
			for(MONPrimitive p : primitive_children) result += p.getDataString() + ", ";
			result = result.substring(0, result.length()-1) + "\n";
			for(MONElement e : structured_children) result += e.getDataString();
			return this.getContentMetaString() + (result.length() == 1 ? "{}" : "{\n" + result.replaceAll("\n", "\n\t") + "\n}");
		}
	}
	
	@Override
	public String getContentMetaString() {	
		return "";
	}
	
	@Override
	public String getSelfMetaString() {return "O\"" + name + "\"";}
}
