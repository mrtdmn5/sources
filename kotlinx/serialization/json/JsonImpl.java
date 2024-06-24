package kotlinx.serialization.json;

import com.google.common.hash.AbstractHasher;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.SerializersModuleKt;

/* compiled from: Json.kt */
/* loaded from: classes4.dex */
public final class JsonImpl extends Json {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonImpl(JsonConfiguration jsonConfiguration, AbstractHasher module) {
        super(jsonConfiguration, module);
        Intrinsics.checkNotNullParameter(module, "module");
        if (!Intrinsics.areEqual(module, SerializersModuleKt.EmptySerializersModule)) {
            module.dumpTo(new PolymorphismValidator(jsonConfiguration.useArrayPolymorphism, jsonConfiguration.classDiscriminator));
        }
    }
}
