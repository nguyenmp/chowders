package ninja.mpnguyen.chowders.nio.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ninja.mpnguyen.chowders.nio.Get;

public abstract class GetHtml<T> extends Get<T> {
    public interface Parser<T> {
        T parse(Element e);
    }

    @Override
    public T handle(String html) {
        return getParser().parse(Jsoup.parse(html));
    }

    public abstract Parser<T> getParser();
}
