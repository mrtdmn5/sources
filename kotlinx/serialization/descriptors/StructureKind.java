package kotlinx.serialization.descriptors;

/* compiled from: SerialKinds.kt */
/* loaded from: classes4.dex */
public abstract class StructureKind extends SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class CLASS extends StructureKind {
        public static final CLASS INSTANCE = new CLASS();

        public CLASS() {
            super(0);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class LIST extends StructureKind {
        public static final LIST INSTANCE = new LIST();

        public LIST() {
            super(0);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class MAP extends StructureKind {
        public static final MAP INSTANCE = new MAP();

        public MAP() {
            super(0);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class OBJECT extends StructureKind {
        public static final OBJECT INSTANCE = new OBJECT();

        public OBJECT() {
            super(0);
        }
    }

    public StructureKind(int r1) {
    }
}
