package cn.wangzhikun;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: generate-code-util
 * @ClassName GenerateCodeUtil
 * @description: 通过数据库表生成实体、mapper、service、controller 代码
 * @author: wangzhikun
 * @create: 2024-06-07 09:57
 **/
public class GenerateCodeUtil {

    /**
     * 数据库url  PS: 不同的数据库类型 注意更换TYPE_CONVERT与KEY_WORDS_HANDLER与当前数据库一致
     */
    private static final String URL = "jdbc:mysql://db.a-dog.cn:33306/auth?characterEncoding=utf-8&useSSL=false";


    /**
     * 数据库用户名
     */
    private static final String USERNAME = "wzk";

    /**
     * 数据库密码
     */
    private static final String PASSWORD = "722104";


    /**
     * schema  用于有schema的数据库 如金仓、dm
     */
    private static final String SCHEMA_NAME = "";

    /**
     * 表名
     */
    private static final List<String> TABLE_NAMES = new ArrayList<>();
    static {
        TABLE_NAMES.add("oauth_access_token");
        TABLE_NAMES.add("oauth_authorization_code");
        TABLE_NAMES.add("oauth_client");
        TABLE_NAMES.add("permission");
        TABLE_NAMES.add("role");
        TABLE_NAMES.add("role_permission");
        TABLE_NAMES.add("tenant");
        TABLE_NAMES.add("user");
        TABLE_NAMES.add("user_role");
    }

    /**
     * 数据类型转换器  用于生成代码时 字段类型和Java类型的转换 如果转换类型不符合要求 可以自定义实现ITypeConvert
     */
    private static final ITypeConvert TYPE_CONVERT = new MySqlTypeConvert();


    /**
     * 数据库关键字处理器 用于生成代码时 处理关键字  如现有不符合要求 可以自定义实现IKeyWordsHandler
     */
    private static final IKeyWordsHandler KEY_WORDS_HANDLER = new MySqlKeyWordsHandler();


    /**
     * 生成文件输出目录
     */
    private static final String OUT_PATH = "src\\main\\";


    /**
     *  代码输出目录
     */
    private static  final  String CLASS_PATH =OUT_PATH+"java/";

    /**
     * xml 输出目录
     */
    private static final String XML_PATH = OUT_PATH+"resources/mapper/";

    /**
     * 作者
     */
    private static final String AUTHOR = "wangzhikun";

    /**
     * 包名
     */
    private static final String PACKAGE_NAME = "cn.a_dog";

    /**
     * 模块名
     */
    private static final String MODEL_NAME = "oauth";

    /**
     * controller 包名
     */
    private static final String CONTROLLER_NAME = "controller";

    /**
     * service 包名
     */
    private static final String SERVICE_NAME = "service";

    /**
     * service.impl 包名
     */
    private static final String SERVICE_IMPL_NAME = "service.impl";

    /**
     * 实体类包名
     */
    private static final String ENTITY_NAME = "entity";

    /**
     * mapper 包名
     */
    private static final String MAPPER_NAME = "mapper";

    /**
     * mapper xml包名
     */
    private static final String MAPPER_XML_NAME = "mapper.xml";

    /**
     * 生成注释的时间格式
     */
    private static final String PATTERN = "yyyy-MM-dd HH:mm";

    /**
     *  service 文件名称格式
     */
    private static final String SERVICE_NAME_FORMAT = "%sService";

    /**
     * 是否生成实体类
     */
    private static final boolean ENTITY_GENERATE = true;

    /**
     * 是否生成mapper
     */
    private static final boolean MAPPER_GENERATE = true;

    /**
     * 是否生成mapper.xml
     */
    private static final boolean MAPPER_XML_GENERATE = true;

    /**
     * 是否生成service
     */
    private static final boolean SERVICE_GENERATE = true;

    /**
     * 是否生成service.impl
     */
    private static final boolean SERVICE_IMPL_GENERATE = true;

    /**
     * 是否生成controller
     */
    private static final boolean CONTROLLER_GENERATE = true;

    public static void main(String[] args) {
        generateCode();
    }

    public static void generateCode() {
        // 构建生成器对象
        AutoGenerator generator=new AutoGenerator(initDataSourceConfig());

        // 设置全局配置信息
        generator.global(initGlobalConfig());

        // 设置包配置信息
        generator.packageInfo(initPackageConfig());

        // 设置策略配置信息
        generator.strategy(initStrategyConfig());

        // 执行  使用 freemarker 模板引擎
        generator.execute(new FreemarkerTemplateEngine());

    }


