package ninja.mpnguyen.chowders.nio.json;

import com.google.gson.Gson;

import ninja.mpnguyen.chowders.nio.Get;

public abstract class GetJson<T> extends Get<T> {
    @Override
    public T handle(String json) {
        return new Gson().fromJson(json, getType());
    }

    public abstract Class<T> getType();
}
