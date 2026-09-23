package ui.utils.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBuilder {

    private String email;

    private String password;


}
