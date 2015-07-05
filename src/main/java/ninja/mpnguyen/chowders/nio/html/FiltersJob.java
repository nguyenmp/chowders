package ninja.mpnguyen.chowders.nio.html;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import ninja.mpnguyen.chowders.things.html.Auth;
import ninja.mpnguyen.chowders.things.html.Filter;
import ninja.mpnguyen.chowders.things.html.Tag;

public class FiltersJob extends GetHtml<Filter[]> {
    private final Auth auth;

    public FiltersJob() {
        this.auth = null;
    }

    public FiltersJob(Auth auth) {
        this.auth = auth;
    }

    @Override
    public Auth getAuthentication() {
        return auth;
    }

    @Override
    public String getEndpoint() {
        return "filters";
    }

    @Override
    public Parser<Filter[]> getParser() {
        return new FiltersParser();
    }

    private static class FiltersParser implements Parser<Filter[]> {
        @Override
        public Filter[] parse(Element e) {
            final List<Filter> tags = new ArrayList<>();
            Element tbody = e.select("tbody").get(0);
            Elements trs = tbody.children();

            // Start at offset 1 because first row is the headers
            for (int i = 1; i < trs.size(); i++) {
                Element tagRow = trs.get(i);
                Filter tag = parseFilter(tagRow);
                tags.add(tag);
            }

            return tags.toArray(new Filter[tags.size()]);
        }

        private Filter parseFilter(Element e) {
            Elements tds = e.children();
            boolean hidden = "checked".equalsIgnoreCase(tds.get(0).child(0).attr("checked"));
            String name = tds.get(1).text();
            String url = tds.get(1).select("a").attr("href");
            String title = tds.get(2).text();
            int stories = Integer.parseInt(tds.get(3).text());

            Tag tag = new Tag(name, url, title);
            return new Filter(tag, stories, hidden);
        }
    }
}
