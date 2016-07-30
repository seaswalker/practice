package xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * 使用Sax的方式
 * @author skywalker
 *
 */
public class SaxReader {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		BookHandler bookHandler = (new SaxReader()).new BookHandler();
		reader.setContentHandler(bookHandler);
		reader.parse(new InputSource(SaxReader.class.getResourceAsStream("book.xml")));
		System.out.println(bookHandler.getNameList());
	}
	
	private class BookHandler extends DefaultHandler {
		
		private List<String> nameList;
		//标志解析到title节点
		private boolean title = false;
		
		public List<String> getNameList() {
			return nameList;
		}

		@Override
		public void startDocument() throws SAXException {
			nameList = new ArrayList<>();
			System.out.println("Start parsing document.");
		}
		
		@Override
		public void endDocument() throws SAXException {
			System.out.println("end parsing document.");
		}
		
		/**
		 * 开始处理一个节点
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("title")) title = true;
		}
		
		/**
		 * 停止处理当前节点
		 */
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (title) title = false;
		}
		
		/**
		 * 读取到节点的内容
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			if (title) {
				String bookTitle = new String(ch, start, length);
				System.out.println("book: " + bookTitle + " was paresed");
				nameList.add(bookTitle);
			}
		}
		
	}
	
}
