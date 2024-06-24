package androidx.room.util;

import android.database.Cursor;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* loaded from: classes.dex */
public final class CursorUtil {
    public static final long access$DistanceAndInLayer(float f, boolean z) {
        long j;
        long floatToIntBits = Float.floatToIntBits(f);
        if (z) {
            j = 1;
        } else {
            j = 0;
        }
        return (j & 4294967295L) | (floatToIntBits << 32);
    }

    public static int getColumnIndex(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("work_spec_id");
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndex("`work_spec_id`");
    }

    public static int getColumnIndexOrThrow(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }

    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m611updateRangeAfterDeletepWDy79M(long j, long j2) {
        boolean z;
        int m524getMaximpl;
        int m525getMinimpl;
        int r6;
        boolean z2;
        boolean z3;
        int m525getMinimpl2 = TextRange.m525getMinimpl(j);
        int m524getMaximpl2 = TextRange.m524getMaximpl(j);
        boolean z4 = true;
        if (TextRange.m525getMinimpl(j2) < TextRange.m524getMaximpl(j) && TextRange.m525getMinimpl(j) < TextRange.m524getMaximpl(j2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (TextRange.m525getMinimpl(j2) <= TextRange.m525getMinimpl(j) && TextRange.m524getMaximpl(j) <= TextRange.m524getMaximpl(j2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                m525getMinimpl2 = TextRange.m525getMinimpl(j2);
                m524getMaximpl2 = m525getMinimpl2;
            } else {
                if (TextRange.m525getMinimpl(j) <= TextRange.m525getMinimpl(j2) && TextRange.m524getMaximpl(j2) <= TextRange.m524getMaximpl(j)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    m524getMaximpl = TextRange.m524getMaximpl(j2);
                    m525getMinimpl = TextRange.m525getMinimpl(j2);
                    r6 = m524getMaximpl - m525getMinimpl;
                } else {
                    int m525getMinimpl3 = TextRange.m525getMinimpl(j2);
                    if (m525getMinimpl2 >= TextRange.m524getMaximpl(j2) || m525getMinimpl3 > m525getMinimpl2) {
                        z4 = false;
                    }
                    if (z4) {
                        m525getMinimpl2 = TextRange.m525getMinimpl(j2);
                        r6 = TextRange.m524getMaximpl(j2) - TextRange.m525getMinimpl(j2);
                    } else {
                        m524getMaximpl2 = TextRange.m525getMinimpl(j2);
                    }
                }
            }
            return TextRangeKt.TextRange(m525getMinimpl2, m524getMaximpl2);
        }
        if (m524getMaximpl2 > TextRange.m525getMinimpl(j2)) {
            m525getMinimpl2 -= TextRange.m524getMaximpl(j2) - TextRange.m525getMinimpl(j2);
            m524getMaximpl = TextRange.m524getMaximpl(j2);
            m525getMinimpl = TextRange.m525getMinimpl(j2);
            r6 = m524getMaximpl - m525getMinimpl;
        }
        return TextRangeKt.TextRange(m525getMinimpl2, m524getMaximpl2);
        m524getMaximpl2 -= r6;
        return TextRangeKt.TextRange(m525getMinimpl2, m524getMaximpl2);
    }
}
