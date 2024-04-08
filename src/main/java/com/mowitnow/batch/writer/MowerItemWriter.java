package com.mowitnow.batch.writer;

import com.mowitnow.batch.model.Mower;

import com.mowitnow.batch.utils.MowerLineAggregator;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.core.io.Resource;

import java.util.List;

public class MowerItemWriter extends FlatFileItemWriter<Mower> {

    @Override
    public void write(List<? extends Mower> mowers) {
        for (Mower mower : mowers) {
            System.out.println(mower.getPosition());
        }
    }

    public FlatFileItemWriter<Mower> createWriter(Resource outputResource) {
        return new FlatFileItemWriterBuilder<Mower>()
                .name("mowerWriter")
                .resource(outputResource)
                .lineAggregator(new MowerLineAggregator())
                .build();
    }
}

