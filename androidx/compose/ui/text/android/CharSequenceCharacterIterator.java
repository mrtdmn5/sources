package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharSequenceCharacterIterator.kt */
/* loaded from: classes.dex */
public final class CharSequenceCharacterIterator implements CharacterIterator {
    public final CharSequence charSequence;
    public final int end;
    public final int start = 0;
    public int index = 0;

    public CharSequenceCharacterIterator(int r1, CharSequence charSequence) {
        this.charSequence = charSequence;
        this.end = r1;
    }

    @Override // java.text.CharacterIterator
    public final Object clone() {
        try {
            Object clone = super.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "{\n            @Suppress(…  super.clone()\n        }");
            return clone;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public final char current() {
        int r0 = this.index;
        if (r0 == this.end) {
            return (char) 65535;
        }
        return this.charSequence.charAt(r0);
    }

    @Override // java.text.CharacterIterator
    public final char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public final int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public final int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public final int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public final char last() {
        int r0 = this.start;
        int r1 = this.end;
        if (r0 == r1) {
            this.index = r1;
            return (char) 65535;
        }
        int r12 = r1 - 1;
        this.index = r12;
        return this.charSequence.charAt(r12);
    }

    @Override // java.text.CharacterIterator
    public final char next() {
        int r0 = this.index + 1;
        this.index = r0;
        int r1 = this.end;
        if (r0 >= r1) {
            this.index = r1;
            return (char) 65535;
        }
        return this.charSequence.charAt(r0);
    }

    @Override // java.text.CharacterIterator
    public final char previous() {
        int r0 = this.index;
        if (r0 <= this.start) {
            return (char) 65535;
        }
        int r02 = r0 - 1;
        this.index = r02;
        return this.charSequence.charAt(r02);
    }

    @Override // java.text.CharacterIterator
    public final char setIndex(int r3) {
        boolean z = false;
        if (r3 <= this.end && this.start <= r3) {
            z = true;
        }
        if (z) {
            this.index = r3;
            return current();
        }
        throw new IllegalArgumentException("invalid position");
    }
}
