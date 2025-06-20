
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;


public class EventHandler implements WebDriverListener {

    private AtomicInteger getTextCounter = new AtomicInteger(0);
    private boolean isDoubleSidedFound = false; 

    public void logger(String logtxt) {
        if(logtxt != null) {
            try {
                File file = new File("/home/coder/project/log.log");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(logtxt);             
                writer.write("\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void beforeClick(WebElement element) {
            WebDriverListener.super.beforeClick(element);

            String textValue = element.getText();
            String attributeValue = element.getAttribute("value");

            if (textValue == null || textValue.isEmpty()) {
                logger("Clicked " + attributeValue);
            } else {
                logger("Clicked " + textValue);
            }
            logger(textValue+ attributeValue);
            
     }
    
    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        logger(keysToSend[0].toString()+" value entered");
    }

    @Override
    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
        WebDriverListener.super.beforePerform(driver, actions);

        String regex = "xpath: (.*?)(?=]})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(actions.iterator().next().toJson().toString());

        if (matcher.find()) {
            String xpath = matcher.group(1);
            logger("Hovered "+ driver.findElement(By.xpath(xpath)).getText());
        } else {
            logger("XPath not found.");
        }
    }
 @Override
public void afterGetTitle(WebDriver driver, String result) {
    logger("Page title-" + result);
}


 @Override
public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
    WebDriverListener.super.afterFindElements(driver, locator, result);

    // Check if result size is greater than or equal to 24
    if (result.size() >= 24) {
        logger("Found List of WebElements size greater than twenty four "+ result.size());
    } else {
        logger(result.size() + "failed list");
    }
}

@Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger("Element found using: " + locator.toString());
    }

    @Override
    public void afterGetText(WebElement element, String result) {

  // Increment the counter
  int count = getTextCounter.incrementAndGet();
  String countStr = Integer.toString(count);

  // Print captured text
  logger("Captured Text:" + result);

  if (result.contains("Giant")) {
    logger("Captured Giant");
    
} else {
  
}

//   // Check if the captured text contains "Giant"
  if (result.contains("Giant")) {
      isDoubleSidedFound = true;
      if(count > 2){
      logger("found at iteration " + count);
      }
  } else {
      logger("Notext iteration" + count);
  }

}

public int getGetTextCallCount() {
  return getTextCounter.get();
}

public boolean isDoubleSidedFound() {
  return isDoubleSidedFound;
}



    
}