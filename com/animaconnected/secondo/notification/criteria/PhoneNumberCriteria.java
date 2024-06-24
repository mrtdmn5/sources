package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.utils.PhoneNumberCompare;

/* loaded from: classes3.dex */
public class PhoneNumberCriteria extends Criteria {
    private final String[] mPhoneNumbers;

    public PhoneNumberCriteria(String str) {
        String[] split;
        if (str == null) {
            split = new String[0];
        } else {
            split = str.split(Contact.PHONE_NUMBERS_DELIMITER);
        }
        this.mPhoneNumbers = split;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        for (String str : this.mPhoneNumbers) {
            if (PhoneNumberCompare.compare(str, deviceNotification.getSender())) {
                return this.mAction;
            }
        }
        return -1;
    }
}
