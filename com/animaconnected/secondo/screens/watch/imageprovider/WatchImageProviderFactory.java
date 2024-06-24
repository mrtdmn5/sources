package com.animaconnected.secondo.screens.watch.imageprovider;

import com.animaconnected.secondo.provider.ProviderFactory;

/* loaded from: classes3.dex */
public class WatchImageProviderFactory {
    private WatchImageProviderFactory() {
    }

    public static WatchImageProvider createWatchImageProvider() {
        if (ProviderFactory.getWatch().getCapabilities().hasOneSubComplication()) {
            return new WatchWithOneSubComplicationImageProvider();
        }
        if (ProviderFactory.getWatch().getCapabilities().hasTwoSubComplications()) {
            return new WatchWithTwoSubComplicationsImageProvider();
        }
        return new WatchImageProvider();
    }
}
