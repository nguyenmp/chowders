package ninja.mpnguyen.chowders.nio;

import com.google.gson.Gson;

public abstract class GetJson<T> extends Get<T> {
    @Override
    public T handle(String json) {
        return new Gson().fromJson(json, getType());
    }

    public abstract Class<T> getType();
}
