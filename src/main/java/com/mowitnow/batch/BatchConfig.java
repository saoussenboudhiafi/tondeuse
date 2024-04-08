package com.mowitnow.batch;

import com.mowitnow.batch.config.processor.MowerItemProcessor;
import com.mowitnow.batch.config.reader.MowerItemReader;
import com.mowitnow.batch.model.Mower;
import com.mowitnow.batch.utils.MowerLineMapper;
import com.mowitnow.batch.writer.MowerItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
      @Bean
      public MultiResourceItemReader<Mower> multiResourceItemReader(MowerItemReader mowerReader,
                                                              @Value("${input.files}") Resource[] inputResources) {
        return mowerReader.createReader(inputResources, createTokenizer(), new MowerLineMapper());
        }

       @Bean
       public FlatFileItemWriter<Mower> flatFileItemWriter(@Value("${output.file}") Resource outputResource) {
        return new MowerItemWriter().createWriter(outputResource);

        }

       @Bean
       public Step mowerStep(StepBuilderFactory stepBuilderFactory,
        MultiResourceItemReader<Mower> multiResourceItemReader,
        MowerItemProcessor mowerProcessor,
        FlatFileItemWriter<Mower> flatFileItemWriter) {
        return stepBuilderFactory.get("mowerStep")
        .<Mower, Mower>chunk(1)
        .reader(multiResourceItemReader)
        .processor(mowerProcessor)
        .writer(flatFileItemWriter)
        .build();
        }

       @Bean
       public Job mowerJob(JobBuilderFactory jobBuilderFactory, Step mowerStep) {
        return jobBuilderFactory.get("mowerJob")
        .start(mowerStep)
        .build();
        }

        private DelimitedLineTokenizer createTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(" ");
        tokenizer.setNames(new String[]{"x", "y", "orientation", "instructions"});
        return tokenizer;
        }

}