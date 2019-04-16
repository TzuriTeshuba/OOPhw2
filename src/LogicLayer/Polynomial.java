package LogicLayer;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Polynomial {
	
	private Collection<Polyterm>  list;
	
	public Polynomial() {
		this.list = new TreeSet<Polyterm>() ;
	}
	
	public Polynomial(String poly, char field) {
	
		this.list = new TreeSet<Polyterm>() ;
		String pt = "" + poly.charAt(0);
		for(int i = 1 ;i < poly.length() ; i++ ) {			
			if(poly.charAt(i)== '+' |poly.charAt(i)== '-') {
				list.add(new Polyterm(pt , field));
				pt = "";
			}
			pt = pt + poly.charAt(i);

		}	
		list.add(new Polyterm(pt , field));		
	}
	public Polynomial add(Polynomial poly) {
		Iterator<Polyterm> iter1 = list.iterator();
		Iterator<Polyterm> iter2 = poly.list.iterator();
		Polynomial output = new Polynomial();

		while (iter1.hasNext()  | iter2.hasNext()) {
			if(iter1.hasNext()==iter2.hasNext()) {
				Polyterm pt1 = iter1.next();
				Polyterm pt2 = iter2.next();
				if(pt1.canAdd(pt2)) {
					output.list.add(pt1.add(pt2));
					pt1 = iter1.next();
					pt2 = iter2.next();
				}
				else if(pt1.compareTo(pt2)<0) {
					output.list.add(pt1);
					pt1 = iter1.next();
				}
				else {
					output.list.add(pt2);
					pt2 = iter2.next();
				}
		
			}
			else if(iter1.hasNext()) {
				while(iter1.hasNext()) {
					output.list.add(iter1.next());
				}
			}
			else {
				while(iter2.hasNext()) {
					output.list.add(iter2.next());
				}
			}			
		}
		
		
		return output;
			
		}
		

	public Polynomial mul(Polynomial poly) {
		Polynomial output = new Polynomial();
		for(Polyterm pt1 : list) {
			for(Polyterm pt2 : poly.list) {
				output.list.add(pt1.mul(pt2));
			}
		}
		output.simplify();
		return output;
	}
	
	private void simplify() {
		Iterator<Polyterm> iter = list.iterator();
		Polyterm p1 = iter.next();
		Polyterm p2 = iter.next();
		Polyterm toAdd = p1;
		while(p1.canAdd(p2)) {
			toAdd = toAdd.add(p2);
			p2 = iter.next();
		}
		newList.add(new Polyterm(toAdd.getCoeff(),toAdd.getExp()))
		

		
	}
	
	public Scalar evaluate(Scalar scalar) {
		Scalar output = scalar.mul(0);
		for(Polyterm pt : list) {
			output = output.add(pt.evaluate(scalar));
		}
		return output;
		}
	
	public Polynomial derivate() {
		Polynomial output = new Polynomial();
		for(Polyterm pt : list) {
			output.list.add(pt.derivate());
		}
		return output;
	}
	
	public String toString() {
		String output = "";
				for(Polyterm pt : list) {
					if (pt.isPostive())
					output = output + "+" +  pt;
					else output = output  + pt;
				}
				if(output.charAt(0)== '+')
					output = output.substring(1);
		return output;
	}
	public boolean equals(Polynomial poly) {
		return list.equals(poly.list);
	}

}
