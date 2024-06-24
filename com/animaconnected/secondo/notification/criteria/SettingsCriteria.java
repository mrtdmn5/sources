package com.animaconnected.secondo.notification.criteria;

import android.content.Context;
import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.utils.SettingsProvider;

/* loaded from: classes3.dex */
public class SettingsCriteria extends Criteria {
    private final String mKey;
    private final SettingsProvider mSettingsProvider;

    public SettingsCriteria(Context context, String str) {
        this.mKey = str;
        this.mSettingsProvider = new SettingsProvider(context);
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (this.mSettingsProvider.isEnabled(this.mKey)) {
            return this.mAction;
        }
        return -1;
    }
}
