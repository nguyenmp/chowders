package ninja.mpnguyen.chowders.things.html;

import java.io.Serializable;

public class Tag implements Serializable {
    public String name, url, title;

    public Tag(String name, String url, String title) {
        this.name = name;
        this.url = url;
        this.title = title;
    }

    public Tag(Tag other) {
        this.name = other.name;
        this.url = other.url;
        this.title = other.title;
    }
}
