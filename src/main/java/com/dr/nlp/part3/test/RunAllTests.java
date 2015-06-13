package com.dr.nlp.part3.test;

import com.dr.nlp.part3.Jobs.test.DataFilesJobTest;
import com.dr.nlp.part3.dataStructures.test.*;
import com.dr.nlp.part3.util.test.NLPDataReaderTest;
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
    DataFilesJobTest.class,
    NLPDataReaderTest.class
})
public class RunAllTests {

}
