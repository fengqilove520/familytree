package top.fqq.familytree.intercept;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import top.fqq.familytree.annotation.Dict;
import top.fqq.familytree.bean.MessageResult;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * 字典转义（有问题）
 *
 * @author fitch
 * @date 2021/9/16 14:12
 */
@Slf4j
@Component
@Intercepts(@Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = {Statement.class}))
public class DictPluginIntercept implements Interceptor {

    @Autowired
    private RestTemplate template;

    @Value("${server.port:8080}")
    private int port;

    @Value("${server.servlet.context-path:/}")
    private String path;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        List<Object> records = (List<Object>) invocation.proceed();
        List<String> dictTypes = new ArrayList<>();
        records.forEach(item -> {
            if (null != item) {
                this.toProcessDictType(item, dictTypes);
            }
        });

        if (CollUtil.isNotEmpty(dictTypes)) {
            // TODO 研究怎么走server层不和pagehelper 冲突,暂时先从前台走一圈
            String url = "http://localhost:" + this.port + "/" + path + "/api/dict/getDictListByTypes";
            ResponseEntity<MessageResult> result = template.postForEntity(url, dictTypes, MessageResult.class);
            List<LinkedHashMap<String, Object>> linkedHashMaps = (List<LinkedHashMap<String, Object>>) result.getBody().getData();
            records.forEach(item -> {
                this.processDict(item, linkedHashMaps);
            });
        }
        return records;
    }

    /**
     * 处理字典类型
     *
     * @param source
     * @param dictTypes
     */
    private void toProcessDictType(Object source, List<String> dictTypes) {
        // 拿到返回值类型
        Class<?> sourceClass = source.getClass();
        // 初始化返回值类型的 MetaObject
        MetaObject metaObject = SystemMetaObject.forObject(source);
        // 提取被 Dict 注解标注的属性使用的字典类型
        Stream.of(sourceClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Dict.class))
                .forEach(field -> {
                    if (String.class == metaObject.getGetterType(field.getName())) {
                        Dict annotation = field.getAnnotation(Dict.class);
                        String type = annotation.type();
                        if (!dictTypes.contains(type)) {
                            dictTypes.add(type);
                        }
                    } else {
                        log.error("Escaped values can only be assigned to properties of string type!");
                    }
                });
    }

    /**
     * 处理字典数据
     *
     * @param source
     * @param linkedHashMaps
     */
    private void processDict(Object source, List<LinkedHashMap<String, Object>> linkedHashMaps) {
        // 拿到返回值类型
        Class<?> sourceClass = source.getClass();
        // 提取被 Dict 注解标注的属性使用的字典类型
        Stream.of(sourceClass.getDeclaredFields()).forEach(field -> {
            if (field.isAnnotationPresent(Dict.class)) {
                Dict dict = field.getAnnotation(Dict.class);
                try {
                    Field fieldTemp = sourceClass.getDeclaredField(dict.codeFiled());
                    if (fieldTemp.getType() == Integer.class || fieldTemp.getType() == String.class) {
                        fieldTemp.setAccessible(true);
                        Object value = fieldTemp.get(source);
                        String valueStr = this.getDict(dict.type(), value, linkedHashMaps);
                        field.setAccessible(true);
                        field.set(source, valueStr);
                    } else {
                        log.error("Data types do not support escape!");
                    }
                } catch (NoSuchFieldException e) {
                    log.error(e.getMessage(), e);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
    }

    /**
     * 配置字典值
     *
     * @param type
     * @param code
     * @param linkedHashMaps
     * @return
     */
    private String getDict(String type, Object code, List<LinkedHashMap<String, Object>> linkedHashMaps) {
        for (LinkedHashMap<String, Object> item : linkedHashMaps) {
            if (item.get("type").equals(type) && item.get("code").equals(String.valueOf(code))) {
                return String.valueOf(item.get("name"));
            }
        }
        return null;
    }


}
