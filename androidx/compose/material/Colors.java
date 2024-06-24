package androidx.compose.material;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.ui.graphics.Color;
import com.google.common.collect.Platform;

/* compiled from: Colors.kt */
/* loaded from: classes.dex */
public final class Colors {
    public final ParcelableSnapshotMutableState background$delegate;
    public final ParcelableSnapshotMutableState error$delegate;
    public final ParcelableSnapshotMutableState isLight$delegate;
    public final ParcelableSnapshotMutableState onBackground$delegate;
    public final ParcelableSnapshotMutableState onError$delegate;
    public final ParcelableSnapshotMutableState onPrimary$delegate;
    public final ParcelableSnapshotMutableState onSecondary$delegate;
    public final ParcelableSnapshotMutableState onSurface$delegate;
    public final ParcelableSnapshotMutableState primary$delegate;
    public final ParcelableSnapshotMutableState primaryVariant$delegate;
    public final ParcelableSnapshotMutableState secondary$delegate;
    public final ParcelableSnapshotMutableState secondaryVariant$delegate;
    public final ParcelableSnapshotMutableState surface$delegate;

    public Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        Color color = new Color(j);
        StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
        this.primary$delegate = Platform.mutableStateOf(color, structuralEqualityPolicy);
        this.primaryVariant$delegate = Platform.mutableStateOf(new Color(j2), structuralEqualityPolicy);
        this.secondary$delegate = Platform.mutableStateOf(new Color(j3), structuralEqualityPolicy);
        this.secondaryVariant$delegate = Platform.mutableStateOf(new Color(j4), structuralEqualityPolicy);
        this.background$delegate = Platform.mutableStateOf(new Color(j5), structuralEqualityPolicy);
        this.surface$delegate = Platform.mutableStateOf(new Color(j6), structuralEqualityPolicy);
        this.error$delegate = Platform.mutableStateOf(new Color(j7), structuralEqualityPolicy);
        this.onPrimary$delegate = Platform.mutableStateOf(new Color(j8), structuralEqualityPolicy);
        this.onSecondary$delegate = Platform.mutableStateOf(new Color(j9), structuralEqualityPolicy);
        this.onBackground$delegate = Platform.mutableStateOf(new Color(j10), structuralEqualityPolicy);
        this.onSurface$delegate = Platform.mutableStateOf(new Color(j11), structuralEqualityPolicy);
        this.onError$delegate = Platform.mutableStateOf(new Color(j12), structuralEqualityPolicy);
        this.isLight$delegate = Platform.mutableStateOf(Boolean.valueOf(z), structuralEqualityPolicy);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m164getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m165getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m166getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m167getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m168getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m169getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m170getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m171getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m172getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m173getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m174getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        return "Colors(primary=" + ((Object) Color.m323toStringimpl(m170getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m323toStringimpl(m171getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m323toStringimpl(m172getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m323toStringimpl(m173getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m323toStringimpl(m164getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m323toStringimpl(m174getSurface0d7_KjU())) + ", error=" + ((Object) Color.m323toStringimpl(m165getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m323toStringimpl(m167getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m323toStringimpl(m168getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m323toStringimpl(m166getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m323toStringimpl(m169getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m323toStringimpl(((Color) this.onError$delegate.getValue()).value)) + ", isLight=" + isLight() + ')';
    }
}
