package dto;

import lombok.Data;

/**
 * @author author
 * @version 1.0
 */
@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;

}
