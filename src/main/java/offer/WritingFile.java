package offer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 写文件问题, 谷歌面试题.
 *
 * @author skywalker
 */
public class WritingFile {

    private final String folder = "data/";
    private int[] nextMap = new int[]{0, 1, 2, 3, 0};
    private int[] map = new int[5];
    private BufferedOutputStream[] boses;

    /**
     * 初始化文件输出流.
     *
     * @throws FileNotFoundException 如果目录不存在
     */
    private void initBoses() throws FileNotFoundException {
        File dir = new File(folder);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        boses = new BufferedOutputStream[4];
        boses[0] = new BufferedOutputStream(new FileOutputStream(folder + "A"));
        boses[1] = new BufferedOutputStream(new FileOutputStream(folder + "B"));
        boses[2] = new BufferedOutputStream(new FileOutputStream(folder + "C"));
        boses[3] = new BufferedOutputStream(new FileOutputStream(folder + "D"));
    }

    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        WritingFile w = new WritingFile();
        w.initBoses();
        w.start();
        System.out.println("写入完成");
    }

    private void start() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Writer> writers = new ArrayList<>(4);
        writers.add(new Writer(1));
        writers.add(new Writer(2));
        writers.add(new Writer(3));
        writers.add(new Writer(4));
        int i = 0;
        while (i++ < 10) {
            map = nextMap;
            nextMap = new int[5];
            List<Future<Object>> futures = executor.invokeAll(writers);
            for (Future future : futures) {
                future.get();
            }
        }
        executor.shutdown();
    }

    private class Writer implements Callable<Object> {

        private final int data;
        private final int pre;

        private Writer(int data) {
            this.data = data;
            this.pre = (data == 1 ? 4 : data - 1);
        }

        @Override
        public Object call() {
            try {
                final BufferedOutputStream bos = boses[map[pre]];
                bos.write(String.valueOf(data).getBytes());
                bos.flush();
                nextMap[data] = map[pre];
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new Object();
        }

    }

}
