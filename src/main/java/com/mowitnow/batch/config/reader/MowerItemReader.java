package com.mowitnow.batch.config.reader;

import com.mowitnow.batch.model.Mower;
import com.mowitnow.batch.utils.MowerLineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.Resource;


public class MowerItemReader  {

    public MultiResourceItemReader<Mower> createReader(Resource[] resources, LineTokenizer tokenizer, MowerLineMapper lineMapper) {
        return new MultiResourceItemReaderBuilder<Mower>()
                .name("mowerReader")
                .resources(resources)
                .lineTokenizer(tokenizer)
                .lineMapper(lineMapper)
                .build();
    }

}
