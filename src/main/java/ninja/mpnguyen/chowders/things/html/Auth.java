package ninja.mpnguyen.chowders.things.html;

import java.io.Serializable;

public class Auth implements Serializable {
    public String username;
    public String cookie;

    public Auth(Auth other) {
        this.username = other.username;
        this.cookie = other.cookie;
    }

    public Auth(String username, String cookie) {
        this.username = username;
        this.cookie = cookie;
    }
}