package com.mowitnow.batch.utils;
import com.mowitnow.batch.model.Mower;
import org.springframework.batch.item.file.transform.LineAggregator;

public class MowerLineAggregator implements LineAggregator<Mower> {

    @Override
    public String aggregate(Mower item) {
        return item.getPosition();
    }
}
