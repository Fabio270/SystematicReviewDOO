package com.systematic.doosystematic.utils;

import java.util.UUID;

public class UUIDGeneratorService {
    public static UUID getNextId(){
        return UUID.randomUUID();
    }
}
