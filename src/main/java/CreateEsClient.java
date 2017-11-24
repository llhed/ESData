/**
 * Created by lim on 17/11/24.
 */


import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class CreateEsClient {

    public static TransportClient Client() {

        // 设置集群名称
        Settings settings = Settings.builder()
                .put("cluster.name", "es_cluster").build();
        // 创建client
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(
                            InetAddress.getByName("118.190.207.92"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //返回client
        return client;
    }

    public static void main(String[] args) {

    }
}
