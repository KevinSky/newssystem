package kevin.news.web.thrift;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

import kevin.news.thrift.NewsService;

public class NewsServiceClient extends NewsService.Client{
    private TTransport transport;

    public NewsServiceClient(TProtocol prot) {
        super(prot);
    }
    
    NewsServiceClient(TProtocol prot, TTransport tran) {
        super(prot);
        this.transport = tran;
    }

    public void close() {
        this.transport.close();
    }
}
