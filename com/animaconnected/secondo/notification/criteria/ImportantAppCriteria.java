package com.animaconnected.secondo.notification.criteria;

import com.animaconnected.secondo.notification.DeviceNotification;
import com.animaconnected.secondo.notification.model.ImportantApp;

/* loaded from: classes3.dex */
public class ImportantAppCriteria extends Criteria {
    private final ImportantApp mImportantApp;

    public ImportantAppCriteria(ImportantApp importantApp) {
        this.mImportantApp = importantApp;
    }

    @Override // com.animaconnected.secondo.notification.criteria.Criteria
    public int valid(DeviceNotification deviceNotification) {
        if (this.mImportantApp != null && deviceNotification.getPackageName().equalsIgnoreCase(this.mImportantApp.getPackageName())) {
            return this.mAction;
        }
        return -1;
    }
}
