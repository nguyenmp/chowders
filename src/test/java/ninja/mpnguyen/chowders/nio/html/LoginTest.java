package ninja.mpnguyen.chowders.nio.html;

import org.junit.Test;

import ninja.mpnguyen.chowders.nio.Credentials;
import ninja.mpnguyen.chowders.things.html.Auth;

import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void testLogin() throws Exception {
        String username = Credentials.username();
        String password = Credentials.password();
        String email = Credentials.email();
        Auth auth = new Login(username, password).call();
        assertNotNull(auth);
        assertEquals(username, auth.username);
        assertEquals(email, auth.email);
        assertNotNull(auth.cookie);

        // Cookies for unauthenticated users always ends in these escaped characters
        assertFalse(auth.cookie.contains("%3D%3D"));
    }
}