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
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class BenchmarkStringBuilder {

    private static final String PERENQUEN = "perenquen";
    private static final String GUACHINCHE = "guachinche";
    private static final String CHIMICHANGA = "chimichanga";
    private static final String ESCALDÓN = "escaldón";
    private static final String DELIMITER = ":";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkStringBuilder.class.getSimpleName())
                .resultFormat(ResultFormatType.CSV)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void literalPlus() {
        List<String> strings = new ArrayList<>();

        strings.add("perenquen" + ":" + "guachinche" + ":" + "chimichanga" + ":" + "escaldón");
    }

    @Benchmark
    public void literalConcat() {
        List<String> strings = new ArrayList<>();

        strings.add("perenquen".concat(":").concat("guachinche").concat(":").concat("chimichanga").concat(":").concat("escaldón"));
    }

    @Benchmark
    public void literalStringBuilder() {
        List<String> strings = new ArrayList<>();

        strings.add(new StringBuilder("perenquen").append(":").append("guachinche").append(":").append("chimichanga").append(":").append("escaldón").toString());
    }

    @Benchmark
    public void literalStringJoiner() {
        List<String> strings = new ArrayList<>();

        strings.add(new StringJoiner(":").add("perenquen").add("guachinche").add("chimichanga").add("escaldón").toString());
    }

    @Benchmark
    public void variablePlus() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichanga = "chimichanga";
        String escaldon = "escaldón";
        String delimiter = ":";

        strings.add(perenquen + delimiter + guachinche + delimiter + chimichanga + delimiter + escaldon);
    }

    @Benchmark
    public void variableConcat() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichanga = "chimichanga";
        String escaldon = "escaldón";
        String delimiter = ":";

        strings.add(perenquen.concat(delimiter).concat(guachinche).concat(delimiter).concat(chimichanga).concat(delimiter).concat(escaldon));
    }

    @Benchmark
    public void variableStringBuilder() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichanga = "chimichanga";
        String escaldon = "escaldón";
        String delimiter = ":";

        strings.add(new StringBuilder(perenquen).append(delimiter).append(guachinche).append(delimiter).append(chimichanga).append(delimiter).append(escaldon).toString());
    }

    @Benchmark
    public void variableStringJoiner() {
        List<String> strings = new ArrayList<>();
        String perenquen = "perenquen";
        String guachinche = "guachinche";
        String chimichanga = "chimichanga";
        String escaldon = "escaldón";
        String delimiter = ":";

        strings.add(new StringJoiner(delimiter).add(perenquen).add(guachinche).add(chimichanga).add(escaldon).toString());
    }

    @Benchmark
    public void constantPlus() {
        List<String> strings = new ArrayList<>();

        strings.add(PERENQUEN + DELIMITER + GUACHINCHE + DELIMITER + CHIMICHANGA + DELIMITER + ESCALDÓN);
    }

    @Benchmark
    public void constantConcat() {
        List<String> strings = new ArrayList<>();

        strings.add(PERENQUEN.concat(DELIMITER).concat(GUACHINCHE).concat(DELIMITER).concat(CHIMICHANGA).concat(DELIMITER).concat(ESCALDÓN));
    }


    @Benchmark
    public void constantStringBuilder() {
        List<String> strings = new ArrayList<>();

        strings.add(new StringBuilder(PERENQUEN).append(DELIMITER).append(GUACHINCHE).append(DELIMITER).append(CHIMICHANGA).append(DELIMITER).append(ESCALDÓN).toString());
    }

    @Benchmark
    public void constantStringJoiner() {
        List<String> strings = new ArrayList<>();

        strings.add(new StringJoiner(DELIMITER).add(PERENQUEN).add(GUACHINCHE).add(CHIMICHANGA).add(ESCALDÓN).toString());
    }

    @Benchmark
    public void callFunctionPlus() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(PERENQUEN + DELIMITER + guachinche + delimiter + createChimichanga() + getDelimiter() + "escaldón");
    }

    @Benchmark
    public void callFunctionConcat() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(PERENQUEN.concat(DELIMITER).concat(guachinche).concat(delimiter).concat(createChimichanga()).concat(getDelimiter()).concat("escaldón"));
    }

    @Benchmark
    public void callFunctionStringBuilder() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(new StringBuilder(PERENQUEN).append(DELIMITER).append(guachinche).append(delimiter).append(createChimichanga()).append(getDelimiter()).append("escaldón").toString());
    }

    @Benchmark
    public void callFunctionStringJoiner() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(new StringJoiner(DELIMITER).add(PERENQUEN).add(guachinche).add(createChimichanga()).add("escaldón").toString());
    }

    @Benchmark
    public void constantVariableLiteralPlus() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(PERENQUEN + DELIMITER + guachinche + delimiter + "chimichanga" + ":" + "escaldón");
    }

    @Benchmark
    public void constantVariableLiteralConcat() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(PERENQUEN.concat(DELIMITER).concat(guachinche).concat(delimiter).concat("chimichanga").concat(":").concat("escaldón"));
    }

    @Benchmark
    public void constantVariableLiteralStringBuilder() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(new StringBuilder(PERENQUEN).append(DELIMITER).append(guachinche).append(delimiter).append("chimichanga").append(":").append("escaldón").toString());
    }

    @Benchmark
    public void constantVariableLiteralStringJoiner() {
        List<String> strings = new ArrayList<>();
        String guachinche = "guachinche";
        String delimiter = ":";

        strings.add(new StringJoiner(DELIMITER).add(PERENQUEN).add(guachinche).add("chimichanga").add("escaldón").toString());
    }

    private String createChimichanga() {
        return "chimichanga";
    }

    private String getDelimiter() {
        return DELIMITER;
    }
}
