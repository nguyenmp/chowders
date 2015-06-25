package ninja.mpnguyen.chowders.nio.html;

import org.junit.Test;

import java.io.IOException;

import ninja.mpnguyen.chowders.things.html.Post;
import ninja.mpnguyen.chowders.things.html.Tag;

import static org.junit.Assert.*;

public class TopicTest {
    @Test
    public void testTopic() throws IOException {
        testTopic("cogsci");
        testTopic("networking");
        testTopic("law");
        testTopic("event");
        testTopic("culture");
    }

    private void testTopic(String topic) throws IOException {
        testTopicPaged(topic);
        Post[] cogscis = new Topic(topic).call();
        assertNotNull(cogscis);

        for (Post cogsci : cogscis) {
            boolean containsTag = false;
            for (Tag tag : cogsci.tags) {
                if (tag.name.equals(topic)) containsTag = true;
            }

            assertTrue(containsTag);
        }
    }
    private void testTopicPaged(String topic) throws IOException {
        Post[] cogscis = new Topic(topic, 1).call();
        assertNotNull(cogscis);

        for (Post cogsci : cogscis) {
            boolean containsTag = false;
            for (Tag tag : cogsci.tags) {
                if (tag.name.equals(topic)) containsTag = true;
            }

            assertTrue(containsTag);
        }
    }
}