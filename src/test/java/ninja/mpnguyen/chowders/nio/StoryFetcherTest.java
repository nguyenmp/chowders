package ninja.mpnguyen.chowders.nio;

import org.junit.Test;

import ninja.mpnguyen.chowders.things.json.Story;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StoryFetcherTest {
    @Test
    public void testGet() throws Exception {
        String short_id = "n7mpm0";
        Story story = ninja.mpnguyen.chowders.nio.json.StoryFetcher.get(short_id);
        assertNotNull(story);
        assertEquals(story.short_id, short_id);
    }
}