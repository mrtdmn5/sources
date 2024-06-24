package com.animaconnected.secondo.notification.criteria;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.notification.DeviceNotification;

/* loaded from: classes3.dex */
public abstract class Criteria {
    public static final int ACTION_NONE = -1;
    protected static final int ACTION_NOT_DEFINED = Integer.MIN_VALUE;
    protected int mAction = Integer.MIN_VALUE;

    public void setAction(int r3) {
        if (r3 >= 0) {
            this.mAction = r3;
            return;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("action must be non-negative, action: ", r3));
    }

    public abstract int valid(DeviceNotification deviceNotification);
}
