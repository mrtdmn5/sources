package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$CharacterTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static AccessibilityIterators$CharacterTextSegmentIterator instance;
    public BreakIterator impl;

    public AccessibilityIterators$CharacterTextSegmentIterator(Locale locale) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(locale);
        Intrinsics.checkNotNullExpressionValue(characterInstance, "getCharacterInstance(locale)");
        this.impl = characterInstance;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] following(int r5) {
        int length = getText().length();
        if (length <= 0 || r5 >= length) {
            return null;
        }
        if (r5 < 0) {
            r5 = 0;
        }
        do {
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                if (!breakIterator.isBoundary(r5)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 != null) {
                        r5 = breakIterator2.following(r5);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 != null) {
                        int following = breakIterator3.following(r5);
                        if (following == -1) {
                            return null;
                        }
                        return getRange(r5, following);
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                throw null;
            }
        } while (r5 != -1);
        return null;
    }

    public final void initialize(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        BreakIterator breakIterator = this.impl;
        if (breakIterator != null) {
            breakIterator.setText(text);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            throw null;
        }
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] preceding(int r5) {
        int length = getText().length();
        if (length <= 0 || r5 <= 0) {
            return null;
        }
        if (r5 > length) {
            r5 = length;
        }
        do {
            BreakIterator breakIterator = this.impl;
            if (breakIterator != null) {
                if (!breakIterator.isBoundary(r5)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 != null) {
                        r5 = breakIterator2.preceding(r5);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 != null) {
                        int preceding = breakIterator3.preceding(r5);
                        if (preceding == -1) {
                            return null;
                        }
                        return getRange(preceding, r5);
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                throw null;
            }
        } while (r5 != -1);
        return null;
    }
}
