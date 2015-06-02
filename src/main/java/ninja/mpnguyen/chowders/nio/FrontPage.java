package ninja.mpnguyen.chowders.nio;

import ninja.mpnguyen.chowders.things.Post;

import java.io.IOException;

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
        return new FrontPage(sort).get();
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
