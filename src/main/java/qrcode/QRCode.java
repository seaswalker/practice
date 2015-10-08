package qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 生成二维码
 * @author skywalker
 *
 */
public class QRCode {
	
	private static String path = "C:/Users/xsdwe_000/Desktop/qrcode.jpg";
	
	public static void main(String[] args) {
		analyseQRCode();
	}
	
	/**
	 * 生成二维码
	 */
	@SuppressWarnings("deprecation")
	public static void generateQRCode() {
		try {
			//内容，正确的连接可以实现跳转
			String content = "http://www.baidu.com";
			
			Map<EncodeHintType,String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			BitMatrix matrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
			File file = new File(path);
			MatrixToImageWriter.writeToFile(matrix, "jpg", file);
			System.out.println("SUCCESS");
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析二维码
	 */
	public static void analyseQRCode() {
		try {
            MultiFormatReader formatReader = new MultiFormatReader();
			File file = new File(path);
			BufferedImage image = ImageIO.read(file);;
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer  binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = formatReader.decode(binaryBitmap,hints);
			
			System.out.println("result = "+ result.toString());
			System.out.println("resultFormat = "+ result.getBarcodeFormat());
			System.out.println("resultText = "+ result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
