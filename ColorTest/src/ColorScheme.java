import java.util.ArrayList;

public class ColorScheme {
	int numberColors;
	int degreesBetweenHues;
	String name;
	float[] primaryHues = new float[4];
	
	public ColorScheme(){
	}
	
	public ColorScheme(String name, ArrayList<HSLColor> colors){
		if(name.equals("Complementary")){
			int numberColors = 2;
			int degreesBetweenHues = 180;
			this.name = name;
			//this needs to be changed. Simple implementation for now
			primaryHues[0] = colors.get(0).getHue();
			primaryHues[1] = colors.get(1).getHue();
		}
	}
	
	public static ColorScheme findScheme(HSLColor color1, HSLColor color2){
		if(color1.getDegreesBetween(color2) >= 165){
			ArrayList a = new ArrayList<HSLColor>();
			a.add(color1);
			a.add(color2);
			ColorScheme ret = new ColorScheme("Complementary", a);
			return ret;
		}
		else return new ColorScheme();
	}
	
	public String getName(){
		return name;
	}
}
