package com.animaconnected.dfu.dfu.utils.manifest;

/* loaded from: classes.dex */
public class Manifest {
    protected FileInfo application;
    protected FileInfo bootloader;

    public FileInfo getApplicationInfo() {
        return this.application;
    }

    public FileInfo getBootloaderInfo() {
        return this.bootloader;
    }

    public byte imageTypeToUpdateFires() {
        if (this.bootloader == null) {
            return (byte) 4;
        }
        return (byte) 2;
    }
}
