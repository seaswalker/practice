package something.trietree;


/**
 * TrieTree测试
 * @author skywalker
 *
 */
public class Test {

	public static void main(String[] args) {
		String[] ips = {
			"192.168.0.1",
			"192.168.233.45",
			"10.234.45.23"
		};
		TrieTree tree = new TrieTree();
		tree.build(ips);
		System.out.println("字典树初始化完成");
		System.out.println("192的搜索结果:");
		System.out.println(tree.search("192"));
		System.out.println("10.10.10.10的搜索结果:");
		System.out.println(tree.search("10.10.10.10"));
		System.out.println("10.234.45.23的搜索结果:");
		System.out.println(tree.search("10.234.45.23"));
	}
	
}
