package com.geoin.iot.modules.OneNet.response.device;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewDeviceResponse {

    @JsonProperty(value="device_id")
    private String deviceId;


    @JsonProperty(value="psk")
    private String psk;


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String DeviceId) {
        this.deviceId = DeviceId;
    }

    public String getPsk() {
        return psk;
    }

    public void setPsk(String psk) {
        this.psk = psk;
    }
}
