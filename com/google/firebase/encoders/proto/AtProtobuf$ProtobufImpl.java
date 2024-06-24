package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public final class AtProtobuf$ProtobufImpl implements Protobuf {
    public final Protobuf.IntEncoding intEncoding;
    public final int tag;

    public AtProtobuf$ProtobufImpl(int r1, Protobuf.IntEncoding intEncoding) {
        this.tag = r1;
        this.intEncoding = intEncoding;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return Protobuf.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Protobuf)) {
            return false;
        }
        Protobuf protobuf = (Protobuf) obj;
        if (this.tag == ((AtProtobuf$ProtobufImpl) protobuf).tag && this.intEncoding.equals(((AtProtobuf$ProtobufImpl) protobuf).intEncoding)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.tag) + (this.intEncoding.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.tag + "intEncoding=" + this.intEncoding + ')';
    }
}
