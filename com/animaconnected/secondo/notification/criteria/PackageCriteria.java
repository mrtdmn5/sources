package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;

/* loaded from: classes3.dex */
public class PackageCriteria extends Criteria {
    private final String mPackageName;

    public PackageCriteria(String str) {
        this.mPackageName = str;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (deviceNotification.getPackageName().equals(this.mPackageName)) {
            return this.mAction;
        }
        return -1;
    }
}
