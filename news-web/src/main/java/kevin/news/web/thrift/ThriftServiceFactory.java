package kevin.news.web.thrift;

import kevin.lib.thrift.pool.ConnectionProvider;
import kevin.news.common.Const;
import kevin.news.thrift.NewsService.Iface;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thriftServiceFactory")
public class ThriftServiceFactory {
    private static Logger log = LoggerFactory.getLogger(ThriftServiceFactory.class);
    
    @Autowired
    private ConnectionProvider connectionProvider;
    
    public static NewsServiceClient genNewsServiceClient() {
        TFramedTransport frame = new TFramedTransport(new TSocket("localhost", Const.THRIFT_PORT));
        TBinaryProtocol protocol = new TBinaryProtocol(new TSocket("localhost", Const.THRIFT_PORT));
        NewsServiceClient client = new NewsServiceClient(protocol, frame);
        try {
            frame.open();
        } catch (TTransportException e) {
            log.error("建立thrift连接出错",e);
        }
        return client;
    }
    
    public ThriftClientWrapper<Iface> createNewsWrap() {
        ThriftClientWrapper<Iface> client = null;
        try {
            client = factory.createClient();
        } catch (Exception e) {
            log.error("get thrift connection error", e);
        }
        return client;
    }
}
