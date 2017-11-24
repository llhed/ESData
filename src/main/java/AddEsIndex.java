/**
 * Created by lim on 17/11/24.
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.TransportClient;
import static org.elasticsearch.common.xcontent.XContentFactory.*;

public class AddEsIndex {

    // 文档索引
    private static final String Index = "test";

    public static void main(String[] args) {

        // 创建客户端
        TransportClient client = CreateEsClient.Client();

        SimpleDateFormat Formate = new SimpleDateFormat("yyyyMMdd");

        String IndexType = Formate.format(new Date(System.currentTimeMillis()));

        IndexRequestBuilder requestBuilder = client.prepareIndex(Index , IndexType).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);

        for (int i = 0; i < 1000; i++) {
            //IndexResponse response;
            // 写入一条数据
            try {
                //response = client.prepareIndex(Index, IndexType)
                        // 创建索引和类型 id自动生成
                requestBuilder.setSource(
                                jsonBuilder()
                                        .startObject()
                                                // 写入字段和值
                                        .field("domain", "www.baidu.com")
                                        .field("timestamp",
                                                String.valueOf(System
                                                        .currentTimeMillis() / 1000))
                                        .field("flow_size",
                                                String.valueOf((int) (Math
                                                        .random() * 10000)))
                                        .endObject()).get();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        // 关闭客户端
        client.close();
    }
}

