package com.google.firebase.messaging;

import app.cash.sqldelight.ColumnAdapter;
import app.cash.sqldelight.db.SqlCursor;
import com.google.android.datatransport.Transformer;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class MessagingAnalytics$$ExternalSyntheticLambda0 implements Transformer {
    public static Object m(SqlCursor sqlCursor, int r1, ColumnAdapter columnAdapter) {
        String string = sqlCursor.getString(r1);
        Intrinsics.checkNotNull(string);
        return columnAdapter.decode(string);
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        MessagingClientEventExtension messagingClientEventExtension = (MessagingClientEventExtension) obj;
        messagingClientEventExtension.getClass();
        ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.ENCODER;
        protobufEncoder.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            protobufEncoder.encode(messagingClientEventExtension, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
