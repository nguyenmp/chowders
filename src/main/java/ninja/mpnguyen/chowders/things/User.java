package ninja.mpnguyen.chowders.things;

/**
 {
     "username": "curtis",
     "created_at": "2014-03-09T23:20:54.000-05:00",
     "is_admin": false,
     "about": "[cmcenroe.me](http://cmcenroe.me)",
     "is_moderator": false,
     "karma": 92,
     "avatar_url": "https://secure.gravatar.com/avatar/ca0c9cb798fd7f80444740a4dbaef7b9?r=pg&d=identicon&s=100"
 }
 */
public class User {
    public String username;
    public String created_at;
    public boolean is_admin;
    public String about;
    public boolean is_moderator;
    public int karma;
    public String avatar_url;
}
