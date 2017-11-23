package com.github.antksk.java8_training.stream;

import org.slf4j.Logger;

import java.util.function.Consumer;

public interface TestLogDisplay {

    default Consumer<String> display(final Logger log){
        return (s)->log.debug("{}", s);
    }
}
