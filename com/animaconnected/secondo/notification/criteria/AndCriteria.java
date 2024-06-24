package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AndCriteria extends GroupCriteria {
    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        Iterator<Criteria> it = this.mCriteriaList.iterator();
        int r2 = -1;
        while (it.hasNext()) {
            int valid = it.next().valid(deviceNotification);
            if (valid == -1) {
                return -1;
            }
            if (r2 == -1 || r2 == Integer.MIN_VALUE) {
                r2 = valid;
            }
        }
        return r2;
    }
}
