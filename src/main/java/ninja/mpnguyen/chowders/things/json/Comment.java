package ninja.mpnguyen.chowders.things.json;

import java.io.Serializable;

/**
    {
        "created_at": "2012-12-23T14:48:17.000-06:00",
        "updated_at": "2012-12-23T14:48:17.000-06:00",
        "short_id": "spkxpv",
        "is_deleted": false,
        "is_moderated": false,
        "score": 2,
        "comment": "<p>What we need are tools to allow us to simultaneously use bitbucket, github, and gitorious (and optionally self-host) at the same time. You know&hellip; since git is distributed, why put up with centralized systems, etc etc. Just need to solve the whole federation of issues thing. As an rstat.us founder, I&rsquo;ve <a rel=\"nofollow\" href=\"http://blog.davewilkinsonii.com/posts/you-want-freedom-build-it\">thought about how to build this a bit</a>.</p>\n",
        "url": "https://lobste.rs/s/mbw0z5/kisom_check_github/comments/spkxpv#c_spkxpv",
        "indent_level": 1,
        "commenting_user": {
            "username": "wilkie",
            "created_at": "2012-09-26T16:43:06.000-05:00",
            "is_admin": false,
            "about": "Founder of rstat.us, systemsy person, writes lots of code, cares about diversity and culture, etc.\r\n\r\n* [blog](http://blog.davewilkinsonii.com)\r\n* [@wilkieii](https://rstat.us/users/wilkieii) - rstat.us\r\n* [@wilkieii](https://twitter.com/wilkieii) - Twitter",
            "is_moderator": false,
            "karma": 145,
            "avatar_url": "https://secure.gravatar.com/avatar/5dbe1716f6b65f3c3c96f82d4f4b1d59?r=pg&d=identicon&s=100"
        }
    }
 */
public class Comment implements Serializable {
    // epoch of modification
    public static final long serialVersionUID = 1433365167L;

    public String created_at;
    public String updated_at;
    public String short_id;
    public boolean is_deleted;
    public boolean is_moderated;
    public int score;
    public String comment;
    public String url;
    public int indent_level;
    public User commenting_user;

    public Comment() {
        // Do nothing
    }

    public Comment(Comment other) {
        created_at = other.created_at;
        updated_at = other.updated_at;
        short_id = other.short_id;
        is_deleted = other.is_deleted;
        is_moderated = other.is_moderated;
        score = other.score;
        comment = other.comment;
        url = other.url;
        indent_level = other.indent_level;
        commenting_user = new User(other.commenting_user);
    }
}
