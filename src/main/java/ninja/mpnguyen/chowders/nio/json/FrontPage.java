package ninja.mpnguyen.chowders.nio.json;

import java.io.IOException;

import ninja.mpnguyen.chowders.things.json.Post;

public final class FrontPage extends GetJson<Post[]> {
    public enum Sort {
        Hottest("hottest.json"), Newest("newest.json");

        private final String endpoint;
        Sort(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getEndpoint() {
            return endpoint;
        }
    }

    public static Post[] get(Sort sort) throws IOException {
        return new FrontPage(sort).call();
    }

    private final Sort sort;
    private FrontPage(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String getEndpoint() {
        return sort.getEndpoint();
    }

    @Override
    public Class<Post[]> getType() {
        return Post[].class;
    }


}
