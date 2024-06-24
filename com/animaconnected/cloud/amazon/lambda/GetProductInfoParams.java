package com.animaconnected.cloud.amazon.lambda;

/* loaded from: classes.dex */
public class GetProductInfoParams {
    private final String bucket;
    private final String item_id;
    private final String platform;
    private final String serial_no;

    public GetProductInfoParams(String str, String str2, String str3, String str4) {
        this.serial_no = str;
        this.item_id = str2;
        this.bucket = str3;
        this.platform = str4;
    }
}
