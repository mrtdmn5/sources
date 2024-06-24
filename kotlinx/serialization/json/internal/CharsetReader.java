package kotlinx.serialization.json.internal;

import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import io.ktor.utils.io.jvm.javaio.InputAdapter;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharsetReader.kt */
/* loaded from: classes4.dex */
public final class CharsetReader {
    public final ByteBuffer byteBuffer;
    public final CharsetDecoder decoder;
    public boolean hasLeftoverPotentiallySurrogateChar;
    public final InputStream inputStream;
    public char leftoverChar;

    public CharsetReader(InputAdapter inputAdapter, Charset charset) {
        byte[] bArr;
        byte[] removeLast;
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.inputStream = inputAdapter;
        CharsetDecoder onUnmappableCharacter = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        Intrinsics.checkNotNullExpressionValue(onUnmappableCharacter, "charset.newDecoder()\n   …odingErrorAction.REPLACE)");
        this.decoder = onUnmappableCharacter;
        ByteArrayPool8k byteArrayPool8k = ByteArrayPool8k.INSTANCE;
        synchronized (byteArrayPool8k) {
            ArrayDeque<byte[]> arrayDeque = byteArrayPool8k.arrays;
            bArr = null;
            if (arrayDeque.isEmpty()) {
                removeLast = null;
            } else {
                removeLast = arrayDeque.removeLast();
            }
            byte[] bArr2 = removeLast;
            if (bArr2 != null) {
                int length = bArr2.length / 2;
                bArr = bArr2;
            }
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr == null ? new byte[8196] : bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(ByteArrayPool8k.take())");
        this.byteBuffer = wrap;
    }

    public final int read(char[] array, int r12, int r13) {
        boolean z;
        boolean z2;
        int r2;
        CharsetDecoder charsetDecoder;
        int r5;
        char c;
        Intrinsics.checkNotNullParameter(array, "array");
        if (r13 == 0) {
            return 0;
        }
        boolean z3 = true;
        if (r12 >= 0 && r12 < array.length) {
            z = true;
        } else {
            z = false;
        }
        if (z && r13 >= 0 && r12 + r13 <= array.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.hasLeftoverPotentiallySurrogateChar) {
                array[r12] = this.leftoverChar;
                r12++;
                r13--;
                this.hasLeftoverPotentiallySurrogateChar = false;
                if (r13 == 0) {
                    return 1;
                }
                r2 = 1;
            } else {
                r2 = 0;
            }
            int r3 = -1;
            if (r13 == 1) {
                if (this.hasLeftoverPotentiallySurrogateChar) {
                    this.hasLeftoverPotentiallySurrogateChar = false;
                    c = this.leftoverChar;
                } else {
                    char[] cArr = new char[2];
                    int read = read(cArr, 0, 2);
                    if (read != -1) {
                        if (read != 1) {
                            if (read == 2) {
                                this.leftoverChar = cArr[1];
                                this.hasLeftoverPotentiallySurrogateChar = true;
                                c = cArr[0];
                            } else {
                                throw new IllegalStateException(("Unreachable state: " + read).toString());
                            }
                        } else {
                            c = cArr[0];
                        }
                    } else {
                        c = 65535;
                    }
                }
                if (c == 65535) {
                    if (r2 == 0) {
                        return -1;
                    }
                    return r2;
                }
                array[r12] = c;
                return r2 + 1;
            }
            CharBuffer wrap = CharBuffer.wrap(array, r12, r13);
            if (wrap.position() != 0) {
                wrap = wrap.slice();
            }
            CharBuffer charBuffer = wrap;
            boolean z4 = false;
            while (true) {
                charsetDecoder = this.decoder;
                ByteBuffer byteBuffer = this.byteBuffer;
                CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z4);
                if (decode.isUnderflow()) {
                    if (z4 || !charBuffer.hasRemaining()) {
                        break;
                    }
                    byteBuffer.compact();
                    try {
                        int limit = byteBuffer.limit();
                        int position = byteBuffer.position();
                        if (position <= limit) {
                            r5 = limit - position;
                        } else {
                            r5 = 0;
                        }
                        int read2 = this.inputStream.read(byteBuffer.array(), byteBuffer.arrayOffset() + position, r5);
                        if (read2 >= 0) {
                            read2 = byteBuffer.remaining();
                        }
                        if (read2 < 0) {
                            if (charBuffer.position() == 0 && !byteBuffer.hasRemaining()) {
                                break;
                            }
                            charsetDecoder.reset();
                            z4 = true;
                        } else {
                            continue;
                        }
                    } finally {
                    }
                } else {
                    if (decode.isOverflow()) {
                        charBuffer.position();
                        break;
                    }
                    decode.throwException();
                }
            }
            z3 = z4;
            if (z3) {
                charsetDecoder.reset();
            }
            if (charBuffer.position() != 0) {
                r3 = charBuffer.position();
            }
            return r3 + r2;
        }
        StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Unexpected arguments: ", r12, ", ", r13, ", ");
        m.append(array.length);
        throw new IllegalArgumentException(m.toString().toString());
    }
}
