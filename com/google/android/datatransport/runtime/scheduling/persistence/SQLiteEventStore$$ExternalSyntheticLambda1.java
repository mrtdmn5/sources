package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda1 implements SQLiteEventStore.Function {
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        byte[] decode;
        Cursor cursor = (Cursor) obj;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            AutoValue_TransportContext.Builder builder = TransportContext.builder();
            builder.setBackendName(cursor.getString(1));
            builder.setPriority(PriorityMapping.valueOf(cursor.getInt(2)));
            String string = cursor.getString(3);
            if (string == null) {
                decode = null;
            } else {
                decode = Base64.decode(string, 0);
            }
            builder.extras = decode;
            arrayList.add(builder.build());
        }
        return arrayList;
    }
}
