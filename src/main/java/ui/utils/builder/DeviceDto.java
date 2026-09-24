package ui.utils.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceDto {

    private String platform;
    private String device_id;
    private String device_model;
    private String os_version;
    private String browser_name;
    private String browser_version;
    private String user_agent;
}

