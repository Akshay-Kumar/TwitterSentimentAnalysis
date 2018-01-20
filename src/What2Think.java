import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class What2Think {

	public static void main(String[] args) {
		int maxSentiment=0;
		int senti=0;
		String highTweet="";
		String tw="";
		String topic = "MS Dhoni";
		ArrayList<String> tweets = TweetManager.getTweets(topic);
		NLP.init();
		for(String tweet : tweets) {
			System.out.println((tw=tweet) + " : " + (senti=NLP.findSentiment(tweet)));
			
			if(senti>maxSentiment){
				maxSentiment = senti;
				highTweet=tw;
			}
		}
		System.out.println("Top Sentiment Tweet : " + highTweet + " : " + maxSentiment);
		writeTweetsToFile("Top Sentiment Tweet : " + highTweet + " : " + maxSentiment);
	}
	public static void writeTweetsToFile(String tweet){
		try(FileWriter fw = new FileWriter("Tweets.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(tweet);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
}