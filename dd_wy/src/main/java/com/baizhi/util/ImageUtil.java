package com.baizhi.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
	
	//获取随机数（含有四个字符的字符数组）
	public static char[] getRandomChar() {
        char[] codes = new char[] { '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };

        char[] sj = new char[4];
        for (int i = 0; i < sj.length; i++) {
            sj[i] = codes[new Random().nextInt(21)];
        }
        System.out.println(new String(sj));
        return sj;
    }
	
	public static BufferedImage getImage( char[] codes ) {
		   // 准备画图的缓冲区
        BufferedImage buffer = new BufferedImage(80, 30,
                BufferedImage.TYPE_INT_RGB);

        // 获取画笔
        Graphics graphics = buffer.getGraphics();

        // 画背景
        graphics.setColor(Color.PINK);
        graphics.drawRect(0, 0, 80, 40);

        // 画内容
        graphics.setColor(Color.WHITE);
        graphics.drawString(codes[0] + "", 8, 12);
        graphics.drawString(codes[1] + "", 22, 25);
        graphics.drawString(codes[2] + "", 48, 18);
        graphics.drawString(codes[3] + "", 65, 28);
        
        // 往VS中session里存验证码
        //ai.getStack().setValue("#session.code", new String(codes));

        // 生成缓冲区内的图片
        graphics.dispose();
        
        return buffer;

	}
	
}
