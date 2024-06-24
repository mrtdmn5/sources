package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes3.dex */
public abstract class ChaCha20Base implements IndCpaCipher {
    public static final int[] SIGMA = toIntArray(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    public final int initialCounter;
    public final int[] key;

    public ChaCha20Base(final byte[] key, int initialCounter) throws InvalidKeyException {
        if (key.length == 32) {
            this.key = toIntArray(key);
            this.initialCounter = initialCounter;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public static void quarterRound(int x, int a, int b, int c, int[] d) {
        int r0 = d[x] + d[a];
        d[x] = r0;
        int r02 = r0 ^ d[c];
        int r03 = (r02 >>> (-16)) | (r02 << 16);
        d[c] = r03;
        int r1 = d[b] + r03;
        d[b] = r1;
        int r04 = d[a] ^ r1;
        int r05 = (r04 >>> (-12)) | (r04 << 12);
        d[a] = r05;
        int r12 = d[x] + r05;
        d[x] = r12;
        int r2 = d[c] ^ r12;
        int r22 = (r2 >>> (-8)) | (r2 << 8);
        d[c] = r22;
        int r5 = d[b] + r22;
        d[b] = r5;
        int r23 = d[a] ^ r5;
        d[a] = (r23 >>> (-7)) | (r23 << 7);
    }

    public static void shuffleState(final int[] state) {
        for (int r2 = 0; r2 < 10; r2++) {
            quarterRound(0, 4, 8, 12, state);
            quarterRound(1, 5, 9, 13, state);
            quarterRound(2, 6, 10, 14, state);
            quarterRound(3, 7, 11, 15, state);
            quarterRound(0, 5, 10, 15, state);
            quarterRound(1, 6, 11, 12, state);
            quarterRound(2, 7, 8, 13, state);
            quarterRound(3, 4, 9, 14, state);
        }
    }

    public static int[] toIntArray(final byte[] input) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] r0 = new int[asIntBuffer.remaining()];
        asIntBuffer.get(r0);
        return r0;
    }

    public final ByteBuffer chacha20Block(final int nonce, byte[] counter) {
        int[] createInitialState = createInitialState(toIntArray(counter), nonce);
        int[] r6 = (int[]) createInitialState.clone();
        shuffleState(r6);
        for (int r1 = 0; r1 < createInitialState.length; r1++) {
            createInitialState[r1] = createInitialState[r1] + r6[r1];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    public abstract int[] createInitialState(final int[] nonce, int counter);

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public final byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(ciphertext));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public final byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        if (plaintext.length <= Integer.MAX_VALUE - nonceSizeInBytes()) {
            ByteBuffer allocate = ByteBuffer.allocate(nonceSizeInBytes() + plaintext.length);
            encrypt(allocate, plaintext);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract int nonceSizeInBytes();

    public final void process(final byte[] nonce, ByteBuffer output, ByteBuffer input) throws GeneralSecurityException {
        int remaining = input.remaining();
        int r1 = (remaining / 64) + 1;
        for (int r2 = 0; r2 < r1; r2++) {
            ByteBuffer chacha20Block = chacha20Block(this.initialCounter + r2, nonce);
            if (r2 == r1 - 1) {
                Bytes.xor(output, input, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(output, input, chacha20Block, 64);
            }
        }
    }

    public final byte[] decrypt(ByteBuffer ciphertext) throws GeneralSecurityException {
        if (ciphertext.remaining() >= nonceSizeInBytes()) {
            byte[] bArr = new byte[nonceSizeInBytes()];
            ciphertext.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(ciphertext.remaining());
            process(bArr, allocate, ciphertext);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final void encrypt(ByteBuffer output, final byte[] plaintext) throws GeneralSecurityException {
        if (output.remaining() - nonceSizeInBytes() >= plaintext.length) {
            byte[] randBytes = Random.randBytes(nonceSizeInBytes());
            output.put(randBytes);
            process(randBytes, output, ByteBuffer.wrap(plaintext));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
