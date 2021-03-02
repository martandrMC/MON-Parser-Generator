package martandrMC.monpg;

import martandrMC.monpg.elements.MONPrimitive;
import martandrMC.monpg.exceptions.ConstructionException;

public class Entry {

	public static void main(String[] args) throws ConstructionException {
		MONPrimitive prim = new MONPrimitive("lrrli", null);
		System.out.println(prim.getElementMeta());
	}
}
