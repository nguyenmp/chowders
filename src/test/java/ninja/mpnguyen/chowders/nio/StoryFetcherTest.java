package ninja.mpnguyen.chowders.nio;

import ninja.mpnguyen.chowders.things.Story;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoryFetcherTest {
    @Test
    public void testGet() throws Exception {
        String short_id = "n7mpm0";
        Story story = StoryFetcher.get(short_id);
        assertNotNull(story);
        assertEquals(story.short_id, short_id);
    }
}