    /**
     * @return com.baomidou.mybatisplus.generator.config.DataSourceConfig
     * @description: 构造数据源配置
     * @author: wangzhikun
     * @date: 2024/6/7 10:41
     */
    private static DataSourceConfig initDataSourceConfig() {

        // DataSourceConfig 构造器
        DataSourceConfig.Builder builder = new DataSourceConfig
                // 数据库配置
                .Builder(URL, USERNAME, PASSWORD)
                // 数据库字段类型转换器
                .typeConvert(TYPE_CONVERT)
                // 数据库关键字处理器
                .keyWordsHandler(KEY_WORDS_HANDLER);

        // 如果有schema 则设置
        if (SCHEMA_NAME != null && !"".equals(SCHEMA_NAME)) {
            builder.schema(SCHEMA_NAME);
        }

        // 构造数据源
        return builder.build();
    }


    /**
     * @return com.baomidou.mybatisplus.generator.config.GlobalConfig
     * @description: 初始化全局配置
     * @author: wangzhikun
     * @date: 2024/6/7 10:55
     */
    private static GlobalConfig initGlobalConfig() {
        return new GlobalConfig.Builder()
                //禁止生成文件后 打开文件目录
                .disableOpenDir()
                // 文件输出目录
                .outputDir(CLASS_PATH)
                //  数据库时间 to Java时间类型策略
                .dateType(DateType.TIME_PACK)
                // 注释时间格式
                .commentDate(PATTERN)
                // 作者
                .author(AUTHOR)
                // 构造全局配置
                .build();
    }

    /**
     * @return com.baomidou.mybatisplus.generator.config.PackageConfig
     * @description: 初始化包配置
     * @author: wangzhikun
     * @date: 2024/6/7 11:19
     */
    private static PackageConfig initPackageConfig() {
        return new PackageConfig.Builder()
                // 父包名
                .parent(PACKAGE_NAME)
                // 模块名
                .moduleName(MODEL_NAME)
                // Controller 包名
                .controller(CONTROLLER_NAME)
                // Service 包名
                .service(SERVICE_NAME)
                // ServiceImpl 包名
                .serviceImpl(SERVICE_IMPL_NAME)
                // Entity 包名
                .entity(ENTITY_NAME)
                // Mapper 包名
                .mapper(MAPPER_NAME)
                // Mapper xml 包名
                .xml(MAPPER_XML_NAME)
                .pathInfo(Collections.singletonMap(OutputFile.xml, XML_PATH))
                // 构造包配置
                .build();
    }


    /**
     * @return com.baomidou.mybatisplus.generator.config.StrategyConfig
     * @description: 初始化策略配置
     * @author: wangzhikun
     * @date: 2024/6/7 11:53
     */
    private static StrategyConfig initStrategyConfig() {
        //  策略配置
        StrategyConfig.Builder builder = new StrategyConfig.Builder()
                // 添加表名
                .addInclude(TABLE_NAMES);

        // 实体策略
        builder.entityBuilder()
                //  字段注解
                .enableTableFieldAnnotation()
                // lombok
                .enableLombok()
                // 禁用序列化
                .disableSerialVersionUID();
        if (!ENTITY_GENERATE) {
            // 禁用实体生成
            builder.entityBuilder().disable();
        }

        // controller 策略
        builder.controllerBuilder()
                // 开启生成@RestController控制器
                .enableRestStyle();
        if (!CONTROLLER_GENERATE) {
            // 禁用controller生成
            builder.controllerBuilder().disable();
        }

        // Service 策略
        builder.serviceBuilder()
                // 格式化service 名称
                .formatServiceFileName(SERVICE_NAME_FORMAT);
        if (!SERVICE_GENERATE) {
            // 禁用service生成
            builder.serviceBuilder().disableService();
        }

        // ServiceImpl 策略
        if (!SERVICE_IMPL_GENERATE) {
            // 禁用serviceImpl生成
            builder.serviceBuilder().disableService();
        }

        // Mapper 策略
        builder.mapperBuilder()
                // 添加mapper 注解
                .mapperAnnotation(Mapper.class);
        if (!MAPPER_GENERATE){
            // 禁用mapper生成
            builder.mapperBuilder().disableMapper();
        }
        if (!MAPPER_XML_GENERATE){
            // 禁用mapper xml生成
            builder.mapperBuilder().disableMapperXml();
        }
        return builder.build();

    }

}