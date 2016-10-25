import java.util.Scanner;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	private Scanner sc;
	private Scanner webpageReader;
	//url name in string
	private String sUrl;
	private URL url;
	public Main(){
		//user input
		sc = new Scanner(System.in);
	}
	public String readUserInput(){
		return sc.nextLine();
	}
	public void options() throws IOException{
		System.out.println("1. Edit a web page");
		System.out.println("2. Editing report");
		System.out.println("3. Exit application");
		System.out.println("Please enter 1,2 or 3");
		String answer = sc.nextLine();
		if(isInt(answer)){
			switch(answer){
			case "1":
				askURL();
			case "2":
				//editing report
			case "3":
				System.exit(-1);
			default:
				System.err.println("Error");
				options();
			}
		}
	}
	public boolean isInt(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	public void askURL() throws IOException{
		System.out.println("Enter URL to edit");
		try{
			sUrl = sc.nextLine();
		}
		catch(Exception e){
			System.err.println("Error, please enter URL again");
			System.out.println("test1");
			askURL();
		}
		if(testURL(sUrl)){
			readTitle(sUrl);
			//next part of program
		}
		else{
			System.out.println("test2");
			askURL();
		}
		
	}
	public int urlExists(String s) throws IOException, MalformedURLException{
		URL url = new URL(s);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET"); 
		huc.connect(); 
		return huc.getResponseCode();
	}
	public void readTitle(String s){
		URL url = new URL(s);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		webpageReader = new 
	}
	public boolean testURL(String s) throws IOException{
		if(urlExists(s)==404){
			return false;
		}
		else{
			return true;
		}
		
		
		
	}
    public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.options();
	// write your code here
    
    }
}
