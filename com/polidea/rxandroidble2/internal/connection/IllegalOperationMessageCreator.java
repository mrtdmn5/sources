package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class IllegalOperationMessageCreator {
    public final CharacteristicPropertiesParser propertiesParser;

    public IllegalOperationMessageCreator(CharacteristicPropertiesParser characteristicPropertiesParser) {
        this.propertiesParser = characteristicPropertiesParser;
    }

    public final String createMismatchMessage(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r6) {
        Locale locale = Locale.getDefault();
        bluetoothGattCharacteristic.getUuid();
        LoggerUtil.getUuidToLog();
        int properties = bluetoothGattCharacteristic.getProperties();
        CharacteristicPropertiesParser characteristicPropertiesParser = this.propertiesParser;
        return String.format(locale, "Characteristic %s supports properties: %s (%d) does not have any property matching %s (%d)", "...", characteristicPropertiesParser.propertiesIntToString(properties), Integer.valueOf(bluetoothGattCharacteristic.getProperties()), characteristicPropertiesParser.propertiesIntToString(r6), Integer.valueOf(r6));
    }
}
