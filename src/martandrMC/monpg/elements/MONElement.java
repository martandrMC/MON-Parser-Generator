package martandrMC.monpg.elements;

public interface MONElement {
	
	/**
	 * Serializes the element recursively according to MON syntax.
	 * @return A string containing the serialized element along with its ContentMetaString.
	 */
	public String getDataString();
	/**
	 * Generates a string containing the type and name of the element.
	 * @return A string used in the assembly of the ContentMetaString of its parent element.
	 */
	public String getSelfMetaString();
	/**
	 * Generates a string containing the length of the element and the SelfMetaStrings of all the child elements.
	 * @return A string containing all SelfMetaStrings of child elements surrounded by triangle brackets and separated by semicolons.
	 */
	public String getContentMetaString();
}
