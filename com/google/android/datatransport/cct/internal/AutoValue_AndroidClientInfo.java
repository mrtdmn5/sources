package com.google.android.datatransport.cct.internal;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    public final String applicationBuild;
    public final String country;
    public final String device;
    public final String fingerprint;
    public final String hardware;
    public final String locale;
    public final String manufacturer;
    public final String mccMnc;
    public final String model;
    public final String osBuild;
    public final String product;
    public final Integer sdkVersion;

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.sdkVersion;
        if (num != null ? num.equals(androidClientInfo.getSdkVersion()) : androidClientInfo.getSdkVersion() == null) {
            String str = this.model;
            if (str != null ? str.equals(androidClientInfo.getModel()) : androidClientInfo.getModel() == null) {
                String str2 = this.hardware;
                if (str2 != null ? str2.equals(androidClientInfo.getHardware()) : androidClientInfo.getHardware() == null) {
                    String str3 = this.device;
                    if (str3 != null ? str3.equals(androidClientInfo.getDevice()) : androidClientInfo.getDevice() == null) {
                        String str4 = this.product;
                        if (str4 != null ? str4.equals(androidClientInfo.getProduct()) : androidClientInfo.getProduct() == null) {
                            String str5 = this.osBuild;
                            if (str5 != null ? str5.equals(androidClientInfo.getOsBuild()) : androidClientInfo.getOsBuild() == null) {
                                String str6 = this.manufacturer;
                                if (str6 != null ? str6.equals(androidClientInfo.getManufacturer()) : androidClientInfo.getManufacturer() == null) {
                                    String str7 = this.fingerprint;
                                    if (str7 != null ? str7.equals(androidClientInfo.getFingerprint()) : androidClientInfo.getFingerprint() == null) {
                                        String str8 = this.locale;
                                        if (str8 != null ? str8.equals(androidClientInfo.getLocale()) : androidClientInfo.getLocale() == null) {
                                            String str9 = this.country;
                                            if (str9 != null ? str9.equals(androidClientInfo.getCountry()) : androidClientInfo.getCountry() == null) {
                                                String str10 = this.mccMnc;
                                                if (str10 != null ? str10.equals(androidClientInfo.getMccMnc()) : androidClientInfo.getMccMnc() == null) {
                                                    String str11 = this.applicationBuild;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getApplicationBuild() {
        return this.applicationBuild;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getCountry() {
        return this.country;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getDevice() {
        return this.device;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getFingerprint() {
        return this.fingerprint;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getHardware() {
        return this.hardware;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getLocale() {
        return this.locale;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getManufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getMccMnc() {
        return this.mccMnc;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getModel() {
        return this.model;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getOsBuild() {
        return this.osBuild;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String getProduct() {
        return this.product;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final Integer getSdkVersion() {
        return this.sdkVersion;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int r0 = 0;
        Integer num = this.sdkVersion;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r1 = (hashCode ^ 1000003) * 1000003;
        String str = this.model;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int r12 = (r1 ^ hashCode2) * 1000003;
        String str2 = this.hardware;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int r13 = (r12 ^ hashCode3) * 1000003;
        String str3 = this.device;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int r14 = (r13 ^ hashCode4) * 1000003;
        String str4 = this.product;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int r15 = (r14 ^ hashCode5) * 1000003;
        String str5 = this.osBuild;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int r16 = (r15 ^ hashCode6) * 1000003;
        String str6 = this.manufacturer;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int r17 = (r16 ^ hashCode7) * 1000003;
        String str7 = this.fingerprint;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int r18 = (r17 ^ hashCode8) * 1000003;
        String str8 = this.locale;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int r19 = (r18 ^ hashCode9) * 1000003;
        String str9 = this.country;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int r110 = (r19 ^ hashCode10) * 1000003;
        String str10 = this.mccMnc;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int r111 = (r110 ^ hashCode11) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            r0 = str11.hashCode();
        }
        return r0 ^ r111;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", hardware=");
        sb.append(this.hardware);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(", osBuild=");
        sb.append(this.osBuild);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", fingerprint=");
        sb.append(this.fingerprint);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", mccMnc=");
        sb.append(this.mccMnc);
        sb.append(", applicationBuild=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.applicationBuild, "}");
    }
}
