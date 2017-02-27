package something;

import java.util.*;

/**
 * 从csdn上看到的面试题---分段问题
 * 传送门: http://bbs.csdn.net/topics/391840266
 * 一组测试数据:
 * 4
 * 0 20 10
 * 20 40 20
 * 40 80 40
 * 80 100 20
 * 10 80
 * 所需时间:3.0
 * Created by skywalker on 2015/10/13.
 */
public class Section {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //段数
        int sections = Integer.parseInt(scanner.nextLine());
        List<Node> nodes = new ArrayList<>(sections);
        String[] line;
        for (int i = 0;i < sections;i ++) {
            line = scanner.nextLine().split(" ");
            nodes.add(new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }
        //出发点和终止点
        int start, end;
        line = scanner.nextLine().split(" ");
        start = Integer.parseInt(line[0]);
        end = Integer.parseInt(line[1]);
        Node.calTime(nodes, start, end);
        scanner.close();
    }

    /**
     * 一段(节点)
     */
    private static class Node {
        //起始位置
        private int start;
        //结束位置
        private int end;
        //最高速度
        private int speed;

        public Node(int start, int end, int speed) {
            this.start = start;
            this.end = end;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", speed=" + speed +
                    '}';
        }

        /**
         * 计算所需的时间
         * @param nodes 所有的段
         * @param b 出发点
         * @param e 终止点
         */
        private static void calTime(List<Node> nodes, int b, int e) {
            //按起始位置对段进行排序
            Collections.sort(nodes, (f, s) -> f.start - s.start);
            float time = 0f;
            Node node;
            for (int i = 0, l = nodes.size();i < l;i ++) {
                node = nodes.get(i);
                if (node.start > b) {
                    time += ((node.end > e ? e : node.end) - node.start) / ((float) node.speed);
                } else if (node.end < e) {
                    time += ((node.end > e ? e : node.end) - b) / ((float) node.speed);
                }
            }
            System.out.println("所需时间:" + time + "小时");
        }

    }

}
