package security;

import javax.security.sasl.AuthenticationException;

public class JwtAuthentificationException extends AuthenticationException {
    public JwtAuthentificationException(String detail) {
        super(detail);
    }

    public JwtAuthentificationException(String detail, Throwable ex) {
        super(detail, ex);
    }
}
