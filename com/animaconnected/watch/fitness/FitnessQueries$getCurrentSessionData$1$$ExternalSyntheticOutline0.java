package com.animaconnected.watch.fitness;

import app.cash.sqldelight.ColumnAdapter;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0 {
    public static Object m(SqlCursor sqlCursor, int r1, ColumnAdapter columnAdapter) {
        Long l = sqlCursor.getLong(r1);
        Intrinsics.checkNotNull(l);
        return columnAdapter.decode(l);
    }
}
