package com.animaconnected.secondo.utils.customersupport;

import android.content.Context;
import android.os.Build;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.misc.ConfigProvider;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.BrandUtils;
import com.animaconnected.watch.device.DeviceInfo;
import com.kronaby.watch.app.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSupportMailUtils.kt */
/* loaded from: classes3.dex */
public final class CustomerSupportMailUtils {
    public static final int $stable = 8;
    private final ConfigProvider configProvider;
    private final String contactLabsEmailAddress;
    private final Context context;

    public CustomerSupportMailUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.configProvider = ProviderFactory.createConfigProvider();
        this.contactLabsEmailAddress = "LABS@kronaby.com";
    }

    private final StringBuilder appendSupportMsgTechData(StringBuilder sb, Map<DeviceInfo, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Context context = this.context;
        Object[] objArr = new Object[1];
        String str6 = "";
        if (map == null || (str = map.get(DeviceInfo.SerialNumber)) == null) {
            str = "";
        }
        objArr[0] = str;
        sb.append(context.getString(R.string.support_msg_body_serial_number, objArr));
        Object[] objArr2 = new Object[1];
        if (map == null || (str2 = map.get(DeviceInfo.SerialNumber)) == null) {
            str2 = "";
        }
        objArr2[0] = str2;
        sb.append(context.getString(R.string.support_msg_body_serial_number, objArr2));
        Object[] objArr3 = new Object[1];
        if (map == null || (str3 = map.get(DeviceInfo.ModelNumber)) == null) {
            str3 = "";
        }
        objArr3[0] = str3;
        sb.append(context.getString(R.string.support_msg_body_model_number, objArr3));
        Object[] objArr4 = new Object[1];
        if (map == null || (str4 = map.get(DeviceInfo.HardwareRevision)) == null) {
            str4 = "";
        }
        objArr4[0] = str4;
        sb.append(context.getString(R.string.support_msg_body_hardware_revision, objArr4));
        Object[] objArr5 = new Object[1];
        if (map != null && (str5 = map.get(DeviceInfo.FirmwareRevision)) != null) {
            str6 = str5;
        }
        objArr5[0] = str6;
        sb.append(context.getString(R.string.support_msg_body_firmware_version, objArr5));
        sb.append(context.getString(R.string.support_msg_body_app_version, AppUtils.getVersion(this.context)));
        sb.append(context.getString(R.string.support_msg_body_phone_model, Build.MANUFACTURER + ' ' + Build.MODEL));
        sb.append(context.getString(R.string.support_msg_body_phone_os, Build.VERSION.RELEASE, Build.DISPLAY));
        sb.append(context.getString(R.string.support_msg_body_language, this.configProvider.getUserLocale().getCountry()));
        return sb;
    }

    public final String getContactLabsEmailAddress() {
        return this.contactLabsEmailAddress;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSupportEmailAddress() {
        String customerSupportEmail = BrandUtils.getCustomerSupportEmail(this.context);
        Intrinsics.checkNotNullExpressionValue(customerSupportEmail, "getCustomerSupportEmail(...)");
        return customerSupportEmail;
    }

    public final String getSupportMsgTechData(Map<DeviceInfo, String> map) {
        String sb = appendSupportMsgTechData(new StringBuilder(), map).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}
