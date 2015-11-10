package something.trietree;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树
 * @author skywalker
 *
 */
public class TrieTree {
	
	//此树的根节点
	private TreeNode root = new TreeNode();
	
	/**
	 * 向此树添加一个IP地址
	 * @param ip
	 */
	public void insert(String ip) {
		char[] arr = ip.toCharArray();
		int pos;
		TreeNode node = root;
		for (int i = 0, l = arr.length;i < l; ++i) {
			pos = arr[i] - 46;
			if (node.children[pos] == null) {
				node.children[pos] = new TreeNode(arr[i]);
				++node.count;
			}
			node = node.children[pos];
		}
		//测试代码
		System.out.println(ip + "节点插入完成");
	}
	
	/**
	 * 使用一组IP地址初始化一棵树
	 * @param ips ip地址数组
	 */
	public TrieTree build(String[] ips) {
		for (int i = 0, l = ips.length;i < l; ++i) {
			insert(ips[i]);
		}
		return this;
	}
	
	/**
	 * 在当前树中搜索IP
	 * @param ip
	 * @return 结果列表
	 */
	public List<String> search(String ip) {
		List<String> result = new ArrayList<String>();
		if (ip != null) {
			char[] arr = ip.toCharArray();
			TreeNode node = root;
			for (int index = 0, l = arr.length;index < l; ++index) {
				if (node.children[arr[index] - 46] == null) {
					return result;
				}
				node = node.children[arr[index] - 46];
			}
			if (node.count == 0) {
				//完全匹配
				result.add(ip);
			} else {
				//前缀搜索
				statisticsHelper(node, ip.substring(0, ip.length() - 1), result);
			}
		}
		return result;
	}
	
	/**
	 * 统计整棵字典树
	 */
	public List<String> statistics() {
		List<String> result = new ArrayList<String>();
		statisticsHelper(root, "", result);
		return result;
	}
	
	/**
	 * 递归打印字典树
	 * @param node 要访问的节点
	 * @param preStr 祖先节点字符串
	 */
	private void statisticsHelper(TreeNode node, String preStr, List<String> result) {
		preStr = node.value == '\0' ? preStr : preStr + node.value;
		if (node.count == 0) {
			result.add(preStr);
		} else {
			for (int i = 0;i < 12; ++i) {
				if (i != 1 && node.children[i] != null) {
					statisticsHelper(node.children[i], preStr, result);
				}
			}
		}
	}

	/**
	 * 字典树节点
	 * @author skywalker
	 *
	 */
	private static class TreeNode {
		private char value;
		//IP地址的节点的取值范围为0-9.共11个字符，由于.的ASCII码为46，0的为48，中间隔了/，所以需要长度为12的数组
		//使用特定的字符减去46或.即可获取对应的节点
		private TreeNode[] children = new TreeNode[12];
		//子节点的数量
		private int count = 0;
		
		TreeNode(char value) {
			this.value = value;
		}
		TreeNode() {}
		
		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", count=" + count + "]";
		}
		
	}
	
}
