package utils.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {

    private String type;
    private String password;
    private String email;
    private DeviceDto device;
}