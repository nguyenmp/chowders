package ninja.mpnguyen.chowders.nio;

import org.junit.Test;

import ninja.mpnguyen.chowders.things.Story;
import ninja.mpnguyen.chowders.things.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserFetcherTest {
    @Test
    public void testGet() throws Exception {
        String username = "markerz";
        User user = new UserFetcher(username).get();
        assertNotNull(user);
        assertEquals(user.username, username);
    }
}