package ninja.mpnguyen.chowders.nio;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.Callable;

import ninja.mpnguyen.chowders.things.html.Auth;

public abstract class RawGet<T> implements Callable<T> {
    @Override
    public T call() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request.Builder b = new Request.Builder().url(getURL());
        Auth auth = getAuthentication();
        if (auth != null) b.addHeader("Cookie", auth.cookie);
        Request request = b.build();
        Response response = client.newCall(request).execute();
        return handle(response);
    }

    public final String getURL() {
        return getBase() + getEndpoint();
    }

    public final String getBase() {
        return "https://lobste.rs/";
    }

    public abstract String getEndpoint();
    public abstract T handle(Response response) throws IOException;
    public Auth getAuthentication() {
        return null;
    }
}
