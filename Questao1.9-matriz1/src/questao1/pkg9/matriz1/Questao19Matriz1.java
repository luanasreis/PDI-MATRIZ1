/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1.pkg9.matriz1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author luana
 */
public class Questao19Matriz1 {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luana
 */


    /**
     * @param args the command line arguments
     */
static BufferedImage inputImg,outputImg;
static int[][] pixelMatrix=new int[3][3];

public static void main(String[] args) {
    try {

        inputImg=ImageIO.read(new File("imagem.jpg"));
        outputImg=new BufferedImage(inputImg.getWidth(),inputImg.getHeight(),TYPE_INT_RGB);

        for(int i=1;i<inputImg.getWidth()-1;i++){
            for(int j=1;j<inputImg.getHeight()-1;j++){
                pixelMatrix[0][0]=new Color(inputImg.getRGB(i-1,j-1)).getRed();
                pixelMatrix[0][1]=new Color(inputImg.getRGB(i-1,j)).getRed();
                pixelMatrix[0][2]=new Color(inputImg.getRGB(i-1,j+1)).getRed();
                pixelMatrix[1][0]=new Color(inputImg.getRGB(i,j-1)).getRed();
                pixelMatrix[1][1]=new Color(inputImg.getRGB(i, j)).getRed();
                pixelMatrix[1][2]=new Color(inputImg.getRGB(i,j+1)).getRed();
                pixelMatrix[2][0]=new Color(inputImg.getRGB(i+1,j-1)).getRed();
                pixelMatrix[2][1]=new Color(inputImg.getRGB(i+1,j)).getRed();
                pixelMatrix[2][2]=new Color(inputImg.getRGB(i+1,j+1)).getRed();

                int edge=(int) convolution(pixelMatrix);
                outputImg.setRGB(i,j,(edge<<16 | edge<<8 | edge));
            }
        }

        File outputfile = new File("imagem2.jpg");
        ImageIO.write(outputImg,"jpg", outputfile);

    } catch (IOException ex) {System.err.println("Image width:height="+inputImg.getWidth()+":"+inputImg.getHeight());}
}
public static double convolution(int[][] pixelMatrix){

    int gy=(pixelMatrix[0][0]*0)+(pixelMatrix[0][1]*-1)+(pixelMatrix[0][2]*0)+(pixelMatrix[1][0]*-1)+(pixelMatrix[1][1]*5)+(pixelMatrix[1][2]*-1)+(pixelMatrix[2][0]*0)+(pixelMatrix[2][1]*-1)+(pixelMatrix[2][2]*0);
    //int gx=(pixelMatrix[0][0])+(pixelMatrix[0][2]*-1)+(pixelMatrix[1][0]*2)+(pixelMatrix[1][2]*-2)+(pixelMatrix[2][0])+(pixelMatrix[2][2]*-1);
    return Math.sqrt(Math.pow(gy,2));

}
    
}

