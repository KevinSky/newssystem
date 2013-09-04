package kevin.news.service;

import kevin.lib.util.SpringContextUtil;
import kevin.news.service.thrift.NewsServiceHandler;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftServer {
    private static Logger log = LoggerFactory.getLogger(ThriftServer.class);
    
    public void start() {
        try {
            log.info("ThriftServer starting....");
            TNonblockingServerSocket socket = new TNonblockingServerSocket(9999);
            
            NewsServiceHandler newsServiceHandler = (NewsServiceHandler) SpringContextUtil.getBean("newsServiceHandler");
            final kevin.news.thrift.NewsService.Processor processor = new kevin.news.thrift.NewsService.Processor(newsServiceHandler);
            
            THsHaServer.Args args = new THsHaServer.Args(socket);
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.transportFactory(new TFramedTransport.Factory());
            args.processor(processor);
            
            log.info("ThriftServer starting, listening on " + 9999);
            THsHaServer server = new THsHaServer(args);
            server.serve();
            
        } catch (Exception e) {
            log.error("thrift server 启动出错",e);
        }
    }

}
