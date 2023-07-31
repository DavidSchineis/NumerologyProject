public class Numerology extends Object{
	
	public int month, day, year, result = 0;
	public String prediction = null;
	
	public Numerology(int month, int day, int year, int result) {
		
		this.month = month;
		this.day = day;
		this.year = year;
		this.result = result;
		
		switch(result) {
		case 1:
			this.prediction = "You will live to see man-made horrors beyond your comprehension";
			break;
		case 2:
			this.prediction = "Your skin will be turned into shoes worn by alligators";
			break;
		case 3:
			this.prediction = "The Jags will make the super bowl";
			break;
		case 4:
			this.prediction = "Your milk will expire today";
			break;
		case 5:
			this.prediction = "A space monkey will consume the earth";
			break;
		case 6:
			this.prediction = "The black sphynx will rise at dawn";
			break;
		case 7:
			this.prediction = "You will have an epic and awesome day";
			break;
		case 8:
			this.prediction = "You will encounter a villainous threat today";
			break;
		case 9:
			this.prediction = "The mammoth will break his chains and reclaim the throne of Hyperborea";
			break;
		default:
			this.prediction = "Error: Something went wrong";
			break;
		}
	
	}
	
	public String makeString(Numerology n) {
		String s;
		
		s = n.month+"/"+n.day+"/"+n.year+" "+n.prediction;
		
		return s;
	}
	


}
