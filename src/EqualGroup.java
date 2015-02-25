import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class EqualGroup {

	public static void main(String[] args) {
		ArrayList<String> peers = new ArrayList<String>();
		ArrayList<String> group1 = new ArrayList<String>();
		ArrayList<String> group2 = new ArrayList<String>();
		ArrayList<String> group3 = new ArrayList<String>();
		
		boolean firstRun = true;
		Scanner in = new Scanner(System.in);
		String groupNumberFromUser;
		int seed = 0;
		
		String userName;
		
		peers.add("savillavicencio"); 
		peers.add("mbichay");
		peers.add( "mariangarcia");
		peers.add("lgarciajimenez");
		peers.add( "mhernandezbucio");
		peers.add("asorto");
		peers.add("jmejiacruz");
		peers.add( "chmartinez");
		peers.add( "jocortez");
		
		
		
		do{
			if(firstRun){
				System.out.print("Enter your group number: ");
				firstRun = false;
			}else{
				System.out.print("Error, Please enter a valid group number: ");
			}
			
			groupNumberFromUser = in.nextLine();
			
		
		}while(!isInteger(groupNumberFromUser));
		
		
		seed = Integer.parseInt(groupNumberFromUser);
		
		Collections.shuffle(peers, new Random(seed));
		
		
		group1.add(peers.get(0));
		group1.add(peers.get(1));
		group1.add(peers.get(2));
		
		group2.add(peers.get(3));
		group2.add(peers.get(4));
		group2.add(peers.get(5));
		
		group3.add(peers.get(6));
		group3.add(peers.get(7));
		group3.add(peers.get(8));
		
		
		firstRun = true;
		do{
			if(firstRun){
				System.out.print("Enter member name: ");
				firstRun = false;
			}else{
				System.out.print("Error, Please enter a valid member name: ");
			}
			
			userName = in.nextLine();
			
		
		}while(!validName(userName));
		
		
		if(group1.contains(userName)){
			print(userName,group1);
		}
		else if(group2.contains(userName)){
			print(userName,group2);
		}
		else{
			print(userName,group3);
		}
		
		
		
	}
	
	public static void print(String user, ArrayList list){
		
		System.out.print("\nYour team members are: ");
		for (int i = 0; i < list.size(); i++) {
			if(!list.get(i).equals(user)){
				System.out.print( list.get(i) + "@csumb.edu" + "  ");
			}
        }
		
	}
	
	public static boolean validName(String usr){
		String[] validNames = {"savillavicencio", "mbichay", "mariangarcia", "lgarciajimenez", " mhernandezbucio", " asorto", "jmejiacruz", " chmartinez", "jocortez"};
		
		usr.toLowerCase();
		
		Pattern r = Pattern.compile(usr);
		Matcher m;
		for(String name : validNames){
			m = r.matcher(name);
			
			if(m.find()){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isInteger(String groupNumberFromUser){
	
		
		Pattern r = Pattern.compile("^\\d+$");
		Matcher m;
		m = r.matcher(groupNumberFromUser);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
		
	}
	

}
