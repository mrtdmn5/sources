package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;

/* loaded from: classes3.dex */
public class BooleanCriteria extends Criteria {
    private final boolean mIsValid;

    public BooleanCriteria(boolean z) {
        this.mIsValid = z;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (this.mIsValid) {
            return this.mAction;
        }
        return -1;
    }
}
