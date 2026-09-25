package utils.builder;


public class LoginRequestDto {

    private final String type;
    private final String password;
    private final String email;
    private final DeviceDto device;

    private LoginRequestDto(Builder builder) {
        this.type = builder.type;
        this.password = builder.password;
        this.email = builder.email;
        this.device = builder.device;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public DeviceDto getDevice() {
        return device;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String type;
        private String password;
        private String email;
        private DeviceDto device;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder device(DeviceDto device) {
            this.device = device;
            return this;
        }

        public LoginRequestDto build() {
            return new LoginRequestDto(this);
        }
    }
}