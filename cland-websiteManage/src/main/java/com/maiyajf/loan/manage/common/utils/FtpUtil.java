package com.maiyajf.loan.manage.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

/**
 * =========================================================
 * 
 * 文件： .FtpTest.java
 * 
 * 所含类: FtpTest.java
 * 
 * 修改记录： 日期 作者 内容 ========================================================= Jul
 * 4, 2014 liqin 创建文件，实现基本功能
 */
@SuppressWarnings("restriction")
public class FtpUtil
{
    private static Log log = LogFactory.getLog(FtpUtil.class);
    
    public static boolean uploadToFtpServer(File file, String serverPath, String fileName, FtpConfig config)
    {
        try
        {
            return uploadToFtpServer(getLocalFileInputStream(file), serverPath, fileName, config);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
	public static boolean uploadToFtpServer(InputStream fileStream, String serverPath, String fileName,
        FtpConfig config)
    {
        String serverUrl = config.getIp();
        String userName = config.getUserName();
        String passWord = config.getPassword();
        FtpClient ftpClient;
        try
        {
            ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            // 登录到Ftp服务器
            boolean isOpenSuccess = loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            if (isOpenSuccess)
            {// 以下几步顺序不能错
            
                serverPath = getFullPath(ftpClient, serverPath);
                createDir(ftpClient, serverPath);
                ftpClient.changeDirectory(serverPath);
                ftpClient.putFile(fileName, fileStream);
                close(ftpClient, null, fileStream);// 关闭
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private static String getFullPath(FtpClient ftpClient, String serverPath)
        throws FtpProtocolException, IOException
    {
        String workingdir = ftpClient.getWorkingDirectory();
        if (!serverPath.startsWith("/"))
            serverPath = "/" + serverPath;
        if (!workingdir.equals("/"))
            serverPath = workingdir + serverPath;
        return serverPath;
    }
    
    /**
     * 将字符串内容以一个文件的形式保存到ftp
     * 
     * @param content 字符串内容
     * @param ftpDir 存放的ftp目录
     * @param ftpFileName 文件名
     */
//    public static void uploadFtp(String content, String ftpDir, String ftpFileName, FtpConfig config)
//    {
//        ByteArrayInputStream contentStream;
//        try
//        {
//            contentStream = new ByteArrayInputStream(content.getBytes("utf-8"));
//        }
//        catch (UnsupportedEncodingException e)
//        {
//            log.error(e);
////            throw new BaseException(ExceptionCode.FTP_UPLOAD_ENCODING_ERR);
//        }
//        FtpUtils.DBGetParamUploadToFtpServer(contentStream, ftpDir, ftpFileName, config);
//    }
    
    /**
     * 检查文件夹在当前目录下是否存在
     * 
     * @param dir
     * @return
     */
    private static boolean isDirExist(FtpClient ftpClient, String dir)
    {
        String pwd = "";
        try
        {
            pwd = ftpClient.getWorkingDirectory();
            ftpClient.changeDirectory(dir);
            ftpClient.changeDirectory(pwd);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    
    /**
     * 在当前目录下创建文件夹
     * 
     * @param dir
     * @return
     * @throws Exception
     */
    private static boolean createDir(FtpClient ftpClient, String dir)
    {
        try
        {
            ftpClient.setAsciiType();
            StringTokenizer s = new StringTokenizer(dir, "/"); // sign
            s.countTokens();
            String pathName = "";//
            //String woringdir=ftpClient.getWorkingDirectory();
            while (s.hasMoreElements())
            {
                pathName = pathName + "/" + (String)s.nextElement();
                if (!isDirExist(ftpClient, pathName))
                {
                    try
                    {
                        ftpClient.makeDirectory(pathName);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        e = null;
                        return false;
                    }
                    ftpClient.getLastResponseString();
                }
            }
            ftpClient.setBinaryType();
            return true;
        }
        catch (IOException e1)
        {
            return false;
        }
        catch (FtpProtocolException e1)
        {
            e1.printStackTrace();
        }
        return false;
    }
    
    /** 从Ftp服务器上下载文件 
     * @param out */
    public static void downloadFormFtp(OutputStream out, String serverPath, FtpConfig config)
    {
        String serverUrl = config.getIp();
        String userName = config.getUserName();
        String passWord = config.getPassword();
        String filepath = serverPath.substring(0, serverPath.lastIndexOf("/"));
        String filename = serverPath.substring(serverPath.lastIndexOf("/") + 1, serverPath.length());
        FtpClient ftpClient = null;
        try
        {
            ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            filepath = getFullPath(ftpClient, filepath);
            if (isDirExist(ftpClient, filepath))
            {
                //String os = SysParaUtil.get(SysParaUtil._FTPOS);
                
                ftpClient.changeDirectory(filepath);
                InputStream inputStream = getFtpClientInputStream(ftpClient, filename);
                if (inputStream != null)
                    writeToLocal(inputStream, out);
                if (inputStream != null)
                    inputStream.close();
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (ftpClient != null)
                try
                {
                    ftpClient.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
    
    /**
     * 从FTP下载文件
     * @param response
     * @param fileName 文件名
     * @param filePath 文件路径
     */
    public static void downloadFormFtp(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath, FtpConfig config)
    {
        ServletOutputStream out = null;
        try
        {
            ServletUtils.setDisableCacheHeader(response);
            
            String agent = request.getHeader("USER-AGENT");
            if (agent != null && agent.indexOf("MSIE") != -1)
            {
                fileName = URLEncoder.encode(fileName, "UTF8");
                fileName = fileName.replaceAll("\\+", "%20");
            }
            else
            {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            
            response.setHeader("Content-disposition", "attachment;filename=\""+fileName+"\"");
            String postfix = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
            postfix = postfix.toLowerCase();
            String imgpostfix = "@jpg@jpeg@bmp@gif@png@";
            String docpostfix = "@doc@docx@";
            String txtpostfix = "@txt@";
            String excelpostfix = "@xls@xlsx@";
            String pdfpostfix = "@pdf@"; // ;application/pdf
            if (imgpostfix.indexOf("@" + postfix + "@") != -1)
            {
                response.setContentType("image/jpeg");
            }
            else if (docpostfix.indexOf("@" + postfix + "@") != -1)
            {
                response.setContentType("application/msword");
            }
            else if (txtpostfix.indexOf("@" + postfix + "@") != -1)
            {
                response.setContentType("text/plain");
            }
            else if (excelpostfix.indexOf("@" + postfix + "@") != -1)
            {
                response.setContentType("text/xml");
            }
            else if (pdfpostfix.indexOf("@" + postfix + "@") != -1)
            {
                response.setContentType("application/pdf");
            }
            else
            {
                response.setContentType("application/octet-stream");
            }
            out = response.getOutputStream();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        downloadFormFtp(out, filePath, config);
    }
    
    /** 登录到Ftp服务器 */
    private static boolean loginToFtpServer(FtpClient ftpClient, String serverUrl, String userName, String passWord)
    {
        try
        {
            ftpClient.login(userName, passWord.toCharArray());
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
        catch (FtpProtocolException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    /** 得到ftp客户端的输出流 
     * @throws FtpProtocolException */
    public static OutputStream getFtpClientOutputStream(FtpClient ftpClient, String fileName)
        throws IOException, FtpProtocolException
    {
        ftpClient.setBinaryType();
        return ftpClient.putFileStream(fileName, true);//ftpClient.put(fileName);此为jdk1.6方法 以下为jdk1.7方法
    }
    
    /** 得到ftp客户端的输出流 
     * @throws FtpProtocolException */
    public static InputStream getFtpClientInputStream(FtpClient ftpClient, String downLoadFile)
        throws IOException, FtpProtocolException
    {
        ftpClient.setBinaryType();
        File file = new File(downLoadFile);
        return ftpClient.getFileStream(file.getName());
    }
    
   /* public static void batchDownFiles(OutputStream output, FtpConfig config, String[] filePaths, String[] orlNames)
        throws IOException
    {
        byte[] buffer = new byte[1024];
        String serverUrl = config.getIp();
        String userName = config.getUserName();
        String passWord = config.getPassword();
        FtpClient ftpClient = null;
        ZipOutputStream out = null;
        try
        {
            ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            
            out = new ZipOutputStream(output);
            out.setEncoding("gbk");//指定编码为gbk，否则部署到linux下会出现乱码
            loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            String initdir = ftpClient.getWorkingDirectory();
            for (int i = 0; i < filePaths.length; i++)
            {
                try
                {
                    
                    String serverPath = filePaths[i];
                    String filepath = serverPath.substring(0, serverPath.lastIndexOf("/"));
                    String filename = serverPath.substring(serverPath.lastIndexOf("/") + 1, serverPath.length());
                    //if (isDirExist(ftpClient, filepath)) {
                    // 进入服务器的指定目录
                    filepath = getFullPath(ftpClient, filepath);
                    ftpClient.changeDirectory(filepath);
                    InputStream inputStream = getFtpClientInputStream(ftpClient, filename);
                    if (inputStream == null)
                        continue;
                    out.putNextEntry(new ZipEntry(new String(orlNames[i])));
                    
                    // 设置压缩文件内的字符编码，不然会变成乱码
                    // out.setEncoding("GBK");
                    int len;
                    // 读入需要下载的文件的内容，打包到zip文件
                    while ((len = inputStream.read(buffer)) > 0)
                    {
                        out.write(buffer, 0, len);
                    }
                    out.closeEntry();
                    if (inputStream != null)
                        inputStream.close();
                    ftpClient.changeDirectory(initdir);
                    //}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (out != null)
            {
                out.flush();
                out.close();
            }
            output.flush();
            output.close();
            if (ftpClient != null)
                ftpClient.close();
        }
    }*/
    
    /** 得到本地文件的输入流 */
    private static InputStream getLocalFileInputStream(File file)
        throws FileNotFoundException
    {
        return new FileInputStream(file);
    }
    
    /** 向ftp服务器写入文件 */
    public static void writeToFtpServer(OutputStream outputStream, InputStream inputStream)
        throws IOException
    {
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes, 0, bytes.length)) != -1)
        {
            outputStream.write(bytes, 0, len);
        }
        outputStream.flush();
    }
    
    /** 下载文件到本地 */
    public static void writeToLocal(InputStream inputStream, OutputStream outputStream)
        throws IOException
    {
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes, 0, bytes.length)) != -1)
        {
            outputStream.write(bytes, 0, len);
        }
        outputStream.flush();
    }
    
    /** 关闭 */
    private static void close(FtpClient ftpClient, OutputStream outputStream, InputStream inputStream)
        throws IOException
    {
        if (inputStream != null)
            inputStream.close();
        if (outputStream != null)
            outputStream.close();
        if (ftpClient != null)
            ftpClient.close();
    }
    
    /** 
     *  
     * <p>删除ftp上的文件</p> 
     * @param srcFname 
     * @return true || false 
     */  
    public static boolean removeFile(String srcFname, FtpConfig config){
    	String serverUrl = config.getIp();
        String userName = config.getUserName();
        String passWord = config.getPassword();
        FtpClient ftpClient;
        try
        {
            ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            // 登录到Ftp服务器
            boolean isOpenSuccess = loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            if (isOpenSuccess)
            {// 以下几步顺序不能错
            
            	ftpClient.deleteFile(srcFname);
                close(ftpClient, null, null);// 关闭
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
        
    }  
    
    /**
     * 从ftp获取文件
     * @param path
     * @param fileName
     * @param config
     * @return
     */
    public static File getFileByPath(String path, String fileName, FtpConfig config){
    	
        FtpClient ftpClient;
        try
        {
        	String prefix = fileName.substring(0, fileName.indexOf("."));  
    		String suffix = fileName.substring(fileName.indexOf("."),fileName.length());
    		File tempFile = File.createTempFile(prefix, suffix);
    		
    		String serverUrl = config.getIp();
            String userName = config.getUserName();
            String passWord = config.getPassword();
        	ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            // 登录到Ftp服务器
            boolean b = loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            InputStream  in = ftpClient.getFileStream(path);
            inputstreamtofile(in, tempFile);
            return tempFile;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args)
    {
        String serverUrl = "127.0.0.1";
        String userName = "nl";
        String passWord = "123456";
        FtpConfig config = new FtpConfig();
        config.setIp(serverUrl);
        config.setPassword(passWord);
        config.setUserName(userName);
        uploadToFtpServer(new File("C:/Users/admin/Desktop/pic/111.jpg"), "/image/", "aaa.jpg", config);
//        File file = getFileByPath("bill_local/20170823/FundDetail_5078_CMBC.20170823_0", "FundDetail_5078_CMBC.20170823_0", config);
//        System.out.println(file.length());
        
//        String url = "upload/brand/00e2add6-9a7f-4def-815b-7eeb1379a870.jpg";
//        boolean flag = removeFile(url, config);
//        System.out.println("============"+flag);
        
       /* File file = new File("ftp://192.168.1.250/upload/activity/104c045a-2f45-4221-9fc3-e309cf23a8c0.png");
       System.out.println(file.getName()); 
        FtpClient ftpClient;
        try
        {
            ftpClient = FtpClient.create(serverUrl);//此为jdk1.7创建ftp连接
            // 登录到Ftp服务器
            boolean b = loginToFtpServer(ftpClient, serverUrl, userName, passWord);
            System.out.println(b);
//            createDir(ftpClient, "aa");
            
//            String path = getFullPath(ftpClient, "aa");
//            System.out.println(path);
            InputStream  in = ftpClient.getFileStream("bill_local/20170823/FundDetail_5078_CMBC.20170823_0");
            File fff = File.createTempFile("aaaa", ".xxx");
            inputstreamtofile(in, fff);
            System.out.println(fff.getPath());
            System.out.println(fff.canRead());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/
    }
    
	public static void inputstreamtofile(InputStream ins, File file)
			throws IOException {
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[1024];
		while ((bytesRead = ins.read(buffer, 0, 1024)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}
    
}
