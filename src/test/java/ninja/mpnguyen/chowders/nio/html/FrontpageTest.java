package ninja.mpnguyen.chowders.nio.html;

import org.junit.Test;

import ninja.mpnguyen.chowders.nio.html.Frontpage.Category;
import ninja.mpnguyen.chowders.things.html.Post;

import static org.junit.Assert.assertNotNull;

public class FrontpageTest {
    @Test
    public void testFrontpageHot() throws Exception {
        Post[] posts = new Frontpage(Category.Hot).call();
        assertNotNull(posts);
    }
    @Test
    public void testFrontpageNewest() throws Exception {
        Post[] posts = new Frontpage(Category.Newest).call();
        assertNotNull(posts);
    }
    @Test
    public void testFrontpageRecent() throws Exception {
        Post[] posts = new Frontpage(Category.Recent).call();
        assertNotNull(posts);
    }
}