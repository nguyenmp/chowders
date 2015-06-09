package ninja.mpnguyen.chowders.parsers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ninja.mpnguyen.chowders.nio.html.GetHtml;
import ninja.mpnguyen.chowders.things.html.Post;
import ninja.mpnguyen.chowders.things.html.Tag;

public class PostsParser implements GetHtml.Parser<Post[]>, Serializable {
    public Post[] parse(Element root) {
        Elements es = root.select(".story");

        List<Post> posts = new ArrayList<>(es.size());
        for (Element e : es) {
            Post post = getPost(e);
            posts.add(post);
        }

        return posts.toArray(new Post[posts.size()]);
    }

    public static Post getPost(Element e) {
        Post post = new Post();
        post.short_id = e.attr("data-shortid");
        post.score = Integer.parseInt(e.select(".score").text());

        Element link = e.select(".link").get(0).child(0);
        post.title = link.text();
        post.url = link.attr("href");

        Elements ts = e.select(".tags").get(0).children();
        List<Tag> tags = new ArrayList<>(ts.size());
        for (Element t : ts) {
            tags.add(getTag(t));
        }
        post.tags = tags.toArray(new Tag[tags.size()]);
        post.domain = e.select(".domain").text();
        post.submitter_user = e.select(".byline > a").get(0).text();
        Element timeElement = e.select(".byline > label").get(0);
        post.created_at = timeElement.attr("title");
        post.created_at_human = timeElement.text() + " ago";

        Element commentsElement = e.select(".mobile_comments > a").get(0);
        post.comments_url = commentsElement.attr("href");
        post.comment_count = Integer.parseInt(commentsElement.text().replace(" comments", "").replace(" comment", ""));

        return post;
    }

    public static Tag getTag(Element e) {
        String url = e.attr("href");
        String name = e.text();
        String title = e.attr("title");
        return new Tag(name, url, title);
    }
}
