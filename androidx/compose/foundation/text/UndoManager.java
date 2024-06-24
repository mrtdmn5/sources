package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UndoManager.kt */
/* loaded from: classes.dex */
public final class UndoManager {
    public boolean forceNextSnapshot;
    public Long lastSnapshot;
    public final int maxStoredCharacters;
    public Entry redoStack;
    public int storedCharacters;
    public Entry undoStack;

    /* compiled from: UndoManager.kt */
    /* loaded from: classes.dex */
    public static final class Entry {
        public Entry next;
        public TextFieldValue value;

        public Entry(Entry entry, TextFieldValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.next = entry;
            this.value = value;
        }
    }

    public UndoManager() {
        this(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[LOOP:0: B:26:0x005e->B:31:0x006a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[EDGE_INSN: B:32:0x006d->B:33:0x006d BREAK  A[LOOP:0: B:26:0x005e->B:31:0x006a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void makeSnapshot(androidx.compose.ui.text.input.TextFieldValue r5) {
        /*
            r4 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            r4.forceNextSnapshot = r0
            androidx.compose.foundation.text.UndoManager$Entry r0 = r4.undoStack
            r1 = 0
            if (r0 == 0) goto L11
            androidx.compose.ui.text.input.TextFieldValue r0 = r0.value
            goto L12
        L11:
            r0 = r1
        L12:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r0 == 0) goto L19
            return
        L19:
            androidx.compose.ui.text.AnnotatedString r0 = r5.annotatedString
            java.lang.String r2 = r0.text
            androidx.compose.foundation.text.UndoManager$Entry r3 = r4.undoStack
            if (r3 == 0) goto L2a
            androidx.compose.ui.text.input.TextFieldValue r3 = r3.value
            if (r3 == 0) goto L2a
            androidx.compose.ui.text.AnnotatedString r3 = r3.annotatedString
            java.lang.String r3 = r3.text
            goto L2b
        L2a:
            r3 = r1
        L2b:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L39
            androidx.compose.foundation.text.UndoManager$Entry r0 = r4.undoStack
            if (r0 != 0) goto L36
            goto L38
        L36:
            r0.value = r5
        L38:
            return
        L39:
            androidx.compose.foundation.text.UndoManager$Entry r2 = r4.undoStack
            androidx.compose.foundation.text.UndoManager$Entry r3 = new androidx.compose.foundation.text.UndoManager$Entry
            r3.<init>(r2, r5)
            r4.undoStack = r3
            r4.redoStack = r1
            int r5 = r4.storedCharacters
            java.lang.String r0 = r0.text
            int r0 = r0.length()
            int r0 = r0 + r5
            r4.storedCharacters = r0
            int r5 = r4.maxStoredCharacters
            if (r0 <= r5) goto L72
            androidx.compose.foundation.text.UndoManager$Entry r5 = r4.undoStack
            if (r5 == 0) goto L5a
            androidx.compose.foundation.text.UndoManager$Entry r0 = r5.next
            goto L5b
        L5a:
            r0 = r1
        L5b:
            if (r0 != 0) goto L5e
            goto L72
        L5e:
            if (r5 == 0) goto L67
            androidx.compose.foundation.text.UndoManager$Entry r0 = r5.next
            if (r0 == 0) goto L67
            androidx.compose.foundation.text.UndoManager$Entry r0 = r0.next
            goto L68
        L67:
            r0 = r1
        L68:
            if (r0 == 0) goto L6d
            androidx.compose.foundation.text.UndoManager$Entry r5 = r5.next
            goto L5e
        L6d:
            if (r5 != 0) goto L70
            goto L72
        L70:
            r5.next = r1
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.UndoManager.makeSnapshot(androidx.compose.ui.text.input.TextFieldValue):void");
    }

    public UndoManager(int r1) {
        this.maxStoredCharacters = 100000;
    }
}
