package ninja.mpnguyen.chowders.nio.html;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import ninja.mpnguyen.chowders.nio.Post;
import ninja.mpnguyen.chowders.things.html.Auth;

public class Login extends Post<Auth> {
    private final String username, password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public RequestBody getBody() {
        return new FormEncodingBuilder()
                .add("utf8", "✓")
                .add("email", username)
                .add("password", password)
                .add("commit", "Login")
                .add("referer", "https://lobste.rs/")
                .build();
    }

    @Override
    public String getEndpoint() {
        return "login";
    }

    @Override
    public Auth handle(Response response) {
        String cookie = response.header("Set-Cookie");
        return new Auth(username, cookie);
    }
}
