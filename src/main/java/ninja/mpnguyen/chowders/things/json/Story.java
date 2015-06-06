package ninja.mpnguyen.chowders.things.json;

import java.io.Serializable;

/**
 {
     "created_at": "2012-12-22T22:15:29.000-06:00",
     "url": "https://bitbucket.org/kisom/check_github",
     "title": "kisom / check_github",
     "short_id": "mbw0z5",
     "score": 3,
     "comment_count": 4,
     "description": "<p>Want to check if Github is still down? I wrote a command line program that polls Github while it&rsquo;s down to see if it&rsquo;s back up. It uses the &ldquo;say&rdquo; program (a festival-based variant is in the documentation) to speak the status (which can be muted).</p>\n",
     "comments_url": "https://lobste.rs/s/mbw0z5/kisom_check_github",
     "submitter_user": {
         "username": "kyle",
         "created_at": "2012-07-02T14:30:57.000-05:00",
         "is_admin": false,
         "about": "[Homepage](http://www.kyleisom.net), [App.net](https://app.net/kyleisom), and [twitter](https://www.twitter.com/kyleisom).\r\nSystems engineer with a focus on cryptographic systems at scale at [CloudFlare](https://cloudflare.com/).",
         "is_moderator": true,
         "karma": 4541,
         "avatar_url": "https://secure.gravatar.com/avatar/ff0631797f86b033c4a597bebf8192a7?r=pg&d=identicon&s=100"
     },
     "tags": [
         "go",
         "show"
     ],
     "comments": [
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
         },
         {
             "created_at": "2012-12-23T15:00:41.000-06:00",
             "updated_at": "2012-12-23T15:00:41.000-06:00",
             "short_id": "t1u1ql",
             "is_deleted": false,
             "is_moderated": false,
             "score": 1,
             "comment": "<p>I am up for figuring this problem, it&rsquo;s something I&rsquo;ve thought about (and &ldquo;faked&rdquo; with multiple remotes). What would it take to build this kind of tool?</p>\n",
             "url": "https://lobste.rs/s/mbw0z5/kisom_check_github/comments/t1u1ql#c_t1u1ql",
             "indent_level": 2,
             "commenting_user": {
                 "username": "kyle",
                 "created_at": "2012-07-02T14:30:57.000-05:00",
                 "is_admin": false,
                 "about": "[Homepage](http://www.kyleisom.net), [App.net](https://app.net/kyleisom), and [twitter](https://www.twitter.com/kyleisom).\r\nSystems engineer with a focus on cryptographic systems at scale at [CloudFlare](https://cloudflare.com/).",
                 "is_moderator": true,
                 "karma": 4541,
                 "avatar_url": "https://secure.gravatar.com/avatar/ff0631797f86b033c4a597bebf8192a7?r=pg&d=identicon&s=100"
             }
         },
         {
             "created_at": "2012-12-23T18:15:38.000-06:00",
             "updated_at": "2012-12-23T18:15:38.000-06:00",
             "short_id": "rurrzs",
             "is_deleted": false,
             "is_moderated": false,
             "score": 1,
             "comment": "<p>Instead of devising an autonomous system immediately, like I describe doing, a stepping-stone solution would just be some sort of interface and server that will periodically use site apis to look at what has changed and duplicate it on the other sites. Requires some hardcoding and potentially fragile strings with regard to api changes. You can easily just force push the repos up to the other sites to duplicate them (yay for git already doing the work) but issues require some conflict management (that&rsquo;s the hard part) and that isn&rsquo;t trivial because it requires clock synchronization (which is <a rel=\"nofollow\" href=\"http://en.wikipedia.org/wiki/Two_Generals%27_Problem\">not computable</a>) in order to allow users to comment on whichever site they want and keep ordering.</p>\n\n<p><a rel=\"nofollow\" href=\"http://www.fossil-scm.org/index.html/doc/trunk/www/index.wiki\">Fossil</a> thinks the solution is to bake in the issues as blessed metadata in the scm directly. I disagree believing this is a service issue given I prefer modularity that git stresses. Build the system that mitigates the consistency issues and allows for flexibility, it will already be useful&hellip; and then you can bake it into web services later (namely <a rel=\"nofollow\" href=\"http://gitlabhq.com/\">gitlab</a>) and it will then become federated and self-hostable.</p>\n\n<p>The initial goal is clear: No need to worry about github going down&hellip; the system will repair after it comes back up. No reason it can&rsquo;t also work for mercurial, etc.</p>\n",
             "url": "https://lobste.rs/s/mbw0z5/kisom_check_github/comments/rurrzs#c_rurrzs",
             "indent_level": 3,
             "commenting_user": {
                 "username": "wilkie",
                 "created_at": "2012-09-26T16:43:06.000-05:00",
                 "is_admin": false,
                 "about": "Founder of rstat.us, systemsy person, writes lots of code, cares about diversity and culture, etc.\r\n\r\n* [blog](http://blog.davewilkinsonii.com)\r\n* [@wilkieii](https://rstat.us/users/wilkieii) - rstat.us\r\n* [@wilkieii](https://twitter.com/wilkieii) - Twitter",
                 "is_moderator": false,
                 "karma": 145,
                 "avatar_url": "https://secure.gravatar.com/avatar/5dbe1716f6b65f3c3c96f82d4f4b1d59?r=pg&d=identicon&s=100"
             }
         },
         {
             "created_at": "2012-12-23T08:07:28.000-06:00",
             "updated_at": "2012-12-23T08:07:28.000-06:00",
             "short_id": "re6uat",
             "is_deleted": false,
             "is_moderated": false,
             "score": 1,
             "comment": "<p>Waiting for check_&ldquo;kisom/check_github&rdquo;.</p>\n",
             "url": "https://lobste.rs/s/mbw0z5/kisom_check_github/comments/re6uat#c_re6uat",
             "indent_level": 1,
             "commenting_user": {
                 "username": "af",
                 "created_at": "2012-12-08T11:16:27.000-06:00",
                 "is_admin": false,
                 "about": "graduate student @ GT.\r\n[resume](https://github.com/alexandr-fonari/Main/blob/master/Resume.md)",
                 "is_moderator": false,
                 "karma": 11,
                 "avatar_url": "https://secure.gravatar.com/avatar/bed789c91d6b23181f519b2d5fd2c724?r=pg&d=identicon&s=100"
             }
         }
     ]
 }
 */
public class Story extends ninja.mpnguyen.chowders.things.json.Post implements Serializable {
    // epoch of modification
    public static final long serialVersionUID = 1433365167L;

    public Comment[] comments;

    public Story(ninja.mpnguyen.chowders.things.json.Post post) {
        super(post);
        comments = null;
    }

    public Story(Story story) {
        super(story);
        comments = story.comments;
    }
}
