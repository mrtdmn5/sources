package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class TransportContext {

    @AutoValue.Builder
    /* loaded from: classes3.dex */
    public static abstract class Builder {
    }

    public static AutoValue_TransportContext.Builder builder() {
        AutoValue_TransportContext.Builder builder = new AutoValue_TransportContext.Builder();
        builder.setPriority(Priority.DEFAULT);
        return builder;
    }

    public abstract String getBackendName();

    public abstract byte[] getExtras();

    public abstract Priority getPriority();

    public final String toString() {
        String encodeToString;
        Object[] objArr = new Object[3];
        objArr[0] = getBackendName();
        objArr[1] = getPriority();
        if (getExtras() == null) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(getExtras(), 2);
        }
        objArr[2] = encodeToString;
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public final AutoValue_TransportContext withPriority(Priority priority) {
        AutoValue_TransportContext.Builder builder = builder();
        builder.setBackendName(getBackendName());
        builder.setPriority(priority);
        builder.extras = getExtras();
        return builder.build();
    }
}
