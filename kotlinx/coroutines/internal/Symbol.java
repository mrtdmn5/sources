package kotlinx.coroutines.internal;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.io.Serializable;

/* compiled from: Symbol.kt */
/* loaded from: classes4.dex */
public final class Symbol {
    public final Serializable symbol;

    public Symbol(String str) {
        this.symbol = str;
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("<"), (String) this.symbol, '>');
    }
}
