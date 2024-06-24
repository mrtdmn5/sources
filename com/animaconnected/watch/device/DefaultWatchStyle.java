package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.display.Font;
import com.animaconnected.watch.display.FontType;
import com.animaconnected.watch.image.Kolor;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchStyle.kt */
/* loaded from: classes3.dex */
public final class DefaultWatchStyle implements WatchStyle {
    private final int defaultBackgroundColor;
    private final int defaultForegroundColor;
    private final int defaultHighlightColor;
    private final String keyBackgroundHex;
    private final String keyForegroundHex;
    private final String keyHighlightHex;
    private final BasicStorage storage;

    public DefaultWatchStyle(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.keyBackgroundHex = identifier.concat("-background");
        this.keyForegroundHex = identifier.concat("-foreground");
        this.keyHighlightHex = identifier.concat("-highlight");
        this.storage = ServiceLocator.INSTANCE.getStorageFactory().createStorage(identifier.concat("-display-colors"));
        Kolor.Companion companion = Kolor.Companion;
        this.defaultBackgroundColor = companion.m1548fromArgbpWQ4cJ4(0, 0, 0, 0);
        this.defaultForegroundColor = companion.m1548fromArgbpWQ4cJ4(255, 255, 255, 0);
        this.defaultHighlightColor = companion.m1548fromArgbpWQ4cJ4(255, 255, 255, 0);
    }

    /* renamed from: asKolor-UOS_SDQ, reason: not valid java name */
    private final Kolor m1064asKolorUOS_SDQ(String str) {
        if (isValidHex(str)) {
            return Kolor.m1536boximpl(Kolor.Companion.m1549fromHexdD1lZlY(str));
        }
        LogKt.debug$default((Object) str, zzav$$ExternalSyntheticOutline0.m("Color (", str, ") is not a valid hex. Must be in the format #RRGGBB."), (String) null, (Throwable) null, false, 14, (Object) null);
        return null;
    }

    private final WatchDisplayColors getDisplayColors() {
        int r3;
        int r32;
        int r33;
        boolean z;
        String string = this.storage.getString(this.keyBackgroundHex);
        String str = "";
        if (string == null) {
            string = "";
        }
        Kolor m1064asKolorUOS_SDQ = m1064asKolorUOS_SDQ(string);
        String string2 = this.storage.getString(this.keyForegroundHex);
        if (string2 == null) {
            string2 = "";
        }
        Kolor m1064asKolorUOS_SDQ2 = m1064asKolorUOS_SDQ(string2);
        String string3 = this.storage.getString(this.keyHighlightHex);
        if (string3 != null) {
            str = string3;
        }
        Kolor m1064asKolorUOS_SDQ3 = m1064asKolorUOS_SDQ(str);
        if (m1064asKolorUOS_SDQ != null) {
            r3 = m1064asKolorUOS_SDQ.m1546unboximpl();
        } else {
            r3 = this.defaultBackgroundColor;
        }
        int r4 = r3;
        if (m1064asKolorUOS_SDQ2 != null) {
            r32 = m1064asKolorUOS_SDQ2.m1546unboximpl();
        } else {
            r32 = this.defaultForegroundColor;
        }
        int r5 = r32;
        if (m1064asKolorUOS_SDQ3 != null) {
            r33 = m1064asKolorUOS_SDQ3.m1546unboximpl();
        } else {
            r33 = this.defaultHighlightColor;
        }
        int r6 = r33;
        if (m1064asKolorUOS_SDQ == null && m1064asKolorUOS_SDQ2 == null && m1064asKolorUOS_SDQ3 == null) {
            z = false;
        } else {
            z = true;
        }
        return new WatchDisplayColors(r4, r5, r6, z, null);
    }

    private final boolean isValidHex(String input) {
        Pattern compile = Pattern.compile("^#[0-9a-fA-F]{6}");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Intrinsics.checkNotNullParameter(input, "input");
        return compile.matcher(input).find();
    }

    @Override // com.animaconnected.watch.device.WatchStyle
    public WatchDisplayColors getColors() {
        return getDisplayColors();
    }

    @Override // com.animaconnected.watch.device.WatchStyle
    public Font getFont(FontType fontType) {
        Intrinsics.checkNotNullParameter(fontType, "fontType");
        return WatchStyleKt.toWatchFont(fontType);
    }

    @Override // com.animaconnected.watch.device.WatchStyle
    public void setBackgroundColor(String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Kolor m1064asKolorUOS_SDQ = m1064asKolorUOS_SDQ(hex);
        if (m1064asKolorUOS_SDQ != null) {
            m1064asKolorUOS_SDQ.m1546unboximpl();
            this.storage.put(this.keyBackgroundHex, hex);
        }
    }

    @Override // com.animaconnected.watch.device.WatchStyle
    public void setForegroundColor(String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Kolor m1064asKolorUOS_SDQ = m1064asKolorUOS_SDQ(hex);
        if (m1064asKolorUOS_SDQ != null) {
            m1064asKolorUOS_SDQ.m1546unboximpl();
            this.storage.put(this.keyForegroundHex, hex);
        }
    }

    @Override // com.animaconnected.watch.device.WatchStyle
    public void setHighlightColor(String hex) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Kolor m1064asKolorUOS_SDQ = m1064asKolorUOS_SDQ(hex);
        if (m1064asKolorUOS_SDQ != null) {
            m1064asKolorUOS_SDQ.m1546unboximpl();
            this.storage.put(this.keyHighlightHex, hex);
        }
    }
}
