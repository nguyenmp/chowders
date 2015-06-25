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

import ninja.mpnguyen.chowders.nio.RawGet;
import ninja.mpnguyen.chowders.nio.Post;
import ninja.mpnguyen.chowders.things.html.Auth;

public class Login extends Post<Auth> {
    private final String login, password;
    private Params params;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Auth post() throws IOException {
        params = new ParameterFetcher().get();
        return super.post();
    }

    @Override
    public RequestBody getBody() {
        return new FormEncodingBuilder()
                .add("utf8", "\u2713")
                .add("authenticity_token", params.authenticity_token)
                .add("email", "markerz")
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
    public Auth handle(Response response) throws IOException {
        String cookie = response.header("Set-Cookie").split(";")[0];

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://lobste.rs/settings")
                .header("Cookie", cookie)
                .build();
        Response r = client.newCall(request).execute();
        String html = r.body().string();
        Document dom = Jsoup.parse(html);
        String username = dom.select("#user_username").val();
        String email = dom.select("#user_email").val();

        return new Auth(email, username, cookie);
    }

    @Override
    public Auth getAuthentication() {
        return new Auth("", "", params.cookie);
    }

    private static class Params implements Serializable {
        public final String authenticity_token, cookie;

        private Params(String authenticity_token, String cookie) {
            this.authenticity_token = authenticity_token;
            this.cookie = cookie;
        }
    }

    private static class ParameterFetcher extends RawGet<Params> {
        @Override
        public Params handle(Response response) throws IOException {
            String cookie = response.header("Set-Cookie").split(";")[0];
            String body = response.body().string();
            String authenticity_token = Jsoup.parse(body).body().select("[name=authenticity_token]").val();
            return new Params(authenticity_token, cookie);
        }

        @Override
        public String getEndpoint() {
            return "login";
        }

    }
}
