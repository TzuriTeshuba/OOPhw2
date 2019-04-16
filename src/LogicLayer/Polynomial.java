package LogicLayer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class Polynomial {
	
	private Collection<Polyterm>  list;
	
	public Polynomial(String poly, char field) {
		this.list = new TreeSet<Polyterm>() ;
		String pt = "";
		for(int i = 0 ;i < poly.length() ; i++ ) {			
			if(poly.charAt(i)== '+' |poly.charAt(i)== '-') {
				list.add(new Polyterm(pt , field));
				pt = "";
			}
			pt = pt + poly.charAt(i);

		}		

		
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
