package org.magellanhealth.Listeners;

import org.magellanhealth.utils.DataProviderUtils;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);

    }
}
