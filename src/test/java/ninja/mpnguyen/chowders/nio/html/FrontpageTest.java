package ninja.mpnguyen.chowders.nio.html;

import org.junit.Test;

import ninja.mpnguyen.chowders.things.html.Post;

import static org.junit.Assert.*;

public class FrontpageTest {
    @Test
    public void testFrontpage() throws Exception {
        Post[] posts = new Frontpage().get();
        assertNotNull(posts);
    }
}