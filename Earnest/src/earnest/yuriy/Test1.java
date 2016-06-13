package earnest.yuriy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuriy on 12.06.2016.
 */
public class Test1
{
    public static void main(String[] args)
    {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://jungle-socks.herokuapp.com/");
        WebElement zebra = wd.findElement(By.xpath("//input[@ id = 'line_item_quantity_zebra']"));
        WebElement lion = wd.findElement(By.id("line_item_quantity_lion"));
        WebElement elephant = wd.findElement(By.id("line_item_quantity_elephant"));
        WebElement giraffe = wd.findElement(By.id("line_item_quantity_giraffe"));
        WebElement submitButton = wd.findElement(By.name("commit"));

       List<WebElement> states = wd.findElements(By.tagName("option"));
        String[] st = new String[states.size()];

        for (int i=0; i<states.size(); i++)
        {
            st[i] = states.get(i).getAttribute("value");
        }
        zebra.sendKeys("23");
        lion.sendKeys("12");
        elephant.sendKeys("3");
        giraffe.sendKeys("15");
      //  String a = wd.getPageSource();
       // System.out.println(a);
        //Select dropdown = new Select(wd.findElement(By.name("state")));
        //dropdown.selectByValue("NJ");
       for (int s=1; s<st.length; s++)
       {
           wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           wd.findElement(By.xpath("//option[@value = '" + st[s] + "']")).click();
           wd.findElement(By.name("commit")).click();
           if ("CA".equals(st[s]))
           {   double a = ((13*23)+(20*12)+(35*3)+(17*15))*0.08;
               String w = wd.findElement(By.id("taxes")).getText();
                w=w.replace("$","");
               double t = Double.parseDouble(w);
               int zzz = Double.compare(a, t);
               if (zzz==0)System.out.println("CA pass");
               else System.out.println("CA fail");
           }
           else  if ("NY".equals(st[s]))
           {   double a = ((13*23)+(20*12)+(35*3)+(17*15))*0.06;
               String w = wd.findElement(By.id("taxes")).getText();
               w=w.replace("$","");
               double t = Double.parseDouble(w);
               int zzz = Double.compare(a, t);
               if (zzz==0)System.out.println("NY pass");
               else System.out.println("NY fail");
           }
           else  if ("MN".equals(st[s]))
           {   double a = 0.00;
               String w = wd.findElement(By.id("taxes")).getText();
               w=w.replace("$","");
               double t = Double.parseDouble(w);
               int zzz = Double.compare(a, t);
               if (zzz==0)System.out.println("MN pass");
               else System.out.println("MN fail");
           }
           else
           {   double a = ((13*23)+(20*12)+(35*3)+(17*15))*0.05;
               String w = wd.findElement(By.id("taxes")).getText();
               w=w.replace("$","");
               double t = Double.parseDouble(w);
               int zzz = Double.compare(a, t);
               if (zzz==0)System.out.println( st[s] + " pass");
               else System.out.println(st[s] + " fail");
           }
           wd.navigate().back();
       }

//        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//       wd.navigate().back();
//        wd.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/select/option[9]")).click();
//        wd.findElement(By.name("commit")).click();
//        wd.navigate().back();
//        wd.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/select/option[1]")).click();

//        dropdown.selectByValue("NY");
//        submitButton.click();

//        for (int i=0; i<states.size(); i++)
//        {
//            String s = states.get(i).getAttribute("value");
//
//            dropdown.selectByValue("NJ");
//            submitButton.click();
//            wd.navigate().back();
//
//            if(s.equals("NJ"))
//            {
//                states.get(i).getAttribute("value").
//                submitButton.click();
//
//            }
//            System.out.println(s);
//        }

//        for (WebElement option : states)
//        {
//
//            String s = option.getAttribute("value");
//            if(s.equals("CA"))
//            {
//                option.click();
//                wd.findElement(By.name("commit")).click();
//                wd.navigate().back();
//            }
//            if(s.equals("NJ"))
//            {
//                option.click();
//                wd.findElement(By.name("commit")).click();
//                wd.navigate().back();
//            }
//        }

//        for (int i=0; i<states.size(); i++){
//            System.out.println(states.size());
//
//      }
//
//    }

//    public static void start(){
//        WebDriver wd = new FirefoxDriver();
//
//        wd.get("https://jungle-socks.herokuapp.com/");
//        WebElement zebra = wd.findElement(By.id("line_item_quantity_zebra"));
//        WebElement lion = wd.findElement(By.id("line_item_quantity_lion"));
//        WebElement elephant = wd.findElement(By.id("line_item_quantity_elephant"));
//        WebElement giraffe = wd.findElement(By.id("line_item_quantity_giraffe"));
//        WebElement submitButton = wd.findElement(By.name("commit"));

//        zebra.sendKeys("23");
//        lion.sendKeys("12");
//        elephant.sendKeys("3");
//        giraffe.sendKeys("15");
//
//        //Select dropdown = new Select(wd.findElement(By.name("state")));
//
    }
}
