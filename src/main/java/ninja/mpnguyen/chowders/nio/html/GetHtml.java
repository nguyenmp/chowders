package ninja.mpnguyen.chowders.nio.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import ninja.mpnguyen.chowders.nio.Get;

public abstract class GetHtml<T> extends Get<T> {
    @Override
    public T handle(String html) {
        return handle(Jsoup.parse(html));
    }

    public abstract T handle(Document doc);
}
