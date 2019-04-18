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
		Polyterm pt1 = iter1.next();
		Polyterm pt2 = iter2.next();
		Polynomial output = new Polynomial();
		
		while(pt1 != null & pt2 != null) {
			if(pt1.canAdd(pt2)) {
				output.list.add(pt1.add(pt2));
				if(iter1.hasNext()) pt1 = iter1.next();
				else pt1 = null;
				if(iter2.hasNext()) pt2 = iter2.next();
				else pt2 = null;
			}
			else if(pt1.compareTo(pt2)<0) {
				output.list.add(new Polyterm(pt1));
				if(iter1.hasNext()) pt1 = iter1.next();
				else pt1 = null;
			}
			else {
				output.list.add(new Polyterm(pt2));
				if(iter2.hasNext()) pt2 = iter2.next();
				else pt2 = null;
			}
		}
		while(pt1 != null) {
			output.list.add(new Polyterm(pt1));
			if(iter1.hasNext()) pt1 = iter1.next();
			else pt1 = null;
		}
		while(pt2 != null) {
			output.list.add(new Polyterm(pt2));
			if(iter2.hasNext()) pt2 = iter2.next();
			else pt2 = null;
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
		output = output.simplify();
		return output;
	}
	
	//switch back to brivate
	private Polynomial simplify() {
		
		Polynomial output = new Polynomial();
		Iterator<Polyterm> iter = list.iterator();
		Polyterm sum = iter.next();
		output.list.add(sum);
		
		while( iter.hasNext()) {
		Polyterm curr = iter.next();
		
			if(sum.canAdd(curr)) {
				sum = sum.add(curr);
			}
			else {
				sum = curr;
				output.list.add(sum);
			}		
		}
		return output;
		
		
//		Iterator<Polyterm> iter = list.iterator();
//		Polyterm p1 = iter.next();
//		Polyterm p2 = iter.next();
//		Polyterm toAdd = p1;
//		while(p1.canAdd(p2)) {
//			toAdd = toAdd.add(p2);
//			p2 = iter.next();
//		}
//		newList.add(new Polyterm(toAdd.getCoeff(),toAdd.getExp()));
//		

		
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
				
		//if(output.charAt(0)=='+') output = output.substring(1);
		return output;
	}
	public boolean equals(Polynomial poly) {
		return list.equals(poly.list);
	}

}
