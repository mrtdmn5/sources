package com.animaconnected.cloud.amazon.lambda;

import com.animaconnected.cloud.util.CloudStatusApp;
import com.animaconnected.cloud.util.CloudStatusDevice;
import com.animaconnected.cloud.util.CloudStatusMobile;

/* loaded from: classes.dex */
public class SendStatusDestinationParams {
    private final Application application;
    private final Device device;
    private final Mobile mobile;

    /* loaded from: classes.dex */
    public class Application {
        private final String applicationVariant;
        private final String name;
        private final String version;
        private final String versionCode;
        private final String versionName;

        public Application(CloudStatusApp cloudStatusApp) {
            this.name = cloudStatusApp.getName();
            this.version = cloudStatusApp.getVersion();
            this.versionCode = cloudStatusApp.getVersionCode();
            this.versionName = cloudStatusApp.getVersionName();
            this.applicationVariant = cloudStatusApp.getApplicationVariant();
        }
    }

    /* loaded from: classes.dex */
    public class Device {
        private final Boolean alwaysSendLatest;
        private final String fwRevision;
        private final String hwRevision;
        private final String itemId;
        private final String serialNumber;
        private final String updateType;
        private final Integer variant;

        public Device(CloudStatusDevice cloudStatusDevice) {
            this.itemId = cloudStatusDevice.getItemId();
            this.serialNumber = cloudStatusDevice.getSerialNumber();
            this.hwRevision = cloudStatusDevice.getHwVersion();
            this.fwRevision = cloudStatusDevice.getSwVersion();
            this.alwaysSendLatest = Boolean.valueOf(cloudStatusDevice.getAlwaysSendLatest());
            this.updateType = cloudStatusDevice.getUpdateType();
            this.variant = cloudStatusDevice.getFirmwareVariant().getValue();
        }
    }

    /* loaded from: classes.dex */
    public class Mobile {
        private final String manufacturer;
        private final String model;
        private final String platformName;
        private final String platformVersion;

        public Mobile(CloudStatusMobile cloudStatusMobile) {
            this.manufacturer = cloudStatusMobile.getManufacturer();
            this.model = cloudStatusMobile.getModel();
            this.platformName = cloudStatusMobile.getPlatformName();
            this.platformVersion = cloudStatusMobile.getPlatformVersion();
        }
    }

    public SendStatusDestinationParams(CloudStatusMobile cloudStatusMobile, CloudStatusApp cloudStatusApp, CloudStatusDevice cloudStatusDevice) {
        this.mobile = new Mobile(cloudStatusMobile);
        this.application = new Application(cloudStatusApp);
        this.device = new Device(cloudStatusDevice);
    }

    public Application getApplication() {
        return this.application;
    }

    public Device getDevice() {
        return this.device;
    }

    public Mobile getMobile() {
        return this.mobile;
    }
}
