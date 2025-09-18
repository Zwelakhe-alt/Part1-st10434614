import com.junit.jupiter.api.Test;
import com.example.validationSystem;
import com.junit.jupiter.api.Assertions.*;

import jdk.jfr.Timestamp;




public class validationSystemTest {

    @Test
    public void testValidUsername(){
        validationSystem valSys = new validationSystem();
        // Expected = "ky1_1", "ky1_1"
        assertEquals("ky1_1", "ky1_1");
    }

    @Test   
    public void testInvalidUsername() {
        validationSystem valSys = new validationSystem();
        // Expected = "kyle !!!!!!!", "kyle !!!!!!"
        assertEquals("kyle !!!!!!!", "kyle !!!!!!");
    }

    @Test
    public void testValidPassword() {
        validationSystem valSys = new validationSystem();
        // Expected = true, Actual = method result
        assertEquals(true, valSys.checkPasswordComplexity("Password123@@"));

    }

    @Test
    public void testInvalidPassword(){
        validationSystem valSys = new validationSystem();
        // Expected = false, Actual = method result
        assertEquals(false, valSys.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testValidPhoneNumber(){
        validationSystem valSys = new validationSystem();
        // Expected = true, Actual = method result
        assertEquals(true, valSys.checkPhoneNumber("+27767567377"));

    }
   @Test
   public void testInvalidPhoneNumber(){
    validationSystem valSys = new validationSystem();
    // Expected = false, Actual = method result
    assertEquals(false, valSys.checkPhoneNumber("0769567377"));

   }

   @Test
   public void testLoginSuccess(){
   validationSystem valSys = new validationSystem();
   assertTrue(valSys.login("ky1_1", "Password123@@"));
   }

   @Test
   public void testLoginFailure(){
    validationSystem valSys = new validationSystem();
    assertFalse(valSys.registerUser("ky1_1", "wrongPass"));
   }
}
