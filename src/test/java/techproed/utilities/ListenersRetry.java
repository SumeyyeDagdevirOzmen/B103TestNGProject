package techproed.utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/*
1. Util Class olustur : ListenersRetry
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
2. Test sinifi olustur : ListenersTest3.  Listeners Retry i iliskilendir : @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
3. Sonuc : Eger herhangi bir test case FAIL olursa, bu test case 3 kez data run edilecektir.
 */
public class ListenersRetry implements IRetryAnalyzer {
    // Bu sinif SADECE FAIL OLAN TEST CASE LERI TEKRAR CALISTIRIR
    private int retryCount = 0;
    // maxRtryCount EK OLARAK CALISMA SAYISI. BU ORNEKDE KALAN TESTLER EKSTRA 1 KEZ DAHA CALISIR
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}