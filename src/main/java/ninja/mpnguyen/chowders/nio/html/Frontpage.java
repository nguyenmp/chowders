package ninja.mpnguyen.chowders.nio.html;

import ninja.mpnguyen.chowders.parsers.PostsParser;
import ninja.mpnguyen.chowders.things.html.Post;

public class Frontpage extends GetHtml<Post[]> {
    public enum Category {
        Recent("recent"), Newest("newest"), Hot("");

        private final String terminal;

        Category(String terminal) {
            this.terminal = terminal;
        }
    }

    private final Category category;

    public Frontpage(Category category) {
        this.category = category;
    }

    @Override
    public String getEndpoint() {
        return category.terminal;
    }

    @Override
    public Parser<Post[]> getParser() {
        return new PostsParser();
    }
}
