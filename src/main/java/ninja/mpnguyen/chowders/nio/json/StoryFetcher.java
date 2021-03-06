package ninja.mpnguyen.chowders.nio.json;

import java.io.IOException;

import ninja.mpnguyen.chowders.things.json.Story;

public final class StoryFetcher extends GetJson<Story> {
    public static Story get(String short_id) throws IOException {
        return new StoryFetcher(short_id).call();
    }

    private final String short_id;
    private StoryFetcher(String short_id) {
        this.short_id = short_id;
    }

    @Override
    public String getEndpoint() {
        return String.format("s/%s.json", short_id);
    }

    @Override
    public Class<Story> getType() {
        return Story.class;
    }
}
