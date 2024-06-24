package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class FocusStrategy {

    /* loaded from: classes.dex */
    public interface BoundsAdapter<T> {
    }

    /* loaded from: classes.dex */
    public static class SequentialComparator<T> implements Comparator<T> {
        public final BoundsAdapter<T> mAdapter;
        public final boolean mIsLayoutRtl;
        public final Rect mTemp1 = new Rect();
        public final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z, ExploreByTouchHelper.AnonymousClass1 anonymousClass1) {
            this.mIsLayoutRtl = z;
            this.mAdapter = anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            ExploreByTouchHelper.AnonymousClass1 anonymousClass1 = (ExploreByTouchHelper.AnonymousClass1) this.mAdapter;
            anonymousClass1.getClass();
            Rect rect = this.mTemp1;
            ((AccessibilityNodeInfoCompat) t).getBoundsInParent(rect);
            anonymousClass1.getClass();
            Rect rect2 = this.mTemp2;
            ((AccessibilityNodeInfoCompat) t2).getBoundsInParent(rect2);
            int r7 = rect.top;
            int r0 = rect2.top;
            if (r7 < r0) {
                return -1;
            }
            if (r7 > r0) {
                return 1;
            }
            int r72 = rect.left;
            int r02 = rect2.left;
            boolean z = this.mIsLayoutRtl;
            if (r72 < r02) {
                if (!z) {
                    return -1;
                }
                return 1;
            }
            if (r72 > r02) {
                if (z) {
                    return -1;
                }
                return 1;
            }
            int r73 = rect.bottom;
            int r03 = rect2.bottom;
            if (r73 < r03) {
                return -1;
            }
            if (r73 > r03) {
                return 1;
            }
            int r74 = rect.right;
            int r6 = rect2.right;
            if (r74 < r6) {
                if (!z) {
                    return -1;
                }
                return 1;
            }
            if (r74 > r6) {
                if (z) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:            if (r10.bottom <= r12.top) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:            r7 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0043, code lost:            r7 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0033, code lost:            if (r10.right <= r12.left) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x003a, code lost:            if (r10.top >= r12.bottom) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0041, code lost:            if (r10.left >= r12.right) goto L24;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean beamBeats(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = beamsOverlap(r9, r10, r11)
            boolean r1 = beamsOverlap(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L7d
            if (r0 != 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L45
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L45
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L45
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L45
        L43:
            r7 = r6
            goto L46
        L45:
            r7 = r2
        L46:
            if (r7 != 0) goto L49
            return r6
        L49:
            if (r9 == r5) goto L7c
            if (r9 != r4) goto L4e
            goto L7c
        L4e:
            int r11 = majorAxisDistance(r9, r10, r11)
            if (r9 == r5) goto L6f
            if (r9 == r3) goto L6a
            if (r9 == r4) goto L65
            if (r9 != r1) goto L5f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L73
        L5f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L65:
            int r9 = r12.right
            int r10 = r10.right
            goto L73
        L6a:
            int r9 = r10.top
            int r10 = r12.top
            goto L73
        L6f:
            int r9 = r10.left
            int r10 = r12.left
        L73:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L7b
            r2 = r6
        L7b:
            return r2
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.FocusStrategy.beamBeats(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean beamsOverlap(int r3, Rect rect, Rect rect2) {
        if (r3 != 17) {
            if (r3 != 33) {
                if (r3 != 66) {
                    if (r3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right >= rect.left && rect2.left <= rect.right) {
                return true;
            }
            return false;
        }
        if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) {
            return true;
        }
        return false;
    }

    public static boolean isCandidate(int r3, Rect rect, Rect rect2) {
        if (r3 != 17) {
            if (r3 != 33) {
                if (r3 != 66) {
                    if (r3 == 130) {
                        int r32 = rect.top;
                        int r0 = rect2.top;
                        if ((r32 < r0 || rect.bottom <= r0) && rect.bottom < rect2.bottom) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int r33 = rect.left;
                int r02 = rect2.left;
                if ((r33 < r02 || rect.right <= r02) && rect.right < rect2.right) {
                    return true;
                }
                return false;
            }
            int r34 = rect.bottom;
            int r03 = rect2.bottom;
            if ((r34 > r03 || rect.top >= r03) && rect.top > rect2.top) {
                return true;
            }
            return false;
        }
        int r35 = rect.right;
        int r04 = rect2.right;
        if ((r35 > r04 || rect.left >= r04) && rect.left > rect2.left) {
            return true;
        }
        return false;
    }

    public static int majorAxisDistance(int r1, Rect rect, Rect rect2) {
        int r12;
        int r2;
        if (r1 != 17) {
            if (r1 != 33) {
                if (r1 != 66) {
                    if (r1 == 130) {
                        r12 = rect2.top;
                        r2 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    r12 = rect2.left;
                    r2 = rect.right;
                }
            } else {
                r12 = rect.top;
                r2 = rect2.bottom;
            }
        } else {
            r12 = rect.left;
            r2 = rect2.right;
        }
        return Math.max(0, r12 - r2);
    }

    public static int minorAxisDistance(int r1, Rect rect, Rect rect2) {
        if (r1 != 17) {
            if (r1 != 33) {
                if (r1 != 66) {
                    if (r1 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
