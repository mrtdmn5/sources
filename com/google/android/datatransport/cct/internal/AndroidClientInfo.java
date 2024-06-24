package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class AndroidClientInfo {
    public abstract String getApplicationBuild();

    public abstract String getCountry();

    public abstract String getDevice();

    public abstract String getFingerprint();

    public abstract String getHardware();

    public abstract String getLocale();

    public abstract String getManufacturer();

    public abstract String getMccMnc();

    public abstract String getModel();

    public abstract String getOsBuild();

    public abstract String getProduct();

    public abstract Integer getSdkVersion();
}
