package ninja.mpnguyen.chowders.nio;

import ninja.mpnguyen.chowders.things.User;

public class UserFetcher extends GetJson<User> {
    private final String username;

    public UserFetcher(String username) {
        this.username = username;
    }

    @Override
    public String getEndpoint() {
        return String.format("u/%s.json", username);
    }

    @Override
    public Class<User> getType() {
        return User.class;
    }
}
