package com.mowitnow.batch.utils;

import com.mowitnow.batch.model.Mower;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class MowerFieldSetMapper implements FieldSetMapper<Mower> {

    @Override
    public Mower mapFieldSet(FieldSet fieldSet) throws BindException {
        Mower mower = new Mower();
        String[] positionData = fieldSet.readString("position").split(" ");
        mower.setX(Integer.parseInt(positionData[0]));
        mower.setY(Integer.parseInt(positionData[1]));
        mower.setOrientation(Orientation.valueOf(positionData[2]));
        mower.setInstructions(fieldSet.readString("instructions"));
        return mower;
    }
}
