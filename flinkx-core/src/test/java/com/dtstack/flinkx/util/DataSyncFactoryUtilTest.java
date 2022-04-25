//package com.dtstack.flinkx.util;
//
//import com.dtstack.flinkx.Main;
//import com.dtstack.flinkx.conf.SyncConf;
//import com.dtstack.flinkx.environment.EnvFactory;
//import com.dtstack.flinkx.options.OptionParser;
//import com.dtstack.flinkx.options.Options;
//import com.dtstack.flinkx.source.SourceFactory;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.junit.Test;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;
//
//public class DataSyncFactoryUtilTest {
//    @Test
//    public void Test01() throws Exception {
//        String[] args =new String[0];
//        Options options = new OptionParser(args).getOptions();
//        String job = URLDecoder.decode("%7B%0A++%22job%22%3A+%7B%0A++++%22content%22%3A+%5B%0A++++++%7B%0A++++++++%22reader%22%3A+%7B%0A++++++++++%22parameter%22%3A+%7B%0A++++++++++++%22column%22%3A+%5B%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22id%22%2C%0A++++++++++++++++%22type%22%3A+%22id%22%0A++++++++++++++%7D%2C%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22name%22%2C%0A++++++++++++++++%22type%22%3A+%22string%22%0A++++++++++++++%7D%2C%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22content%22%2C%0A++++++++++++++++%22type%22%3A+%22string%22%0A++++++++++++++%7D%0A++++++++++++%5D%2C%0A++++++++++++%22sliceRecordCount%22%3A+%5B%2230%22%5D%2C%0A++++++++++++%22permitsPerSecond%22%3A+1%0A++++++++++%7D%2C%0A++++++++++%22table%22%3A+%7B%0A++++++++++++%22tableName%22%3A+%22sourceTable%22%0A++++++++++%7D%2C%0A++++++++++%22name%22%3A+%22streamreader%22%0A++++++++%7D%2C%0A++++++++%22writer%22%3A+%7B%0A++++++++++%22parameter%22%3A+%7B%0A++++++++++++%22column%22%3A+%5B%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22id%22%2C%0A++++++++++++++++%22type%22%3A+%22id%22%0A++++++++++++++%7D%2C%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22name%22%2C%0A++++++++++++++++%22type%22%3A+%22string%22%0A++++++++++++++%7D%2C%0A++++++++++++++%7B%0A++++++++++++++++%22name%22%3A+%22content%22%2C%0A++++++++++++++++%22type%22%3A+%22timestamp%22%0A++++++++++++++%7D%0A++++++++++++%5D%2C%0A++++++++++++%22print%22%3A+true%0A++++++++++%7D%2C%0A++++++++++%22table%22%3A+%7B%0A++++++++++++%22tableName%22%3A+%22sinkTable%22%0A++++++++++%7D%2C%0A++++++++++%22name%22%3A+%22streamwriter%22%0A++++++++%7D%2C%0A++++++++%22transformer%22%3A+%7B%0A++++++++++%22transformSql%22%3A+%22select+id%2Cname%2C+NOW%28%29+from+sourceTable+where+CHAR_LENGTH%28name%29+%3C+50+and+CHAR_LENGTH%28content%29+%3C+50%22%0A++++++++%7D%0A++++++%7D%0A++++%5D%2C%0A++++%22setting%22%3A+%7B%0A++++++%22errorLimit%22%3A+%7B%0A++++++++%22record%22%3A+100%0A++++++%7D%2C%0A++++++%22speed%22%3A+%7B%0A++++++++%22bytes%22%3A+0%2C%0A++++++++%22channel%22%3A+1%2C%0A++++++++%22readerChannel%22%3A+1%2C%0A++++++++%22writerChannel%22%3A+1%0A++++++%7D%0A++++%7D%0A++%7D%0A%7D%0A", StandardCharsets.UTF_8.name());
//
//        StreamExecutionEnvironment env = EnvFactory.createStreamExecutionEnvironment(options);
//        SyncConf config = Main.parseFlinkxConf(job, options);
//        Main.configStreamExecutionEnvironment(env, options, config);
//
//        //使用
//        SourceFactory sourceFactory = DataSyncFactoryUtil.discoverSource(config, env);
//    }
//}
