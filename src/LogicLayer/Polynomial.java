package LogicLayer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Polyterm>  list;
	
	public Polynomial() {
		this.list = new LinkedList<Polyterm>() ;
	}
	
	public Polynomial(String poly, char field) {
	
		this.list = new LinkedList<Polyterm>() ;
		String pt = "" + poly.charAt(0);
		for(int i = 1 ;i < poly.length() ; i++ ) {			
			if(poly.charAt(i)== '+' |poly.charAt(i)== '-') {
				list.add(new Polyterm(pt , field));
				pt = "";
			}
			pt = pt + poly.charAt(i);

		}	
		list.add(new Polyterm(pt , field));
		Collections.sort(list);
	}
	public Polynomial add(Polynomial poly) {
		Iterator<Polyterm> iter1 = list.iterator();
		Iterator<Polyterm> iter2 = poly.list.iterator();
		Polyterm pt1 = iter1.next();
		Polyterm pt2 = iter2.next();
		Polynomial output = new Polynomial();
		
		while(pt1 != null & pt2 != null) {
			if(pt1.canAdd(pt2)) {
				Polyterm pt3 = pt1.add(pt2);
				if (!pt3.getCoeff().isZero()) {
				output.list.add(pt3);
				}
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
		Collections.sort(output.list);
		return output;
	}
		

	public Polynomial mul(Polynomial poly) {
		Polynomial output = new Polynomial();
		for(Polyterm pt1 : list) {
			for(Polyterm pt2 : poly.list) {
				Polyterm pt3 = pt1.mul(pt2);
				if(!pt3.getCoeff().isZero()){
				output.list.add(pt3);
				}
			}
		}
		if(!output.list.isEmpty()) {
		Collections.sort(output.list);
		output = output.simplify();
		}
		return output;
	}
	
	private Polynomial simplify() {
		if( list.isEmpty()) return this;
		Polynomial output = new Polynomial();
		Iterator<Polyterm> iter = list.iterator();
		Polyterm temp = iter.next();
		Polyterm curr = new Polyterm("0", temp.getCoeff().getField());
		
		while(iter.hasNext()) {
			curr = iter.next();
			if(temp.canAdd(curr)) {
				temp=temp.add(curr);
			}
			else {
				output.list.add(temp);
				temp = curr;				
			}
		}
		output.list.add(curr);
		
		return output;
	
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
			Polyterm pt1 = pt.derivate();
			if(!pt1.getCoeff().isZero()) {
			output.list.add(pt1);
			}
		}
		return output;
	}
	
	public String toString() {
		if (list.isEmpty())return "0";
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
		boolean isEqual = list.size() == poly.list.size();
		for(int i = 0 ;isEqual && i < list.size(); i++) {
			if (!list.get(i).equals(poly.list.get(i)))isEqual = false;
		}
		return isEqual;
	}

}
