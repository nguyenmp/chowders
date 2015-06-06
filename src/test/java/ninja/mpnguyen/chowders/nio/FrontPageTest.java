package ninja.mpnguyen.chowders.nio;

import org.junit.Assert;
import org.junit.Test;

import ninja.mpnguyen.chowders.things.json.Post;

public class FrontPageTest {
    @Test
    public void testGetHottest() throws Exception {
        Post[] posts = ninja.mpnguyen.chowders.nio.json.FrontPage.get(ninja.mpnguyen.chowders.nio.json.FrontPage.Sort.Hottest);
        Assert.assertNotNull(posts);
    }

    @Test
    public void testGetNewest() throws Exception {
        Post[] posts = ninja.mpnguyen.chowders.nio.json.FrontPage.get(ninja.mpnguyen.chowders.nio.json.FrontPage.Sort.Newest);
        Assert.assertNotNull(posts);
    }
}
