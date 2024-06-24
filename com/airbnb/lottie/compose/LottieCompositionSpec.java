package com.airbnb.lottie.compose;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LottieCompositionSpec.kt */
/* loaded from: classes.dex */
public interface LottieCompositionSpec {

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class Asset implements LottieCompositionSpec {
        public final String assetName;

        public final boolean equals(Object obj) {
            if (!(obj instanceof Asset)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.assetName, ((Asset) obj).assetName)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.assetName.hashCode();
        }

        public final String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Asset(assetName="), this.assetName, ')');
        }
    }

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class ContentProvider implements LottieCompositionSpec {
        public final boolean equals(Object obj) {
            if (!(obj instanceof ContentProvider)) {
                return false;
            }
            ((ContentProvider) obj).getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ContentProvider(uri=null)";
        }
    }

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class File implements LottieCompositionSpec {
        public final boolean equals(Object obj) {
            if (!(obj instanceof File)) {
                return false;
            }
            ((File) obj).getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "File(fileName=null)";
        }
    }

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class JsonString implements LottieCompositionSpec {
        public final boolean equals(Object obj) {
            if (!(obj instanceof JsonString)) {
                return false;
            }
            ((JsonString) obj).getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "JsonString(jsonString=null)";
        }
    }

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class RawRes implements LottieCompositionSpec {
        public final boolean equals(Object obj) {
            if (!(obj instanceof RawRes)) {
                return false;
            }
            ((RawRes) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return Integer.hashCode(0);
        }

        public final String toString() {
            return "RawRes(resId=0)";
        }
    }

    /* compiled from: LottieCompositionSpec.kt */
    /* loaded from: classes.dex */
    public static final class Url implements LottieCompositionSpec {
        public final boolean equals(Object obj) {
            if (!(obj instanceof Url)) {
                return false;
            }
            ((Url) obj).getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Url(url=null)";
        }
    }
}
