package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: OnboardingWhatsNewFragment.kt */
/* loaded from: classes3.dex */
public final class WhatsNewUiItem {
    public static final int $stable = 0;
    private final int description;
    private final int title;

    public WhatsNewUiItem(int r1, int r2) {
        this.title = r1;
        this.description = r2;
    }

    public static /* synthetic */ WhatsNewUiItem copy$default(WhatsNewUiItem whatsNewUiItem, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = whatsNewUiItem.title;
        }
        if ((r3 & 2) != 0) {
            r2 = whatsNewUiItem.description;
        }
        return whatsNewUiItem.copy(r1, r2);
    }

    public final int component1() {
        return this.title;
    }

    public final int component2() {
        return this.description;
    }

    public final WhatsNewUiItem copy(int r2, int r3) {
        return new WhatsNewUiItem(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhatsNewUiItem)) {
            return false;
        }
        WhatsNewUiItem whatsNewUiItem = (WhatsNewUiItem) obj;
        if (this.title == whatsNewUiItem.title && this.description == whatsNewUiItem.description) {
            return true;
        }
        return false;
    }

    public final int getDescription() {
        return this.description;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.description) + (Integer.hashCode(this.title) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WhatsNewUiItem(title=");
        sb.append(this.title);
        sb.append(", description=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }
}
