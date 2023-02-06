package utilities;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

public class AssertUtils {


    public static void assertEquals(Object objActual, Object objExpected) {
        try {
            SoftAssert sAssert = new SoftAssert();
            sAssert.assertEquals(objActual == null ? "Actual Data received is null.." : objActual.toString().trim(), objExpected.toString().trim());
            sAssert.assertAll();
        } catch (AssertionError | Exception e) {
            throw e;
        }
    }

    public static void assertNotNull(Object objFullData) {
        try {
            SoftAssert sAssert = new SoftAssert();
            sAssert.assertNotNull(objFullData);
            sAssert.assertAll();
        } catch (AssertionError | Exception e) {
            throw e;
        }
    }

}
