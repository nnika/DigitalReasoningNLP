package com.dr.nlp.part2.test;

import com.dr.nlp.part2.dataStructures.test.*;
import com.dr.nlp.part2.jobs.test.SecondJobTest;
import com.dr.nlp.part2.util.test.NLPDataReaderTest;
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
    SecondJobTest.class,
    NLPDataReaderTest.class
})
public class RunAllTests {

}
