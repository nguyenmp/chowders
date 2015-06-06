package ninja.mpnguyen.chowders.nio;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public abstract class Post<T> {
    public T post() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(getURL())
                .post(getBody())
                .build();

        Response response = client.newCall(request).execute();
        return handle(response);
    }

    public abstract RequestBody getBody();

    public final String getURL() {
        return getBase() + getEndpoint();
    }

    public final String getBase() {
        return "https://lobste.rs/";
    }

    public abstract String getEndpoint();
    public abstract T handle(Response response);
}
