package com.mowitnow.batch.utils;

import com.mowitnow.batch.model.Mower;
import org.springframework.batch.item.file.LineMapper;

public class MowerLineMapper implements LineMapper<Mower> {

    @Override
    public Mower mapLine(String line, int lineNumber) {
        String[] parts = line.split(" ");
        Mower mower = new Mower();
        mower.setX(Integer.parseInt(parts[0]));
        mower.setY(Integer.parseInt(parts[1]));
        mower.setOrientation(Orientation.valueOf(parts[2]));
        return mower;
    }
}
