package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class OrCriteria extends GroupCriteria {
    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        Iterator<Criteria> it = this.mCriteriaList.iterator();
        while (it.hasNext()) {
            int valid = it.next().valid(deviceNotification);
            if (valid != -1) {
                return valid;
            }
        }
        return -1;
    }
}
