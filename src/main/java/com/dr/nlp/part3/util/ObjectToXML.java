package com.dr.nlp.part3.util;

import com.dr.nlp.part3.dataStructures.DataFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ResourceBundle;

/**
 * A utility class with a method to transform a jave object to XML
 *
 * Created by Nikandish on 6/10/15 at 10:35 PM.
 */
public class ObjectToXML {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILEOUT = bundle.getString("file.out");
  private static final String OUTPUTDIR = bundle.getString("output.dir");

  /**
   *
   * @param dataFile
   * @param fileName
   */
  public void transformObjectToXML(DataFile dataFile, final String fileName){
    JAXBContext context;
    try {
      context = JAXBContext.newInstance(DataFile.class);
      Marshaller m = context.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      m.marshal(dataFile, new File(OUTPUTDIR + fileName + "_" + FILEOUT));
    } catch (JAXBException e) {
      e.printStackTrace();

    }
  }
}
