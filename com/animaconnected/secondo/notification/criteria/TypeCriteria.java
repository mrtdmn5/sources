package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;

/* loaded from: classes3.dex */
public class TypeCriteria extends Criteria {
    private final String mCategory;

    public TypeCriteria(String str) {
        this.mCategory = str;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (this.mCategory.equalsIgnoreCase(deviceNotification.getCategory())) {
            return this.mAction;
        }
        return -1;
    }
}
