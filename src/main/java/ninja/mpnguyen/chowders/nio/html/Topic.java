package ninja.mpnguyen.chowders.nio.html;

import ninja.mpnguyen.chowders.parsers.PostsParser;
import ninja.mpnguyen.chowders.things.html.Post;

public class Topic extends GetHtml<Post[]> {

    private final String topic;
    private final int page;

    public Topic(String topic) {
        this(topic, 0);
    }

    public Topic(String topic, int page) {
        this.topic = topic;
        this.page = page;
    }

    @Override
    public String getEndpoint() {
        StringBuilder builder = new StringBuilder();
        if (topic != null) builder.append("t/").append(topic).append("/");
        if (page > 0) builder.append("page/").append(page);
        return builder.toString();
    }

    @Override
    public Parser<Post[]> getParser() {
        return new PostsParser();
    }
}
