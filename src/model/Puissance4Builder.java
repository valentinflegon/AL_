package model;

/**
 * Used to create a visual representation of a statement.
 */
public abstract interface Puissance4Builder {
	void createNewPuissance4();
	void addString(String s);
	void finish();
	String getPuissance4();
}
