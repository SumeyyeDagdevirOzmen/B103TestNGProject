package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    //Bu sinifi olusturmamizin amaci,TUM FAIL OLAN TEST CASELERI BIR KEZ DAHA OTOMATIK OLARAK XML FILE ILE RUN ETMEK
    //BU SINIF ListenersRetry SINIFINI xml DE  KULLANABILMEK ICIN OLUSTURULDU
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Bu sinif ListenersRetry util clasina baglidir.
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
