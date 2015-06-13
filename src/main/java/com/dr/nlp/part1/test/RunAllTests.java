package com.dr.nlp.part1.test;

import com.dr.nlp.part1.dataStructures.test.*;
import com.dr.nlp.part1.jobs.test.FirstJobTest;
import com.dr.nlp.part1.util.test.NLPDataReaderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Nikandish on 6/12/15 at 10:16 PM.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    DataFileTest.class,
    ParagraphTest.class,
    PunctuationTest.class,
    SentenceTest.class,
    DataFileTest.class,
    WordTest.class,
    FirstJobTest.class,
    NLPDataReaderTest.class
})
public class RunAllTests {

}
