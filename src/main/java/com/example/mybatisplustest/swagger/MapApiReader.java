package com.example.mybatisplustest.swagger;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.util.Map;

/**
 * <p> swagger 解析 json 类型参数 </p>
 *
 * @author LiZijing
 * @className MapApiReader
 * @date 2021/9/5
 */
@Component
@Order   //plugin加载顺序，默认是最后加载
public class MapApiReader implements ParameterBuilderPlugin {

    private final static String basePackage = "com.example.mybatisplustest.swagger.model.";  //动态生成的Class名
    @Autowired
    private TypeResolver typeResolver;

    @Override
    public void apply(ParameterContext parameterContext) {
        ResolvedMethodParameter methodParameter = parameterContext.resolvedMethodParameter();

        if (methodParameter.getParameterType().canCreateSubtype(JSONObject.class) || methodParameter.getParameterType().canCreateSubtype(Map.class) || methodParameter.getParameterType().canCreateSubtype(String.class)) { //判断是否需要修改对象ModelRef,这里我判断的是Map类型和String类型需要重新修改ModelRef对象
            Optional<ApiJsonObject> optional = methodParameter.findAnnotation(ApiJsonObject.class);  //根据参数上的ApiJsonObject注解中的参数动态生成Class
            if (optional.isPresent()) {
                String name = optional.get().name();  //model 名称
                String paramType = optional.get().paramType();  //请求类型
                ApiJsonProperty[] properties = optional.get().value();

                parameterContext.getDocumentationContext().getAdditionalModels().add(typeResolver.resolve(createRefModel(properties, name)));  //像documentContext的Models中添加我们新生成的Class

                parameterContext.parameterBuilder()  //修改Map参数的ModelRef为我们动态生成的class
                        .parameterType(paramType)
                        .modelRef(new ModelRef(name)).description("对象参数")
                        .name(name);
            }
        }
    }

    /**
     * 根据propertys中的值动态生成含有Swagger注解的javaBeen
     */
    private Class createRefModel(ApiJsonProperty[] propertys, String name) {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass(basePackage + name);

        try {
            for (ApiJsonProperty property : propertys) {
                ctClass.addField(createField(property, ctClass));
            }
            return ctClass.toClass();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据property的值生成含有swagger apiModelProperty注解的属性
     */
    private CtField createField(ApiJsonProperty property, CtClass ctClass) throws NotFoundException, CannotCompileException {
        CtField ctField = new CtField(getFieldType(property.type()), property.key(), ctClass);
        ctField.setModifiers(Modifier.PUBLIC);

        ConstPool constPool = ctClass.getClassFile().getConstPool();

        AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        Annotation ann = new Annotation("io.swagger.annotations.ApiModelProperty", constPool);
        ann.addMemberValue("value", new StringMemberValue(property.description(), constPool));
        ann.addMemberValue("type", new StringMemberValue(property.type(), constPool));
        ann.addMemberValue("paramType", new StringMemberValue(property.paramType(), constPool));
        ann.addMemberValue("required", new BooleanMemberValue(property.required(), constPool));
        if (ctField.getType().subclassOf(ClassPool.getDefault().get(String.class.getName())))
            ann.addMemberValue("example", new StringMemberValue(property.example(), constPool));
        if (ctField.getType().subclassOf(ClassPool.getDefault().get(int.class.getName())))
            ann.addMemberValue("example", new IntegerMemberValue(constPool, Integer.parseInt(property.example())));
//            ann.addMemberValue("example", new IntegerMemberValue(Integer.parseInt(property.example()), constPool));

        attr.addAnnotation(ann);
        ctField.getFieldInfo().addAttribute(attr);

        return ctField;
    }

    private CtClass getFieldType(String type) throws NotFoundException {
        CtClass fileType = null;
        switch (type) {
            case "String":
                fileType = ClassPool.getDefault().get(String.class.getName());
                break;
            case "int":
                fileType = ClassPool.getDefault().get(int.class.getName());
                break;
        }
        return fileType;
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}

