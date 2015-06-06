package ninja.mpnguyen.chowders.things.json;

import java.io.Serializable;

/**
    {
        "created_at": "2015-06-01T10:54:48.000-05:00",
        "url": "https://cmcenroe.me/2015/05/31/chromebook-vpn.html",
        "title": "Chromebook as a Thin Client for Development",
        "short_id": "n7mpm0",
        "score": 13,
        "comment_count": 16,
        "description": "",
        "comments_url": "https://lobste.rs/s/n7mpm0/chromebook_as_a_thin_client_for_development",
        "submitter_user": {
            "username": "curtis",
            "created_at": "2014-03-09T23:20:54.000-05:00",
            "is_admin": false,
            "about": "[cmcenroe.me](http://cmcenroe.me)",
            "is_moderator": false,
            "karma": 92,
            "avatar_url": "https://secure.gravatar.com/avatar/ca0c9cb798fd7f80444740a4dbaef7b9?r=pg&d=identicon&s=100"
        },
        "tags": [
            "show"
        ]
    }
 */
public class Post implements Serializable {
    // epoch of modification
    public static final long serialVersionUID = 1433365167L;

    public String created_at;
    public String url;
    public String title;
    public String short_id;
    public int score;
    public int comment_count;
    public String description;
    public String comments_url;
    public User submitter_user;
    public String[] tags;

    public Post() {
        // Do nothing
    }

    public Post(Post post) {
        created_at = post.created_at;
        url = post.url;
        title = post.title;
        short_id = post.short_id;
        score = post.score;
        comment_count = post.comment_count;
        description = post.description;
        comments_url = post.comments_url;
        submitter_user = new User(post.submitter_user);
        tags = post.tags;
    }
}
