package com.animaconnected.watch.model;

import app.cash.sqldelight.db.SqlDriver;

/* compiled from: DriverFactory.kt */
/* loaded from: classes3.dex */
public interface DriverFactory {
    SqlDriver createAlarmsDriver();

    SqlDriver createDriver();
}
