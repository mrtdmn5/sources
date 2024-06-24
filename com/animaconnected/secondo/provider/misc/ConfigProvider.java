package com.animaconnected.secondo.provider.misc;

import java.util.Locale;

/* loaded from: classes3.dex */
public interface ConfigProvider {
    String getBuildType();

    Locale getTranslationCompatibleLocale();

    Locale getUserLocale();

    int getVersionCode();

    String getVersionName();
}
