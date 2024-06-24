package com.animaconnected.watch.image;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amplifyframework.core.model.ModelIdentifier;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Graphics.kt */
/* loaded from: classes3.dex */
public final class Kolor {
    public static final Companion Companion = new Companion(null);
    private final int argb;

    /* compiled from: Graphics.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: fromArgb-pWQ4cJ4$default, reason: not valid java name */
        public static /* synthetic */ int m1547fromArgbpWQ4cJ4$default(Companion companion, int r1, int r2, int r3, int r4, int r5, Object obj) {
            if ((r5 & 8) != 0) {
                r4 = 255;
            }
            return companion.m1548fromArgbpWQ4cJ4(r1, r2, r3, r4);
        }

        /* renamed from: fromArgb-pWQ4cJ4, reason: not valid java name */
        public final int m1548fromArgbpWQ4cJ4(int r1, int r2, int r3, int r4) {
            return Kolor.m1537constructorimpl((r1 << 16) | (r4 << 24) | (r2 << 8) | r3);
        }

        /* renamed from: fromHex-dD1lZlY, reason: not valid java name */
        public final int m1549fromHexdD1lZlY(final String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            try {
                String padStart = StringsKt__StringsKt.padStart(StringsKt__StringsKt.removePrefix(ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER, hexString), 8, 'F');
                CharsKt__CharKt.checkRadix(16);
                return Kolor.m1537constructorimpl((int) Long.parseLong(padStart, 16));
            } catch (Exception e) {
                LogKt.warn$default((Object) this, DetailBottomDialog.keyColor, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.image.Kolor$Companion$fromHex$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("hex "), hexString, " isn't valid, returning black");
                    }
                }, 4, (Object) null);
                return Kolor.m1537constructorimpl(Kolors.black);
            }
        }

        private Companion() {
        }
    }

    private /* synthetic */ Kolor(int r1) {
        this.argb = r1;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Kolor m1536boximpl(int r1) {
        return new Kolor(r1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1538equalsimpl(int r2, Object obj) {
        if (!(obj instanceof Kolor) || r2 != ((Kolor) obj).m1546unboximpl()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1539equalsimpl0(int r0, int r1) {
        if (r0 == r1) {
            return true;
        }
        return false;
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final int m1540getAlphaimpl(int r0) {
        return (r0 >>> 24) & 255;
    }

    /* renamed from: getBlue-impl, reason: not valid java name */
    public static final int m1541getBlueimpl(int r0) {
        return r0 & 255;
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final int m1542getGreenimpl(int r0) {
        return (r0 >>> 8) & 255;
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final int m1543getRedimpl(int r0) {
        return (r0 >>> 16) & 255;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1544hashCodeimpl(int r0) {
        return Integer.hashCode(r0);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1545toStringimpl(int r2) {
        return "Kolor(red=" + m1543getRedimpl(r2) + ", green=" + m1542getGreenimpl(r2) + ", blue=" + m1541getBlueimpl(r2) + ", alpha=" + m1540getAlphaimpl(r2) + ')';
    }

    public boolean equals(Object obj) {
        return m1538equalsimpl(this.argb, obj);
    }

    public final int getArgb() {
        return this.argb;
    }

    public int hashCode() {
        return m1544hashCodeimpl(this.argb);
    }

    public String toString() {
        return m1545toStringimpl(this.argb);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1546unboximpl() {
        return this.argb;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1537constructorimpl(int r0) {
        return r0;
    }
}
