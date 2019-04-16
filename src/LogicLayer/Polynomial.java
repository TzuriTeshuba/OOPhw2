package LogicLayer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class Polynomial {
	
	private Collection<Polyterm>  list;
	
	public Polynomial() {
		this.list = new TreeSet<Polyterm>() ;
	}
	public Polynomial add(Polynomial poly) {
		return null;
	}
	public Polynomial mul(Polynomial poly) {
		return null;
	}
	
	public Scalar evaluate(Scalar scalar) {
		return null;
	}
	
	public Polynomial derivate() {
		return null;
	}
	
	public String toString() {
		return "";
	}
	public boolean equals(Polynomial poly) {
		return true;
	}

}
