/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package stringbuilder;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(BenchmarkStringBuilder.NUMBER_OF_STRINGS_TO_CREATE)
public class BenchmarkStringBuilder {

    static final int NUMBER_OF_STRINGS_TO_CREATE = 100000;
    private static final String PERENQUEN = "perenquen";
    private static final String GUACHINCHE = "guachinche";
    private static final String CHIMICHANGE = "chimichange";
    private static final String ESCALDÓN = "escaldón";

    @Benchmark
    public void literalPlus() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add("perenquen" + "guachinche" + "chimichange" + "escaldón");
        }
    }

    @Benchmark
    public void literalConcat() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add("perenquen".concat("guachinche").concat("chimichange").concat("escaldón"));
        }
    }

    @Benchmark
    public void literalStringBuilder() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(new StringBuilder("perenquen").append("guachinche").append("chimichange").append("escaldón").toString());
        }
    }

    @Benchmark
    public void variablePlus() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichange = "chimichange";
        String escaldon = "escaldón";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(perenquen + guachinche + chimichange + escaldon);
        }
    }

    @Benchmark
    public void variableConcat() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichange = "chimichange";
        String escaldon = "escaldón";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(perenquen.concat(guachinche).concat(chimichange).concat(escaldon));
        }
    }

    @Benchmark
    public void variableStringBuilder() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichange = "chimichange";
        String escaldon = "escaldón";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(new StringBuilder(perenquen).append(guachinche).append(chimichange).append(escaldon).toString());
        }
    }

    @Benchmark
    public void constantPlus() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN + GUACHINCHE + CHIMICHANGE + ESCALDÓN);
        }
    }

    @Benchmark
    public void constantConcat() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN.concat(GUACHINCHE).concat(CHIMICHANGE).concat(ESCALDÓN));
        }
    }


    @Benchmark
    public void constantStringBuilder() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(new StringBuilder(PERENQUEN).append(GUACHINCHE).append(CHIMICHANGE).append(ESCALDÓN).toString());
        }
    }

    @Benchmark
    public void callFunctionPlus() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN + guachinche + createChimichanga() + "escaldón");
        }
    }

    @Benchmark
    public void callFunctionConcat() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN.concat(guachinche).concat(createChimichanga()).concat("escaldón"));
        }
    }

    @Benchmark
    public void callFunctionStringBuilder() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(new StringBuilder(PERENQUEN).append(guachinche).append(createChimichanga()).append("escaldón").toString());
        }
    }

    @Benchmark
    public void constantVariableLiteralPlus() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN + guachinche + "chimichange" + "escaldón");
        }
    }

    @Benchmark
    public void constantVariableLiteralConcat() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(PERENQUEN.concat(guachinche).concat("chimichange").concat("escaldón"));
        }
    }

    @Benchmark
    public void constantVariableLiteralStringBuilder() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        for (int i = 0; i < NUMBER_OF_STRINGS_TO_CREATE; i++) {
            strings.add(new StringBuilder(PERENQUEN).append(guachinche).append("chimichange").append("escaldón").toString());
        }
    }

    private String createChimichanga() {
        return "chimichange";
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkStringBuilder.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

}
