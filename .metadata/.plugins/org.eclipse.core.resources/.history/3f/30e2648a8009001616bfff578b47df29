import java.util.ArrayList;
import java.util.Iterator;

public class Clothing {

	boolean pattern;
	ArrayList<HSLColor> colors = new ArrayList<HSLColor>();
	ArrayList<Float> primaryHues = new ArrayList<Float>();
	boolean selected;
	ColorScheme scheme;
	
	public Clothing(){
		pattern = false;
		colors.add(new HSLColor(206,98,36));
		colors.add(new HSLColor(219,95,17));
		colors.add(new HSLColor(216,42,68));
		colors.add(new HSLColor(15,26,51));
		colors.add(new HSLColor(15, 40, 22));
		colors.add(new HSLColor(23,64,51));
		colors.add(new HSLColor(37,53,26));
		colors.add(new HSLColor(11,25,50));
		scheme = findScheme();
		findPrimaryHues();
	}
	
	private void findPrimaryHues(){
		for(HSLColor color : colors){
			boolean add = true;
			for(Float hue : primaryHues){
				if(color.getDegreesBetween(hue) <= 15){
					add = false;
				}
			}
			if(add){
				primaryHues.add((Float) color.getHue());
			}
			else{
					add = true;
			}
		}
	}
	
	private ColorScheme findScheme(){
		return ColorScheme.findScheme(colors.get(0), colors.get(3));
	}
	
	public ColorScheme getScheme(){
		return scheme;
	}
}
