package com.animaconnected.watch.strings;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.display.view.DisplayString;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StringsExtensions.kt */
/* loaded from: classes3.dex */
public abstract class KeyString implements DisplayString {
    public /* synthetic */ KeyString(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String app() {
        if (this instanceof Translated) {
            Translated translated = (Translated) this;
            return StringsExtensionsKt.access$getStringFromKey(translated.getKey(), ServiceLocator.INSTANCE.getStringsBackend().getLanguage(), translated.getValues());
        }
        if (this instanceof Static) {
            return ((Static) this).getText();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String english() {
        if (this instanceof Translated) {
            Translated translated = (Translated) this;
            return StringsExtensionsKt.access$getStringFromKey(translated.getKey(), Language.EN, translated.getValues());
        }
        if (this instanceof Static) {
            return ((Static) this).getText();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.animaconnected.watch.display.view.DisplayString
    public String firmware() {
        if (this instanceof Translated) {
            Language language = ServiceLocator.INSTANCE.getStringsBackend().getLanguage();
            if (language.getLatinSupported()) {
                Translated translated = (Translated) this;
                return StringsExtensionsKt.access$getStringFromKey(translated.getKey(), language, translated.getValues());
            }
            Translated translated2 = (Translated) this;
            return StringsExtensionsKt.access$getStringFromKey(translated2.getKey(), Language.EN, translated2.getValues());
        }
        if (this instanceof Static) {
            return ((Static) this).getText();
        }
        throw new NoWhenBranchMatchedException();
    }

    private KeyString() {
    }
}
