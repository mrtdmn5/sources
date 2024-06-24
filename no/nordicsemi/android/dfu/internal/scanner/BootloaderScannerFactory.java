package no.nordicsemi.android.dfu.internal.scanner;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class BootloaderScannerFactory {
    private static final int ADDRESS_DIFF = 1;

    private BootloaderScannerFactory() {
    }

    public static String getIncrementedAddress(String str) {
        return ComposableInvoker$$ExternalSyntheticOutline0.m(str.substring(0, 15), String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255)));
    }

    public static BootloaderScanner getScanner(String str) {
        return new BootloaderScannerLollipop(str, getIncrementedAddress(str));
    }
}
