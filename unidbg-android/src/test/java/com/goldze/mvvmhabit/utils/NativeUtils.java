package com.goldze.mvvmhabit.utils;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.memory.Memory;

import java.io.File;
import java.io.IOException;

public class NativeUtils {
    private final AndroidEmulator emulator;
    private final VM vm;
    private final DvmClass cls;
    private final DalvikModule dm;

    public NativeUtils() {

        emulator = AndroidEmulatorBuilder.for32Bit().setProcessName("com.goldze.mvvmhabit").build();

        final Memory memory = emulator.getMemory();

        memory.setLibraryResolver(new AndroidResolver(23));

        vm = emulator.createDalvikVM(null);


        dm = vm.loadLibrary(new File("unidbg-android/src/test/resources/app9/libnative.so"), false);

        dm.callJNI_OnLoad(emulator);

        cls = vm.resolveClass("com/goldze/mvvmhabit/utils/NativeUtils");
    }

    public String encrypt(String string, int offset) {
        DvmObject<?> result = cls.callStaticJniMethodObject(emulator, "encrypt(Ljava/lang/String;)Ljava/lang/String",
                vm.addLocalObject(new StringObject(vm, string)), offset);
        return (String) result.getValue();
    }

    public static void main(String[] args) {
        NativeUtils utils = new NativeUtils();
        String token = utils.encrypt("/api/movie", 2);
        System.out.println("token:" + token );
    }
}
