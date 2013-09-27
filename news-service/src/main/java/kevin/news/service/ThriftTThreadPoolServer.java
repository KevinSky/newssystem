package kevin.news.service;

import kevin.lib.util.SpringContextUtil;
import kevin.news.common.Const;
import kevin.news.service.thrift.NewsServiceHandler;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftTThreadPoolServer implements ThriftServer {

    private static Logger log = LoggerFactory.getLogger(ThriftTThreadPoolServer.class);

    @Override
    public void start() {
        try {
            log.info("ThriftServer starting....");
            TServerSocket socket = new TServerSocket(Const.THRIFT_PORT);
            
            NewsServiceHandler newsServiceHandler = (NewsServiceHandler) SpringContextUtil.getBean("newsServiceHandler");
            final kevin.news.thrift.NewsService.Processor processor = new kevin.news.thrift.NewsService.Processor(newsServiceHandler);
            
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(socket);
            args.protocolFactory(new TBinaryProtocol.Factory(true, true));
//            args.transportFactory(new TFramedTransport.Factory());
            args.processor(processor);
            args.minWorkerThreads = Const.work_thread_num;
            args.maxWorkerThreads = Const.work_thread_num;
            
            
            log.info("ThriftServer starting, listening on " + Const.THRIFT_PORT);
            TThreadPoolServer server = new TThreadPoolServer(args);
            
            server.serve();
            
        } catch (Exception e) {
            log.error("thrift server 启动出错",e);
        }
    }
}
