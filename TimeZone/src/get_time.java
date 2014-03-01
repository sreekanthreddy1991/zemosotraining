
import java.util.Arrays;
import java.util.TimeZone;

public class get_time {

	public static void main(String[] args) {
		int i;
		String[] tz = TimeZone.getAvailableIDs();
		String time = args[0];
		int time_1; //contains time converted to minutes
		Arrays.sort(tz);
		time = time.replace(".","");
		if(time.contains("a")||time.contains("p")){
			//12 hour format,convert it to 24 hour format;
			if(time.contains("a")){
				int index = time.indexOf("a");
				if(index == 1){
					time_1 = 60*(int)time.charAt(0);
				}
				else if(index==2){
					time_1 = 600*(int)time.charAt(0) + 60*(int)time.charAt(1);
				}
				else if(index==3){
					time_1 = 60*(int)time.charAt(0) + 10*(int)time.charAt(1)+ (int)time.charAt(2);
				}
				else{
					time_1 = 600*(int)time.charAt(0) + 60*(int)time.charAt(1)+10*(int)time.charAt(2)+ (int)time.charAt(3);
				}
				
				
			}
			else{
				int index = time.indexOf("p");
				if(index == 1){
					time_1 = 60*Character.getNumericValue(time.charAt(0));
				}
				else if(index==2){
					time_1 = 600*Character.getNumericValue(time.charAt(0)) + 60*Character.getNumericValue(time.charAt(1));
				}
				else if(index==3){
					time_1 = 60*Character.getNumericValue(time.charAt(0))+ 10*Character.getNumericValue(time.charAt(1))+ Character.getNumericValue(time.charAt(2));
				}
				else{
					time_1 = 600*Character.getNumericValue(time.charAt(0)) + 60*Character.getNumericValue(time.charAt(1))+10*Character.getNumericValue(time.charAt(2))+ Character.getNumericValue(time.charAt(3));
				}
				
				time_1 += 720; // adding 12 hrs for pm
			}
		}
		else{
			//24 hour format
			if(time.length()==3){
				time_1 = 60*Character.getNumericValue(time.charAt(0)) + 10*Character.getNumericValue(time.charAt(1))+ Character.getNumericValue(time.charAt(2));
			}
			else{
				time_1 = 600*Character.getNumericValue(time.charAt(0)) + 60*Character.getNumericValue(time.charAt(1))+10*Character.getNumericValue(time.charAt(2))+ Character.getNumericValue(time.charAt(3));
			}
		}
		
		//Now Parse second String to get appropriate time zone

		String[] time_z;
		time_z = TimeZone.getAvailableIDs();
		String place = args[1];
		place = place.replaceAll("\\s","_");
		
		String Zone = null;
		for(i=0;i<time_z.length;i++){
			//System.out.println(time_z[i]);
			if(time_z[i].contains(place)){
				Zone = time_z[i];
				break;
			}
		}
		if(i == time_z.length){
			System.out.println("Not sure where that is!!");
			return;
		}
		TimeZone default_tz = TimeZone.getDefault();
		int offset = default_tz.getRawOffset();
		TimeZone new_tz = TimeZone.getTimeZone(Zone);
		int offset2 = new_tz.getRawOffset();
		
		
		int add = (offset2-offset)/(1000*60);
		if(24*60 - time_1 < add){
			time_1 = (add-24*60 + time_1);
		}
		else if(time_1+add<0){
			time_1 = add+time_1+24*60;
		}
		else{
		time_1 += add;
		}
		int h = time_1/60;
		int m = time_1 - 60*h;
		String Ses;
		if(h>12){
			h -= 12;
			Ses= "pm";
		}
		else{
			Ses = "am";
		}
		System.out.format("%d.%02d%s ", h, m, Ses);
		System.out.println(new_tz.getDisplayName(false,TimeZone.SHORT));
		//System.out.println(add);
		
	}

}
