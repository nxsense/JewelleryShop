package security;

import javax.security.sasl.AuthenticationException;

/**
 * @author author
 * @version 1.0
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String detail) {
        super(detail);
    }

    public JwtAuthenticationException(String detail, Throwable ex) {
        super(detail, ex);
    }
}
