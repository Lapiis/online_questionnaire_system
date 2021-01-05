package edu.nwpu.util;

/**
 * url工具类
 *
 * @author dengzhijian
 */
public class URLUtil {
  private static final String basePath = "localhost:8080/questionnaire";

  public static String generateUrl(int id) {
    return basePath + "/" + id;
  }
}
