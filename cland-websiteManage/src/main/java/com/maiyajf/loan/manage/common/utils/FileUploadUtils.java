package com.maiyajf.loan.manage.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.maiyajf.base.utils.log.DebugLogger;

/**
 * @ClassName: FileUploadUtils
 * @Description: 文件上传工具类
 * @author: zhuangsheng.chen
 * @date: 2015年11月11日 上午9:37:38
 */
public class FileUploadUtils {
  /**
   * 保存文件
   * 
   * @param stream
   * @param path
   * @param filename
   * @throws IOException
   */
  public static void uploadFileToServer(InputStream stream, String path, String filename)
      throws IOException {
    FileOutputStream outputStream = new FileOutputStream(path + File.separator + filename);
    int byteCount = 0;
    byte[] bytes = new byte[1024];
    while ((byteCount = stream.read(bytes)) != -1) {
      outputStream.write(bytes, 0, byteCount);
    }
    outputStream.close();
    stream.close();
  }

  public static String uploadFileToFTPServer(InputStream stream, String path, String filename)
      throws IOException {
    String  fileUrl="";
//    FileOutputStream outputStream = new FileOutputStream(path + File.separator + filename);
//    int byteCount = 0;
//    byte[] bytes = new byte[1024];
//    while ((byteCount = stream.read(bytes)) != -1) {
//      outputStream.write(bytes, 0, byteCount);
//    }
//    outputStream.close();
//    stream.close();
    return fileUrl;
  }

  /**
   * @Title: createDir
   * @Description: 创建目录
   * @param destDirName
   * @return: void
   */
  public static void createDir(String destDirName) {
    File dir = new File(destDirName);
    if (dir.exists()) {
      DebugLogger.debug("创建目录" + destDirName + "失败，目标目录已经存在");

    }
    if (!destDirName.endsWith(File.separator)) {
      destDirName = destDirName + File.separator;
    }
    // 创建目录
    if (dir.mkdirs()) {
      DebugLogger.debug("创建目录" + destDirName + "成功！");

    } else {
      DebugLogger.debug("创建目录" + destDirName + "失败！");

    }
  }
}
