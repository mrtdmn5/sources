package androidx.compose.foundation.text;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardActions.kt */
/* loaded from: classes.dex */
public final class KeyboardActions {
    public static final KeyboardActions Default = new KeyboardActions(null, null, 63);
    public final Function1<KeyboardActionScope, Unit> onDone;
    public final Function1<KeyboardActionScope, Unit> onGo;
    public final Function1<KeyboardActionScope, Unit> onNext;
    public final Function1<KeyboardActionScope, Unit> onPrevious;
    public final Function1<KeyboardActionScope, Unit> onSearch;
    public final Function1<KeyboardActionScope, Unit> onSend;

    public KeyboardActions() {
        this(null, null, 63);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) obj;
        if (Intrinsics.areEqual(this.onDone, keyboardActions.onDone) && Intrinsics.areEqual(this.onGo, keyboardActions.onGo) && Intrinsics.areEqual(this.onNext, keyboardActions.onNext) && Intrinsics.areEqual(this.onPrevious, keyboardActions.onPrevious) && Intrinsics.areEqual(this.onSearch, keyboardActions.onSearch) && Intrinsics.areEqual(this.onSend, keyboardActions.onSend)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r24;
        int r0 = 0;
        Function1<KeyboardActionScope, Unit> function1 = this.onDone;
        if (function1 != null) {
            r1 = function1.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        Function1<KeyboardActionScope, Unit> function12 = this.onGo;
        if (function12 != null) {
            r2 = function12.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Function1<KeyboardActionScope, Unit> function13 = this.onNext;
        if (function13 != null) {
            r22 = function13.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        Function1<KeyboardActionScope, Unit> function14 = this.onPrevious;
        if (function14 != null) {
            r23 = function14.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        Function1<KeyboardActionScope, Unit> function15 = this.onSearch;
        if (function15 != null) {
            r24 = function15.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        Function1<KeyboardActionScope, Unit> function16 = this.onSend;
        if (function16 != null) {
            r0 = function16.hashCode();
        }
        return r16 + r0;
    }

    public KeyboardActions(Function1 function1, Function1 function12, int r5) {
        function1 = (r5 & 1) != 0 ? null : function1;
        function12 = (r5 & 16) != 0 ? null : function12;
        this.onDone = function1;
        this.onGo = null;
        this.onNext = null;
        this.onPrevious = null;
        this.onSearch = function12;
        this.onSend = null;
    }
}
