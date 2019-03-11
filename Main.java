
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("post.txt", true)));
		String sentence = "";
		String accessToken = "EAAFezIk9N3oBAHPSGZCYKnl05FDZBW0EZCIFyk3tedmR0UhsZBt4EBA3VBlaOWfpWSoPxXBIxsTdnhcjzHXN9SGndI3ZCSZAKKQv632aCkKtpHkFGVdfnumBojJ2LMNq3jXhtWSaONh52OQssxoAGkatfW3eSEGfHfc9KJcTLo1BtfDvbwXznr5MEqNPH9zvsZD";

		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		int counter = 0;
		
		//Retrieving the post from facebook and writing it you writer 
		for (List<Post> page : result) {
			
			for(Post aPost : page) {
				sentence = aPost.getMessage();
				System.out.println(sentence);
				if (sentence != null /*&& sentence.contains("I")*/) {
					writer.println(sentence);
					counter++;
					
				}	
			}
		}
		System.out.println("No of Post Displayed " +counter);
		writer.close();
		
		
		
		System.out.println("Stop Word ");
		StopWords stop = new StopWords();
		stop.remove();
		
		System.out.println(" ");
		nonaplhawords("curl -d name=john --data-urlencode passwd=@31&3*J https://www.mysite.com" );
				
	}
	// Takes in String and remove the non aplha word 
	private static void nonaplhawords(String string) {
		try {
			Scanner fip1=new Scanner(new File("removedstopwords.txt"));
			FileOutputStream out=new FileOutputStream("non words.txt");
			PrintStream p=new PrintStream(out);
			
			while(fip1.hasNext()) {
				int flag=1;
				String s1=fip1.next();
				String text = s1; 
				text = text.replaceAll("[^a-zA-Z\\s+]", "");
				p.println(text); 
				
			
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		
	
		
	}	

}


