package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.watch.DeviceInformation;
import com.animaconnected.watch.SharedPreferencesCache;
import com.animaconnected.watch.device.DeviceInfo;
import com.kronaby.watch.app.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AboutWatchDialogFragment.kt */
/* loaded from: classes3.dex */
public final class AboutWatchDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String BUNDLE_ADDRESS = "address";
    private Map<DeviceInfo, String> deviceInfoMap = new LinkedHashMap();
    private String mAddress;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AboutWatchDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AboutWatchDialogFragment newInstance(String str) {
            AboutWatchDialogFragment aboutWatchDialogFragment = new AboutWatchDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("address", str);
            aboutWatchDialogFragment.setArguments(bundle);
            return aboutWatchDialogFragment;
        }

        private Companion() {
        }
    }

    private final StringBuilder appendlnFromDeviceInfo(StringBuilder sb, int r4, DeviceInfo deviceInfo) {
        String str = this.deviceInfoMap.get(deviceInfo);
        String str2 = null;
        if (str == null) {
            return null;
        }
        Context context = getContext();
        if (context != null) {
            str2 = context.getString(r4, str);
        }
        sb.append(str2);
        sb.append('\n');
        return sb;
    }

    private final String getAboutText() {
        String str;
        StringBuilder sb = new StringBuilder(200);
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.settings_application_version, AppUtils.getVersion(getContext()));
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('\n');
        appendlnFromDeviceInfo(sb, R.string.settings_firmware_version, DeviceInfo.FirmwareRevision);
        appendlnFromDeviceInfo(sb, R.string.settings_model_number, DeviceInfo.ModelNumber);
        appendlnFromDeviceInfo(sb, R.string.settings_serial_number, DeviceInfo.SerialNumber);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return StringsKt__StringsKt.trim(sb2).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$2$lambda$1(AboutWatchDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        String str;
        Context context;
        Map<DeviceInfo, String> linkedHashMap;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("address");
        } else {
            str = null;
        }
        this.mAddress = str;
        if (str != null && (context = getContext()) != null) {
            DeviceInformation readFromCache = DeviceInformation.Companion.readFromCache(new SharedPreferencesCache(context, str));
            if (readFromCache == null || (linkedHashMap = readFromCache.getLegacyInformation(str)) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            this.deviceInfoMap = linkedHashMap;
        }
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_settings_about_watch, null);
        ((Button) inflate.findViewById(R.id.about_watch_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.AboutWatchDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutWatchDialogFragment.onCreateDialogView$lambda$2$lambda$1(AboutWatchDialogFragment.this, view);
            }
        });
        ((TextView) inflate.findViewById(R.id.about_watch_descripton)).setText(getAboutText());
        return inflate;
    }
}
