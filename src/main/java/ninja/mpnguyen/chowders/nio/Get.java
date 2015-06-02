package ninja.mpnguyen.chowders.nio;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public abstract class Get<T> {
    public T get() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getURL()).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        return handle(json);
    }

    public final String getURL() {
        return getBase() + getEndpoint();
    }

    public final String getBase() {
        return "https://lobste.rs/";
    }

    public abstract String getEndpoint();
    public abstract T handle(String response);
}
