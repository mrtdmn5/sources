package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;

/* loaded from: classes3.dex */
public class EmailCriteria extends Criteria {
    private final String mEmailAddress;

    public EmailCriteria(String str) {
        this.mEmailAddress = str;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (this.mEmailAddress.equalsIgnoreCase(deviceNotification.getSender())) {
            return this.mAction;
        }
        return -1;
    }
}
