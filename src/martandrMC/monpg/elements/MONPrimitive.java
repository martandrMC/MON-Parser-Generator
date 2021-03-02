package martandrMC.monpg.elements;

import martandrMC.monpg.exceptions.ConstructionException;

public class MONPrimitive implements MONElement {
	
	/* Types:
	 * Bb: Byte Bitfield
	 * Bc: Byte Char
	 * Bh: Byte Hex
	 * 
	 * Id: Int Decimal (Signed)
	 * Ih: Int Hex
	 * 
	 * Ld: Long Decimal (Signed)
	 * Lh: Long Hex
	 * 
	 * T: Boolean
	 * S: String
	 * N: Null
	 * F: Float
	 * D: Double
	 */
	
	private String type, name;
	private long int_vals; // Byte, Int, Long, Bool
	private double real_vals; // Float, Double
	private String str_vals; // String, Null
	
	public MONPrimitive(String name, long value, String exact_type) throws ConstructionException {
		checkType(exact_type, 0);
		this.name = name;
		type = exact_type;
		int_vals = value;
	}
	
	public MONPrimitive(String name, double value, String exact_type) throws ConstructionException {
		checkType(exact_type, 1);
		this.name = name;
		type = exact_type;
		real_vals = value;
	}
	
	public MONPrimitive(String name, String value) throws ConstructionException {
		this.name = name;
		type = value == null?"N":"S";
		str_vals = value;
	}
	
	private void checkType(String type, int category) throws ConstructionException {
		String[][] valid_types = {{"Bb","Bc","Bh","Id","Ih","Ld","Lh", "T"}, {"F", "D"}};
		boolean type_valid = false;
		for(String s : valid_types[category]) if(type.equals(s)) {
			type_valid = true;
			return;
		}
		if(!type_valid) throw new ConstructionException();
	}
	
	@Override
	public String getElementData() {
		String conv, out = "";
		switch(type) {
			case "Bb":
				conv = Long.toBinaryString(int_vals&0xff);
				for(int i=0; i<8-conv.length(); i++) out += "0";
				out += conv;
				return  out + "b";
			case "Bh":
				conv = Long.toHexString(int_vals&0xff);
				if(conv.length() == 1) out += "0";
				out += conv;
				return out.toUpperCase() + "h";
			case "Bc": return "\'" + String.valueOf((char)(int_vals&0xff)) + "\'";
			case "Id": return String.valueOf((int)int_vals);
			case "Ih":
				conv = Integer.toHexString((int)int_vals);
				for(int i=0; i<8-conv.length(); i++) out += "0";
				out += conv;
				return  out.toUpperCase() + "h";
			case "Ld": return String.valueOf(int_vals);
			case "Lh":
				conv = Long.toHexString(int_vals);
				for(int i=0; i<16-conv.length(); i++) out += "0";
				out += conv;
				return  out.toUpperCase() + "h";
			case "T": return int_vals==0?"false":"true";
			case "F": return String.valueOf((float) real_vals) + "f";
			case "D": return String.valueOf(real_vals) + "d";
			case "S": return "\"" + str_vals + "\"";
			default: return "null";
		}
	}
	@Override
	public String getElementMeta() {return type.charAt(0)+"\""+name+"\"";}
	@Override
	public String getElementType() {return "p"+type;}
	@Override
	public String getElementName() {return name;}

}
