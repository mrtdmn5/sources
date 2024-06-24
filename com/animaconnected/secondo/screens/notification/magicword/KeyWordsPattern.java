package com.animaconnected.secondo.screens.notification.magicword;

import com.google.gson.annotations.SerializedName;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class KeyWordsPattern {

    @SerializedName("pattern")
    public Pattern pattern;

    public String toString() {
        return "Pattern: " + this.pattern;
    }
}
