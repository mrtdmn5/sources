package com.amplifyframework.devmenu;

import android.database.Cursor;
import com.amplifyframework.devmenu.DeveloperMenu;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DeveloperMenuActivity$$ExternalSyntheticLambda0 implements DeveloperMenu.HideAction, SQLiteEventStore.Function {
    public final /* synthetic */ Object f$0;

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        Cursor cursor = (Cursor) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        sQLiteEventStore.getClass();
        while (cursor.moveToNext()) {
            sQLiteEventStore.recordLogEventDropped(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    @Override // com.amplifyframework.devmenu.DeveloperMenu.HideAction
    public final void hideDeveloperMenu() {
        ((DeveloperMenuActivity) this.f$0).finish();
    }
}
