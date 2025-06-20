package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class JunitTest {

    private Method method;

    @BeforeEach
    public void setup() {
      
    }

    public void logger(String logtxt) {
        if (logtxt != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/coder/project/log.log", true))) {
                writer.write(logtxt);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File findTestJavaFile(String directoryPath) {
        File dir = new File(directoryPath);
        File[] matchingFiles = dir.listFiles((d, name) -> name.startsWith("Test") && name.endsWith(".java"));
        return (matchingFiles != null && matchingFiles.length > 0) ? matchingFiles[0] : null;
    }

    @Test
    public void testgetElementsByXPathFunctionality() {
        try {
            try {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath", String.class);
            } catch (NoSuchMethodException e) {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath");
            }
            assertNotNull(method, "Method 'getElementsByXPath' should exist in WebDriverHelper class");
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Method 'getElementsByXPath' not found in WebDriverHelper class: " + e.getMessage());
        }

        assertNotNull(method, "Method 'getElementsByXPath' should exist in WebDriverHelper class");
        logger("Verified_NotNull");
    }

    @Test
    public void testgetElementsByXPath_returnType() {
        try {
            try {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath", String.class);
            } catch (NoSuchMethodException e) {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath");
            }
            assertNotNull(method, "Method 'getElementsByXPath' should exist in WebDriverHelper class");
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Method 'getElementsByXPath' not found in WebDriverHelper class: " + e.getMessage());
        }

        assertEquals(List.class, method.getReturnType(), "Return type should be List.");
        logger("Verified_ReturnType");
    }

    @Test
    public void testgetElementsByXPath_Parameter() {

        try {
            try {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath", String.class);
            } catch (NoSuchMethodException e) {
                method = WebDriverHelper.class.getDeclaredMethod("getElementsByXPath");
            }
            assertNotNull(method, "Method 'getElementsByXPath' should exist in WebDriverHelper class");
        } catch (NoSuchMethodException | SecurityException e) {
            fail("Method 'getElementsByXPath' not found in WebDriverHelper class: " + e.getMessage());
        }
        
        Class<?>[] parameterTypes = method.getParameterTypes();
        assertEquals(1, parameterTypes.length, "Method should have exactly one parameter.");
        assertEquals(String.class, parameterTypes[0], "Method parameter should be of type String.");
        logger("Verified_ParameterType");
    }

   


@Test
    public void testHandleDropdownWithSelect() {
// Set the path to the Pages package
String pagesPath = "/home/coder/project/workspace/Project/src/test/java/pages"; // Adjust path as needed for your project structure
File pagesDir = new File(pagesPath);

if (!pagesDir.exists() || !pagesDir.isDirectory()) {
    fail("Pages directory not found at: " + pagesDir.getAbsolutePath());
}
File[] javaFiles = pagesDir.listFiles((dir, name) -> name.endsWith(".java"));
if (javaFiles == null || javaFiles.length == 0) {
    fail("No Java files found in Pages directory at: " + pagesDir.getAbsolutePath());
}

// assertNotNull(javaFiles, "No Java files found in Pages directory.");

boolean methodFound = false;

for (File file : javaFiles) {
    try {
        List<String> lines = Files.readAllLines(file.toPath());

        for (String line : lines) {
            if (line.contains("void handleDropdown") || line.contains("handleDropdown(")) {
                methodFound = true;
                System.out.println("Found 'handleDropdown' in file: " + file.getName());
                break;
            }
        }

        if (methodFound) break;

    } catch (IOException e) {
        fail("Failed to read file: " + file.getName() + " due to " + e.getMessage());
    }
}

assertTrue(methodFound, "No method named 'verifyTitle' found in any file within the Pages package.");

logger("Verified_handleDropdown_pages");


        Method handleDropdownMethod = null;
        try {
            // Try to get the handleDropdown method with parameters (String, String)
            try {
                handleDropdownMethod = WebDriverHelper.class.getDeclaredMethod("handleDropdown", String.class, String.class);
            } 
            catch (NoSuchMethodException e) 
            {
                fail("Method 'handleDropdown' with parameters (String, String) not found in WebDriverHelper class.");
            }

            // 1. Check if the method returns void
            assertEquals(void.class, handleDropdownMethod.getReturnType(), "Return type should be void.");

            // 2. Check if the method parameters are correct (String, String)
            Parameter[] parameters = handleDropdownMethod.getParameters();
            assertEquals(2, parameters.length, "Expected two parameters.");
            assertEquals(String.class, parameters[0].getType(), "First parameter should be of type String.");
            assertEquals(String.class, parameters[1].getType(), "Second parameter should be of type String.");

    logger("Verified_select_methodSignature");

         

        }
         catch (Exception e)
         {
            fail("Reflection failed: " + e.getMessage());
        }

        String sourcePath = "/home/coder/project/workspace/Project/src/test/java/utils/WebDriverHelper.java"; // Adjust path
        File file = new File(sourcePath);
        boolean methodCallFound = false;
    
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                if (line.contains("selectByVisibleText")) {
                    methodCallFound = true;
                    break;
                }
            }
            assertTrue(methodCallFound, "Method call 'selectByVisibleText' not found.");
            logger("Verified_selectByVisibleText_Used");


        } catch (IOException e) {
            fail("Unable to read file: " + e.getMessage());
        }

    }

@Test
    public void testVerifyTitleExistsInPagesPackage() {
        // Set the path to the Pages package
        String pagesPath = "/home/coder/project/workspace/Project/src/test/java/pages"; // Adjust path as needed for your project structure
        File pagesDir = new File(pagesPath);

        if (!pagesDir.exists() || !pagesDir.isDirectory()) {
            fail("Pages directory not found at: " + pagesDir.getAbsolutePath());
        }
        File[] javaFiles = pagesDir.listFiles((dir, name) -> name.endsWith(".java"));
        if (javaFiles == null || javaFiles.length == 0) {
            fail("No Java files found in Pages directory at: " + pagesDir.getAbsolutePath());
        }
        
        // assertNotNull(javaFiles, "No Java files found in Pages directory.");

        boolean methodFound = false;

        for (File file : javaFiles) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());

                for (String line : lines) {
                    if (line.contains("void verifyTitle") || line.contains("verifyTitle(")) {
                        methodFound = true;
                        System.out.println("Found 'verifyTitle' in file: " + file.getName());
                        break;
                    }
                }

                if (methodFound) break;

            } catch (IOException e) {
                fail("Failed to read file: " + file.getName() + " due to " + e.getMessage());
            }
        }

        assertTrue(methodFound, "No method named 'verifyTitle' found in any file within the Pages package.");
    
        logger("VerifiedTitle_pages");

        Method AssertEquals = null;

        try {
            // Try to get the handleDropdown method with parameters (String, String)
            try {
                AssertEquals = WebDriverHelper.class.getDeclaredMethod("verifyTitle", String.class, String.class);
            } 
            catch (NoSuchMethodException e) 
            {
                fail("Method 'verifyTitle' with parameters (String, String) not found in WebDriverHelper class.");
            }

            // 1. Check if the method returns void
            assertEquals(void.class, AssertEquals.getReturnType(), "Return type should be void.");

            // 2. Check if the method parameters are correct (String, String)
            Parameter[] parameters = AssertEquals.getParameters();
            assertEquals(2, parameters.length, "Expected two parameters.");
            assertEquals(String.class, parameters[0].getType(), "First parameter should be of type String.");
            assertEquals(String.class, parameters[1].getType(), "Second parameter should be of type String.");
       

      

            logger("VerifiedTitle_methodSignature");


        String sourcePath = "/home/coder/project/workspace/Project/src/test/java/utils/WebDriverHelper.java"; // Adjust path
       
        // File sourceFile = new File(sourcePath);

        File dir = new File(sourcePath);



        if (dir != null) {
            System.out.println("Found file: " + dir.getAbsolutePath());
        } else {
            System.out.println("No matching file found.");
            fail("No Java file starting with 'Test' found in directory.");
        }

        boolean assertFound = false;
        try {
            List<String> lines = Files.readAllLines(dir.toPath());
            for (String line : lines) {
                if (line.contains("assertTrue") || line.contains("assertEquals")) {
                    assertFound = true;
                    break;
                }
            }
            assertTrue(assertFound, "assertEquals not used to verify the page title ");
           
            logger("Verified_AssertEqualsTitleCheck");
        } 
        catch (IOException e) {
            fail("Could not read source file: " + e.getMessage());
        }
    }
    catch (Exception e)
    {
       fail("Reflection failed: " + e.getMessage());
   }

    

    }

}
