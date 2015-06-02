package ninja.mpnguyen.chowders.nio;

import ninja.mpnguyen.chowders.things.Post;
import org.junit.Test;
import org.junit.Assert;

public class FrontPageTest {
    @Test
    public void testGetHottest() throws Exception {
        Post[] posts = FrontPage.get(FrontPage.Sort.Hottest);
        Assert.assertNotNull(posts);
    }

    @Test
    public void testGetNewest() throws Exception {
        Post[] posts = FrontPage.get(FrontPage.Sort.Newest);
        Assert.assertNotNull(posts);
    }
}
