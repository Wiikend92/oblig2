package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Singleton {

	private static Singleton single_instance = null;
	List<String> varer = Collections.synchronizedList(new ArrayList<String>());

	public synchronized static Singleton getInstance() {
		if (single_instance == null) {
			single_instance = new Singleton();
		}
		return single_instance;
	}

	public void addItem(String item) {
		varer.add(item);
	}

	public void deleteItem(String item) {
		varer.remove(item);
	}

	public List<String> getVarer() {
		return varer;
	}

}
