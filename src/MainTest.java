import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static String testAll = "QWERTYUIOP{}|!@#$%^&*()_+ASDFGHJKL:\"ZXCVBNM<>?~`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./'";
    public static String testNumeric = "1234567890";
    public static String testLower = "qwertyuiopasdfghjklzxcvbnm";
    public static String testUpper = "QWERTYUIOPASDFGHJKLZXCVBNM";

    @org.junit.jupiter.api.Test
    void countSpecialCharacters() {
        String test = "test123ABC!!@#$";
        int expected = 4;
        assertEquals(6, Main.countSpecialCharacters("TestPassword!!-2@#$%"));
        assertEquals(4, Main.countSpecialCharacters("abc123!!@#$"));
        assertEquals(2, Main.countSpecialCharacters("  ABC."));
        assertEquals(0, Main.countSpecialCharacters("ABCdef"));
        assertEquals(1, Main.countSpecialCharacters("password!"));
    }

    @org.junit.jupiter.api.Test
    void hasDigit() {
        assertEquals(true, Main.hasDigit("password123!"));
        assertEquals(true, Main.hasDigit("1"));
        assertEquals(false, Main.hasDigit("password!!"));
        assertEquals(false, Main.hasDigit("Password!!"));
    }

    @org.junit.jupiter.api.Test
    void hasUpperCase() {
        assertEquals(true, Main.hasUpperCase("Password123!"));
        assertEquals(true, Main.hasUpperCase("AAA"));
        assertEquals(false, Main.hasUpperCase("password123!"));
        assertEquals(false, Main.hasUpperCase("aaa"));

    }

    @org.junit.jupiter.api.Test
    void hasLowerCase() {
        assertEquals(true, Main.hasLowerCase("Password123!"));
        assertEquals(true, Main.hasLowerCase("aaa"));
        assertEquals(false, Main.hasLowerCase("PASSWORD123!"));
        assertEquals(false, Main.hasLowerCase("AAA"));
    }

    @org.junit.jupiter.api.Test
    void trimmedLength() {
        assertEquals(8, Main.trimmedLength("   password"));
        assertEquals(8, Main.trimmedLength("   password   "));
    }

    @org.junit.jupiter.api.Test
    void calculateRange() {
        assertEquals(26, Main.calculateRange("testpassword"));
        assertEquals(52, Main.calculateRange("Testpassword"));
        assertEquals(62, Main.calculateRange("TestPassword123"));
        assertEquals(63, Main.calculateRange("TestPassword123!!"));
        assertEquals(72, Main.calculateRange("TestPassword123!!@#$%^&*()"));

    }

    @org.junit.jupiter.api.Test
    void truncate() {
        assertEquals("TestPass...", Main.truncate("TestPassword!!", 8));
        assertEquals("TestPassword!!", Main.truncate("TestPassword!!", 20));
    }


    @org.junit.jupiter.api.Test
    void log2() {
        assertEquals(4.321928094887363, Main.log2(20));
    }

    @org.junit.jupiter.api.Test
    void calculateEntropy() {
        assertEquals(0, Main.calculateEntropy(""));
        assertEquals(14, Main.calculateEntropy("test"));
        assertEquals(62, Main.calculateEntropy("TestPassword"));
        assertEquals(95, Main.calculateEntropy("TestPassword123!!"));
        assertEquals(148, Main.calculateEntropy("TestPassword123!@#$%^&*()"));
    }

    @org.junit.jupiter.api.Test
    void evaluateEntropy() {
        assertEquals("Very Weak", Main.evaluateEntropy(0.0));
        assertEquals("Very Weak", Main.evaluateEntropy(64.0));
        assertEquals("Weak", Main.evaluateEntropy(65.0));
        assertEquals("Weak", Main.evaluateEntropy(80));
        assertEquals("Moderate", Main.evaluateEntropy(81.0));
        assertEquals("Moderate", Main.evaluateEntropy(112.0));
        assertEquals("Strong", Main.evaluateEntropy(113.0));
        assertEquals("Strong", Main.evaluateEntropy(128.0));
        assertEquals("Very Strong", Main.evaluateEntropy(129.0));
        assertEquals("Very Strong", Main.evaluateEntropy(1280.0));
    }

}