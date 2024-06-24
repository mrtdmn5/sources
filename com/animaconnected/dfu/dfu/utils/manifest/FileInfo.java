package com.animaconnected.dfu.dfu.utils.manifest;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class FileInfo {

    @SerializedName("bin_file")
    protected String binFile;

    @SerializedName("dat_file")
    protected String datFile;

    @SerializedName("init_packet_data")
    protected InitPacketData initPacketData;

    public String getBinFileName() {
        return this.binFile;
    }

    public String getDatFileName() {
        return this.datFile;
    }

    public InitPacketData getInitPacketData() {
        return this.initPacketData;
    }
}
