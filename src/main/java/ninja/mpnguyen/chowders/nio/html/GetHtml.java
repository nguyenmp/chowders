package ninja.mpnguyen.chowders.nio.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import ninja.mpnguyen.chowders.nio.StringGet;

public abstract class GetHtml<T> extends StringGet<T> {
    public interface Parser<T> {
        T parse(Element e);
    }

    @Override
    public T handle(String html) {
        return getParser().parse(Jsoup.parse(html));
    }

    public abstract Parser<T> getParser();
}
