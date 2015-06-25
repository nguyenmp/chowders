package ninja.mpnguyen.chowders.nio;

import com.squareup.okhttp.Response;

import java.io.IOException;

public abstract class StringGet<T> extends RawGet<T> {
    @Override
    public T handle(Response response) throws IOException {
        String string = response.body().string();
        return handle(string);
    }

    public abstract T handle(String response);
}
