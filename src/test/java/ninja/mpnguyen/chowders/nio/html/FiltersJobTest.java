package ninja.mpnguyen.chowders.nio.html;

import org.junit.Test;

import ninja.mpnguyen.chowders.nio.Credentials;
import ninja.mpnguyen.chowders.things.html.Auth;
import ninja.mpnguyen.chowders.things.html.Filter;
import ninja.mpnguyen.chowders.things.html.Tag;

import static org.junit.Assert.*;

public class FiltersJobTest {
    @Test
    public void testFiltersJob() throws Exception {
        Filter[] filters = new FiltersJob().call();
        assertNotNull(filters);
        assertNotEquals(0, filters.length);
        for (Filter filter : filters) {
            checkFilter(filter);
        }
    }

    @Test
    public void testAuthedFiltersJob() throws Exception {
        Auth auth = new Login(Credentials.username(), Credentials.password()).call();
        Filter[] filters = new FiltersJob(auth).call();
        assertNotNull(filters);
        assertNotEquals(0, filters.length);
        for (Filter filter : filters) {
            checkFilter(filter);
        }
    }

    private void checkFilter(Filter filter) {
        checkTag(filter.tag);
        assertNotNull(filter.stories);
        assertTrue("Stories are a positive count", filter.stories >= 0);
        assertNotNull(filter.hidden);
    }

    private void checkTag(Tag tag) {
        assertNotNull(tag);
        assertNotNull(tag.name);
        assertNotNull(tag.url);
        assertTrue("Url starts with /t/...", tag.url.startsWith("/t/"));
        assertNotNull(tag.title);
    }
}