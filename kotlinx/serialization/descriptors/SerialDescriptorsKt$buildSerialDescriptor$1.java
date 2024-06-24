package kotlinx.serialization.descriptors;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes4.dex */
public final class SerialDescriptorsKt$buildSerialDescriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public static final SerialDescriptorsKt$buildSerialDescriptor$1 INSTANCE = new SerialDescriptorsKt$buildSerialDescriptor$1();

    public SerialDescriptorsKt$buildSerialDescriptor$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$null");
        return Unit.INSTANCE;
    }
}
