package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

/* loaded from: classes3.dex */
public abstract class ChaCha20Poly1305Base implements Aead {
    public final ChaCha20Base chacha20;
    public final ChaCha20Base macKeyChaCha20;

    public ChaCha20Poly1305Base(final byte[] key) throws InvalidKeyException {
        this.chacha20 = newChaCha20Instance(1, key);
        this.macKeyChaCha20 = newChaCha20Instance(0, key);
    }

    public static byte[] macDataRfc8439(final ByteBuffer aad, byte[] ciphertext) {
        int length;
        int r3;
        if (ciphertext.length % 16 == 0) {
            length = ciphertext.length;
        } else {
            length = (ciphertext.length + 16) - (ciphertext.length % 16);
        }
        int remaining = aad.remaining();
        int r2 = remaining % 16;
        if (r2 == 0) {
            r3 = remaining;
        } else {
            r3 = (remaining + 16) - r2;
        }
        int r32 = r3 + length;
        ByteBuffer order = ByteBuffer.allocate(r32 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(ciphertext);
        order.position(length);
        order.put(aad);
        order.position(r32);
        order.putLong(ciphertext.length);
        order.putLong(remaining);
        return order.array();
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        ByteBuffer wrap = ByteBuffer.wrap(ciphertext);
        int remaining = wrap.remaining();
        ChaCha20Base chaCha20Base = this.chacha20;
        if (remaining >= chaCha20Base.nonceSizeInBytes() + 16) {
            int position = wrap.position();
            byte[] bArr = new byte[16];
            wrap.position(wrap.limit() - 16);
            wrap.get(bArr);
            wrap.position(position);
            wrap.limit(wrap.limit() - 16);
            byte[] bArr2 = new byte[chaCha20Base.nonceSizeInBytes()];
            wrap.get(bArr2);
            if (associatedData == null) {
                associatedData = new byte[0];
            }
            try {
                byte[] bArr3 = new byte[32];
                this.macKeyChaCha20.chacha20Block(0, bArr2).get(bArr3);
                if (Bytes.equal(Poly1305.computeMac(bArr3, macDataRfc8439(wrap, associatedData)), bArr)) {
                    wrap.position(position);
                    return chaCha20Base.decrypt(wrap);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e) {
                throw new AEADBadTagException(e.toString());
            }
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public final byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        int length = plaintext.length;
        ChaCha20Base chaCha20Base = this.chacha20;
        if (length <= (Integer.MAX_VALUE - chaCha20Base.nonceSizeInBytes()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(chaCha20Base.nonceSizeInBytes() + plaintext.length + 16);
            if (allocate.remaining() >= chaCha20Base.nonceSizeInBytes() + plaintext.length + 16) {
                int position = allocate.position();
                chaCha20Base.encrypt(allocate, plaintext);
                allocate.position(position);
                byte[] bArr = new byte[chaCha20Base.nonceSizeInBytes()];
                allocate.get(bArr);
                allocate.limit(allocate.limit() - 16);
                if (associatedData == null) {
                    associatedData = new byte[0];
                }
                byte[] bArr2 = new byte[32];
                this.macKeyChaCha20.chacha20Block(0, bArr).get(bArr2);
                byte[] computeMac = Poly1305.computeMac(bArr2, macDataRfc8439(allocate, associatedData));
                allocate.limit(allocate.limit() + 16);
                allocate.put(computeMac);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract ChaCha20Base newChaCha20Instance(final int key, byte[] initialCounter) throws InvalidKeyException;
}
