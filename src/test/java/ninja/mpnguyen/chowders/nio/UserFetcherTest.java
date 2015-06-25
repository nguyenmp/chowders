package ninja.mpnguyen.chowders.nio;

import org.junit.Test;

import ninja.mpnguyen.chowders.things.json.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserFetcherTest {
    @Test
    public void testGet() throws Exception {
        String username = "markerz";
        User user = new ninja.mpnguyen.chowders.nio.json.UserFetcher(username).call();
        assertNotNull(user);
        assertEquals(user.username, username);
    }
}