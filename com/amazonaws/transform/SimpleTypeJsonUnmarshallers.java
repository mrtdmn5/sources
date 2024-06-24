package com.amazonaws.transform;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class SimpleTypeJsonUnmarshallers {

    /* renamed from: com.amazonaws.transform.SimpleTypeJsonUnmarshallers$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$transform$TimestampFormat;

        static {
            int[] r0 = new int[TimestampFormat.values().length];
            $SwitchMap$com$amazonaws$transform$TimestampFormat = r0;
            try {
                r0[TimestampFormat.ISO_8601.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$transform$TimestampFormat[TimestampFormat.RFC_822.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$transform$TimestampFormat[TimestampFormat.UNIX_TIMESTAMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BigDecimalJsonUnmarshaller implements Unmarshaller<BigDecimal, JsonUnmarshallerContext> {
        private static BigDecimalJsonUnmarshaller instance;

        public static BigDecimalJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public BigDecimal unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigDecimal(nextString);
        }
    }

    /* loaded from: classes.dex */
    public static class BigIntegerJsonUnmarshaller implements Unmarshaller<BigInteger, JsonUnmarshallerContext> {
        private static BigIntegerJsonUnmarshaller instance;

        public static BigIntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public BigInteger unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return new BigInteger(nextString);
        }
    }

    /* loaded from: classes.dex */
    public static class BooleanJsonUnmarshaller implements Unmarshaller<Boolean, JsonUnmarshallerContext> {
        private static BooleanJsonUnmarshaller instance;

        public static BooleanJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Boolean unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(nextString));
        }
    }

    /* loaded from: classes.dex */
    public static class ByteBufferJsonUnmarshaller implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext> {
        private static ByteBufferJsonUnmarshaller instance;

        public static ByteBufferJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public ByteBuffer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(jsonUnmarshallerContext.getReader().nextString()));
        }
    }

    /* loaded from: classes.dex */
    public static class ByteJsonUnmarshaller implements Unmarshaller<Byte, JsonUnmarshallerContext> {
        private static ByteJsonUnmarshaller instance;

        public static ByteJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Byte unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Byte.valueOf(nextString);
        }
    }

    /* loaded from: classes.dex */
    public static class DateJsonUnmarshaller implements Unmarshaller<Date, JsonUnmarshallerContext> {
        private static final int DATE_MULTIPLIER = 1000;
        private static DateJsonUnmarshaller instance;
        private final TimestampFormat format;

        private DateJsonUnmarshaller(TimestampFormat timestampFormat) {
            this.format = timestampFormat;
        }

        public static DateJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateJsonUnmarshaller(TimestampFormat.UNIX_TIMESTAMP);
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Date unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            try {
                int r0 = AnonymousClass1.$SwitchMap$com$amazonaws$transform$TimestampFormat[this.format.ordinal()];
                if (r0 == 1) {
                    return DateUtils.parseISO8601Date(nextString);
                }
                if (r0 != 2) {
                    return new Date(NumberFormat.getInstance(new Locale("en")).parse(nextString).longValue() * 1000);
                }
                return DateUtils.parseRFC822Date(nextString);
            } catch (IllegalArgumentException | ParseException e) {
                throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, ActivityResultRegistry$$ExternalSyntheticOutline0.m("Unable to parse date '", nextString, "':  ")), e);
            }
        }

        public static DateJsonUnmarshaller getInstance(TimestampFormat timestampFormat) {
            DateJsonUnmarshaller dateJsonUnmarshaller = instance;
            if (dateJsonUnmarshaller == null || !dateJsonUnmarshaller.format.equals(timestampFormat)) {
                instance = new DateJsonUnmarshaller(timestampFormat);
            }
            return instance;
        }
    }

    /* loaded from: classes.dex */
    public static class DoubleJsonUnmarshaller implements Unmarshaller<Double, JsonUnmarshallerContext> {
        private static DoubleJsonUnmarshaller instance;

        public static DoubleJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Double unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(nextString));
        }
    }

    /* loaded from: classes.dex */
    public static class FloatJsonUnmarshaller implements Unmarshaller<Float, JsonUnmarshallerContext> {
        private static FloatJsonUnmarshaller instance;

        public static FloatJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Float unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Float.valueOf(nextString);
        }
    }

    /* loaded from: classes.dex */
    public static class IntegerJsonUnmarshaller implements Unmarshaller<Integer, JsonUnmarshallerContext> {
        private static IntegerJsonUnmarshaller instance;

        public static IntegerJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Integer unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(nextString));
        }
    }

    /* loaded from: classes.dex */
    public static class LongJsonUnmarshaller implements Unmarshaller<Long, JsonUnmarshallerContext> {
        private static LongJsonUnmarshaller instance;

        public static LongJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public Long unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String nextString = jsonUnmarshallerContext.getReader().nextString();
            if (nextString == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(nextString));
        }
    }

    /* loaded from: classes.dex */
    public static class StringJsonUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
        private static StringJsonUnmarshaller instance;

        public static StringJsonUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringJsonUnmarshaller();
            }
            return instance;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        public String unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return jsonUnmarshallerContext.getReader().nextString();
        }
    }
}
