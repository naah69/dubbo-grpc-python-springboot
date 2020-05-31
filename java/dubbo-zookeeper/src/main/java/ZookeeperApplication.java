/**
 * ZookeeperApplication
 *
 * @author naah
 * @date 2020-05-31 6:22 下午
 * @desc
 */
public class ZookeeperApplication {
    public static void main(String[] args) {
        new EmbeddedZooKeeper(2181, false).start();
    }
}
