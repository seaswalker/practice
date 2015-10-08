package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Formatter;

public class Test {

	public static void main(String[] args) throws SecurityException, IOException {
		Logger logger = Logger.getLogger("log");
		logger.setLevel(Level.INFO);
		
		//处理器,指向控制台System.err
		/*ConsoleHandler consoleHandler = new ConsoleHandler();
		logger.addHandler(consoleHandler);*/
		
		//指向文件的hanlder,指向C盘会出错
		FileHandler fileHandler = new FileHandler("D:/testlog%g.log");
		fileHandler.setFormatter(new MyFormatter());
		logger.addHandler(fileHandler);
		
		logger.info("日志记录");
		
		logger.fine("fine");
	}
	
}

/**
 * 自定义日志处理
 * @author skywalker
 *
 */
class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return record.getLevel() + ":" + record.getMessage();
	}
	
}
