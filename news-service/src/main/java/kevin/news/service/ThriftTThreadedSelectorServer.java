package kevin.news.service;

import kevin.lib.util.SpringContextUtil;
import kevin.news.common.Const;
import kevin.news.service.thrift.NewsServiceHandler;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftTThreadedSelectorServer implements ThriftServer {
    private static Logger log = LoggerFactory.getLogger(ThriftTThreadedSelectorServer.class);

    @Override
    public void start() {
        try {
            log.info("ThriftServer starting....");
            TNonblockingServerSocket socket = new TNonblockingServerSocket(Const.THRIFT_PORT);
            
            NewsServiceHandler newsServiceHandler = (NewsServiceHandler) SpringContextUtil.getBean("newsServiceHandler");
            final kevin.news.thrift.NewsService.Processor processor = new kevin.news.thrift.NewsService.Processor(newsServiceHandler);
            
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(socket);
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.transportFactory(new TFramedTransport.Factory());
            args.processor(processor);
            args.workerThreads(Const.invoke_thread_num);
            args.selectorThreads = Const.work_thread_num;
            args.acceptQueueSizePerThread(100);
            
            log.info("ThriftServer starting, listening on " + Const.THRIFT_PORT);
            TThreadedSelectorServer server = new TThreadedSelectorServer(args);
            server.serve();
            
        } catch (Exception e) {
            log.error("thrift server 启动出错",e);
        }
    }
}
