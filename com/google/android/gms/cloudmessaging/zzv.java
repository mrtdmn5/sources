package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import androidx.core.util.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzv implements Continuation {
    public static final /* synthetic */ zzv zza = new zzv();

    public static final InlineClassDescriptor InlinePrimitiveDescriptor(String str, final KSerializer kSerializer) {
        return new InlineClassDescriptor(str, new GeneratedSerializer<Object>() { // from class: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1
            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{kSerializer};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                Intrinsics.checkNotNullParameter(encoder, "encoder");
                throw new IllegalStateException("unsupported".toString());
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] typeParametersSerializers() {
                return Preconditions.EMPTY_SERIALIZER_ARRAY;
            }
        });
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        if (task.isSuccessful()) {
            return (Bundle) task.getResult();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(task.getException());
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Error making request: ");
            sb.append(valueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
    }
}
