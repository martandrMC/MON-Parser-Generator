package martandrMC.monpg;

import martandrMC.monpg.elements.MONObject;
import martandrMC.monpg.elements.MONPrimitive;
import martandrMC.monpg.exceptions.ConstructionException;

public class Entry {

	public static void main(String[] args) throws ConstructionException {
		MONObject obj = new MONObject("lrrli");
		obj.addChild(new MONPrimitive("", 69420, "Id"));
		obj.addChild(new MONObject("lrrli").addChild(new MONPrimitive("", "fasolada")).addChild(new MONPrimitive("", 42069, "Ih")));
		System.out.println(obj.getDataString());
	}
}
