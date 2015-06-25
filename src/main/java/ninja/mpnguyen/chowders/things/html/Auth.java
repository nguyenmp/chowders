package ninja.mpnguyen.chowders.things.html;

import java.io.Serializable;

public class Auth implements Serializable {
    public String email;
    public String username;
    public String cookie;

    public Auth(Auth other) {
        this.email = other.email;
        this.username = other.username;
        this.cookie = other.cookie;
    }

    public Auth(String email, String username, String cookie) {
        this.email = email;
        this.username = username;
        this.cookie = cookie;
    }
}