package com.maiyajf.loan.manage.common.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具类
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class CaptchaUtil {

  // 随机产生的字符串
  private static final String RANDOM_STRS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private static final String FONT_NAME = "Fixedsys";
  private static final int FONT_SIZE = 18;

  private Random random = new Random();

  private int width = 80;// 图片宽
  private int height = 25;// 图片高
  private int lineNum = 50;// 干扰线数量
  private int strNum = 4;// 随机产生字符数量


  /**
   * @Title: genRandomCodeImage
   * @Description: 生成随机图片
   * @param randomCode
   * @return 图片缓存
   * @return: BufferedImage
   */
  public BufferedImage genRandomCodeImage(StringBuffer randomCode) {
    // BufferedImage类是具有缓冲区的Image类
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
    // 获取Graphics对象,便于对图像进行各种绘制操作
    Graphics gcs = image.getGraphics();
    // 设置背景色
    gcs.setColor(getRandColor(200, 250));
    gcs.fillRect(0, 0, width, height);

    // 设置干扰线的颜色
    gcs.setColor(getRandColor(110, 120));

    // 绘制干扰线
    for (int i = 0; i <= lineNum; i++) {
      drowLine(gcs);
    }
    // 绘制随机字符
    gcs.setFont(new Font(FONT_NAME, Font.ROMAN_BASELINE, FONT_SIZE));
    for (int i = 1; i <= strNum; i++) {
      randomCode.append(drowString(gcs, i));
    }
    gcs.dispose();
    return image;
  }

  
  /**
   * @Title: getRandColor
   * @Description: 给定范围获得随机颜色
   * @param fc
   * @param bc
   * @return 颜色
   * @return: Color
   */
  private Color getRandColor(int fc, int bc) {
    if (fc > 255) fc = 255;
    if (bc > 255) bc = 255;
    int red = fc + random.nextInt(bc - fc);
    int green = fc + random.nextInt(bc - fc);
    int blue = fc + random.nextInt(bc - fc);
    return new Color(red, green, blue);
  }

   
  /**
   * @Title: drowString
   * @Description: 绘制字符串
   * @param g
   * @param i
   * @return
   * @return: String
   */
  private String drowString(Graphics g, int i) {
    g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
    String rand = String.valueOf(getRandomString(random.nextInt(RANDOM_STRS.length())));
    g.translate(random.nextInt(3), random.nextInt(3));
    g.drawString(rand, 13 * i, 16);
    return rand;
  }

  /**
   * @Title: drowLine
   * @Description: 绘制干扰线
   * @param g
   * @return: void
   */
  private void drowLine(Graphics g) {
    int xwidth = random.nextInt(width);
    int yheight = random.nextInt(height);
    int x0 = random.nextInt(16);
    int y0 = random.nextInt(16);
    g.drawLine(xwidth, yheight, xwidth + x0, yheight + y0);
  }


  /**
   * @Title: getRandomString
   * @Description: 获取随机的字符
   * @param num
   * @return 随机字符
   * @return: String
   */
  private String getRandomString(int num) {
    return String.valueOf(RANDOM_STRS.charAt(num));
  }

}
