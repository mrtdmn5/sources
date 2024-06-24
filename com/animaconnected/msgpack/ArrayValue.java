package com.animaconnected.msgpack;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class ArrayValue extends Value {
    private final List<Value> list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(List<? extends Value> list) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayValue copy$default(ArrayValue arrayValue, List list, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            list = arrayValue.list;
        }
        return arrayValue.copy(list);
    }

    public final List<Value> component1() {
        return this.list;
    }

    public final ArrayValue copy(List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new ArrayValue(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ArrayValue) && Intrinsics.areEqual(this.list, ((ArrayValue) obj).list)) {
            return true;
        }
        return false;
    }

    public final List<Value> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return LocaleList$$ExternalSyntheticOutline0.m(new StringBuilder("ArrayValue(list="), this.list, ')');
    }
}
