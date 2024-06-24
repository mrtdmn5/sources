package kotlinx.serialization.descriptors;

/* compiled from: SerialKinds.kt */
/* loaded from: classes4.dex */
public abstract class PolymorphicKind extends SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class OPEN extends PolymorphicKind {
        public static final OPEN INSTANCE = new OPEN();

        public OPEN() {
            super(0);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class SEALED extends PolymorphicKind {
        public static final SEALED INSTANCE = new SEALED();

        public SEALED() {
            super(0);
        }
    }

    public PolymorphicKind(int r1) {
    }
}
