package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class CLSUUID {
    public static String _clsId;
    public static final AtomicLong _sequenceNumber = new AtomicLong(0);

    public CLSUUID(IdManager idManager) {
        long time = new Date().getTime();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) (time / 1000));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        byte[] array = allocate.array();
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(time % 1000);
        byte[] convertLongToTwoByteBuffer2 = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
        byte[] convertLongToTwoByteBuffer3 = convertLongToTwoByteBuffer(Integer.valueOf(Process.myPid()).shortValue());
        byte[] bArr = {array[0], array[1], array[2], array[3], convertLongToTwoByteBuffer[0], convertLongToTwoByteBuffer[1], convertLongToTwoByteBuffer2[0], convertLongToTwoByteBuffer2[1], convertLongToTwoByteBuffer3[0], convertLongToTwoByteBuffer3[1]};
        String sha1 = CommonUtils.sha1(idManager.getCrashlyticsInstallId());
        String hexify = CommonUtils.hexify(bArr);
        Locale locale = Locale.US;
        _clsId = String.format(locale, "%s%s%s%s", hexify.substring(0, 12), hexify.substring(12, 16), hexify.subSequence(16, 20), sha1.substring(0, 12)).toUpperCase(locale);
    }

    public static byte[] convertLongToTwoByteBuffer(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public final String toString() {
        return _clsId;
    }
}
