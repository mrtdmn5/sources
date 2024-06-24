package aws.smithy.kotlin.runtime.serde;

import kotlin.jvm.internal.Reflection;

/* compiled from: SdkFieldDescriptor.kt */
/* loaded from: classes.dex */
public abstract class SerialKind {

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Boolean extends SerialKind {
        public static final Boolean INSTANCE = new Boolean();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Enum extends SerialKind {
        public static final Enum INSTANCE = new Enum();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Integer extends SerialKind {
        public static final Integer INSTANCE = new Integer();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class List extends SerialKind {
        public static final List INSTANCE = new List();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Map extends SerialKind {
        public static final Map INSTANCE = new Map();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class String extends SerialKind {
        public static final String INSTANCE = new String();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Struct extends SerialKind {
        public static final Struct INSTANCE = new Struct();
    }

    /* compiled from: SdkFieldDescriptor.kt */
    /* loaded from: classes.dex */
    public static final class Timestamp extends SerialKind {
        public static final Timestamp INSTANCE = new Timestamp();
    }

    public final java.lang.String toString() {
        java.lang.String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (simpleName == null) {
            return "SerialKind";
        }
        return simpleName;
    }
}
