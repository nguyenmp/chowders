package ninja.mpnguyen.chowders.nio;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class GetHtml<T> extends Get<T> {
    @Override
    public T handle(String html) {
        return handle(Jsoup.parse(html));
    }

    public abstract T handle(Document doc);
}
