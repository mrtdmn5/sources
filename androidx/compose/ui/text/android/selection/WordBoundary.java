package androidx.compose.ui.text.android.selection;

import java.util.Locale;

/* compiled from: WordBoundary.kt */
/* loaded from: classes.dex */
public final class WordBoundary {
    public final WordIterator wordIterator;

    public WordBoundary(Locale locale, CharSequence charSequence) {
        this.wordIterator = new WordIterator(charSequence, charSequence.length(), locale);
    }
}
