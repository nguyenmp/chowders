package ninja.mpnguyen.chowders.things.html;

import java.io.Serializable;

public class Filter implements Serializable {
    public Tag tag;
    public int stories;
    public boolean hidden;

    public Filter(Tag tag, int stories, boolean hidden) {
        this.tag = tag;
        this.stories = stories;
        this.hidden = hidden;
    }

    public Filter(Filter other) {
        this.tag = other.tag;
        this.stories = other.stories;
        this.hidden = other.hidden;
    }
}
