package ninja.mpnguyen.chowders.nio.html;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Callable;

import ninja.mpnguyen.chowders.nio.RawGet;
import ninja.mpnguyen.chowders.nio.Post;
import ninja.mpnguyen.chowders.things.html.Auth;

public class Login implements Callable<Auth> {
    private final String login, password;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Auth call() throws IOException {
        // Phase 1 is to initialize with the default cookie and authentication token
        OkHttpClient client = new OkHttpClient();
        client.setFollowRedirects(false);
        client.setFollowSslRedirects(false);

        Request initRequest = new Request.Builder()
                .url("https://lobste.rs/login")
                .build();

        Response initResponse = client.newCall(initRequest).execute();
        String initCookie = initResponse.header("Set-Cookie").split(";")[0];
        String initBody = initResponse.body().string();
        String authenticity_token = Jsoup.parse(initBody).body().select("[name=authenticity_token]").val();

        // Phase 2 is to authenticate given the cookie and authentication token
        RequestBody loginBody = new FormEncodingBuilder()
                .add("utf8", "\u2713")
                .add("authenticity_token", authenticity_token)
                .add("email", login)
                .add("password", password)
                .add("commit", "Login")
                .add("referer", "https://lobste.rs/")
                .build();
        Request loginRequest = new Request.Builder()
                .url("https://lobste.rs/login")
                .header("Cookie", initCookie) // We must use #header instead of #addHeader
                .post(loginBody)
                .build();

        Response loginResponse = client.newCall(loginRequest).execute();
        String loginCookie = loginResponse.header("Set-Cookie").split(";")[0];

        // Phase 3 is to grab the actual username/email from the settings page
        Request detailsRequest = new Request.Builder()
                .url("https://lobste.rs/settings")
                .header("Cookie", loginCookie)
                .build();
        Response detailsResponse = client.newCall(detailsRequest).execute();
        String detailsHtml = detailsResponse.body().string();

        Document dom = Jsoup.parse(detailsHtml);
        String username = dom.select("#user_username").val();
        String email = dom.select("#user_email").val();

        // And then we return the result of all three phases
        return new Auth(email, username, loginCookie);
    }
}
