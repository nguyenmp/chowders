package ninja.mpnguyen.chowders.things;

import java.io.Serializable;

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
public class User implements Serializable {
    // epoch of modification
    public static final long serialVersionUID = 1433365167L;

    public String username;
    public String created_at;
    public boolean is_admin;
    public String about;
    public boolean is_moderator;
    public int karma;
    public String avatar_url;

    public User(User user) {
        username = user.username;
        created_at = user.created_at;
        is_admin = user.is_admin;
        about = user.about;
        is_moderator = user.is_moderator;
        karma = user.karma;
        avatar_url = user.avatar_url;
    }
}
