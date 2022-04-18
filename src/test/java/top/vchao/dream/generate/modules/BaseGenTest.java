package top.vchao.dream.generate.modules;

import top.vchao.dream.generate.GenCommon;

/**
 * 代码生成基类
 */
public class BaseGenTest {

    /**
     * 采用默认配置生成代码
     *
     * @param moduleName 模块名称
     * @param tableName  表名
     * @param prefix     字段前缀
     */
    public void genCode(String moduleName, String tableName, String prefix) {
        System.out.println("====>  start generate " + moduleName + " code  <====");

        GenCommon.getAutoGenerator(moduleName, tableName)
                .strategyConfig(builder -> {
                    builder.addFieldPrefix(prefix);
                })
                .execute();

        System.out.println("====>  end generate " + moduleName + " code  <====");
    }
}
