package ninja.mpnguyen.chowders.nio.html;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ninja.mpnguyen.chowders.things.html.Auth;

public class Settings extends GetHtml<String> {
    private final Auth auth;

    public Settings(Auth auth) {
        this.auth = auth;
    }

    @Override
    public Parser<String> getParser() {
        return new SettingsParser();
    }

    @Override
    public String getEndpoint() {
        return "settings";
    }

    @Override
    public Auth getAuthentication() {
        return auth;
    }

    private static class SettingsParser implements Parser<String> {
        @Override
        public String parse(Element e) {
            Elements email = e.select("#user_email");
            return email.val();
        }
    }
}
