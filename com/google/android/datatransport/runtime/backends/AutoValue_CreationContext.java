package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes3.dex */
public final class AutoValue_CreationContext extends CreationContext {
    public final Context applicationContext;
    public final String backendName;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.applicationContext = context;
            if (clock != null) {
                this.wallClock = clock;
                if (clock2 != null) {
                    this.monotonicClock = clock2;
                    if (str != null) {
                        this.backendName = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (this.applicationContext.equals(creationContext.getApplicationContext()) && this.wallClock.equals(creationContext.getWallClock()) && this.monotonicClock.equals(creationContext.getMonotonicClock()) && this.backendName.equals(creationContext.getBackendName())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final String getBackendName() {
        return this.backendName;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock getMonotonicClock() {
        return this.monotonicClock;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock getWallClock() {
        return this.wallClock;
    }

    public final int hashCode() {
        return ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.applicationContext);
        sb.append(", wallClock=");
        sb.append(this.wallClock);
        sb.append(", monotonicClock=");
        sb.append(this.monotonicClock);
        sb.append(", backendName=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.backendName, "}");
    }
}
