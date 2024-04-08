package com.mowitnow.batch.config.processor;

import com.mowitnow.batch.model.Mower;
import org.springframework.batch.item.ItemProcessor;

public class MowerItemProcessor implements ItemProcessor<Mower, Mower> {

        @Override
        public Mower process(Mower mower) {
            for (char instruction : mower.getInstructions().toCharArray()) {
                if (instruction == 'G' || instruction == 'D') {
                    mower.rotate(instruction);
                } else if (instruction == 'A') {
                    mower.move();
                }
            }
            return mower;
        }

}