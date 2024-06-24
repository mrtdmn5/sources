package com.animaconnected.secondo.provider;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.animaconnected.secondo.BuildConfig;
import com.animaconnected.secondo.provider.misc.ConfigProvider;
import com.kronaby.watch.app.R;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ConfigProviderImpl implements ConfigProvider {
    private final Context mContext;

    public ConfigProviderImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.animaconnected.secondo.provider.misc.ConfigProvider
    public String getBuildType() {
        return "release";
    }

    @Override // com.animaconnected.secondo.provider.misc.ConfigProvider
    public Locale getTranslationCompatibleLocale() {
        Resources resources = this.mContext.getResources();
        Locale userLocale = getUserLocale();
        Locale.Builder builder = new Locale.Builder();
        builder.setLanguageTag(resources.getString(R.string.language_tag_compat));
        Locale build = builder.build();
        if (build.getLanguage().equalsIgnoreCase(userLocale.getLanguage()) && (TextUtils.isEmpty(build.getCountry()) || build.getCountry().equalsIgnoreCase(userLocale.getCountry()))) {
            return userLocale;
        }
        builder.setLanguageTag(resources.getString(R.string.language_tag_when_not_compat));
        return builder.build();
    }

    @Override // com.animaconnected.secondo.provider.misc.ConfigProvider
    public Locale getUserLocale() {
        return Locale.getDefault();
    }

    @Override // com.animaconnected.secondo.provider.misc.ConfigProvider
    public int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    @Override // com.animaconnected.secondo.provider.misc.ConfigProvider
    public String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }
}
