import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/*

A simple Facebook4J client which
illustrates how to access group feeds / posts / comments.
@param args
@throws FacebookException
*/
public static void main(String[] args) throws FacebookException {

 // Generate facebook instance.
Facebook facebook = new FacebookFactory().getInstance();
// Use default values for oauth app id.
facebook.setOAuthAppId("hcinates88@gmail.com", "portnoy88");
// Get an access token from:
// https://developers.facebook.com/tools/explorer
// Copy and paste it below.
String accessTokenString = "EAAiKwu5JZC9EBAPdShQkkE9DiPfPpC8HcvvWBaofRWsGj3rcnHZCakE8HVdKB5iiGGRrBmvJRbgStn9ZAJnPaUVMeo9n8pMvV3s6CvGsf5jWlhYcXWI4hY77F3eH6afLhCJ0BL4oZAdozZCPZAFo0tl1ZBguzA8eby5ZBOyTO3HuiDAnInR7H7Nm8F0ZBVkMX2cQ5Ozla7cF6mA50AYVh5tjF";
AccessToken at = new AccessToken(accessTokenString);
// Set access token.
facebook.setOAuthAccessToken(at);

 // We're done.
// Access group feeds.
// You can get the group ID from:
// https://developers.facebook.com/tools/explorer

 // Set limit to 25 feeds.

 ResponseList< Post >  feeds = facebook.getFeed("115829583020386",
            new Reading().limit(25));
        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);
            PagableList comments = post.getComments();
            String date = post.getCreatedTime().toString();
           // String name = post.getFrom().getName();
            String id = post.getId();
             System.out.println(date);
             System.out.println(id);
        }
   }
 }
