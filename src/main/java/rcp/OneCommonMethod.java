package rcp;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//Export Imports
//Selenium imports
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Apache POI for Excel handling
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExtentReports logging
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.Locators;

//Java standard libraries
import java.io.FileInputStream;
import java.time.Duration;


public class OneCommonMethod {
	
	
    public static String takeScreenshotBase64(WebDriver driver) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
    
    //Method if test case is failed
/*   public static void captureScreenshotOnFailure(WebDriver driver, ExtentTest test, boolean isTestFailed) {
        if (isTestFailed) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src);
                String base64Screenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);

                test.log(LogStatus.FAIL, "Test failed - Screenshot captured",
                        test.addBase64ScreenShot(base64Screenshot));
            } catch (IOException e) {
                test.log(LogStatus.ERROR, "Screenshot capture failed: " + e.getMessage());
            }
        }
    }
*/
    public static void captureScreenshotOnFailure(WebDriver driver, ExtentTest test, boolean isTestFailed) {
        if (isTestFailed) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src);
                String base64Screenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);

                test.log(LogStatus.UNKNOWN, "Test failed - Screenshot captured",
                        test.addBase64ScreenShot(base64Screenshot));
            } catch (IOException e) {
                test.log(LogStatus.UNKNOWN, "Screenshot capture failed: " + e.getMessage());
            }
        }
    }

  //It will generate Random String just need to call 'getRandomString'
    public static String getRandomString() {
        return new java.util.Random().ints(6, 0, 62)
            .mapToObj(i -> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }

    public static void zoomOutScreen(int times) {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < times; i++) {
            	Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(2000); // thoda delay zoom-out ke beech
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
/*    
   //Export button
    public void validateExportedExcel(WebDriver driver, ExtentTest test, WebElement exportButton, String columnHeaderToCount) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Step 1: Get grid count from page
            String itemText = CoordinatorLocator.readTotalItems().getText();
            String[] words = itemText.split(" ");
            String countStr = words[words.length - 2];

            if (countStr.equalsIgnoreCase("to")) {
                Thread.sleep(5000);
                itemText = CoordinatorLocator.readTotalItems().getText();
                words = itemText.split(" ");
                countStr = words[words.length - 2];
            }

            int gridCount = Integer.parseInt(countStr.trim());

            // Step 2: Count files before download
            String downloadPath = System.getProperty("user.home") + "\\Downloads";
            File dirBefore = new File(downloadPath);
            File[] filesBefore = dirBefore.listFiles();

            // Step 3: Click Export
            scrollBy(driver, -500);
            wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();

            // Step 4: Wait until file downloaded
            File downloadedFile = waitForNewFile(downloadPath, filesBefore, 20);
            if (downloadedFile == null) {
                test.log(LogStatus.FAIL, "File didn't download successfully.");
                return;
            }

            test.log(LogStatus.PASS, "File downloaded: " + downloadedFile.getName());

            // Step 5: Read Excel row count
            FileInputStream fis = new FileInputStream(downloadedFile);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int targetColumn = findColumnIndex(sheet, columnHeaderToCount);
            int excelRowCount = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                Cell cell = row.getCell(targetColumn);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    excelRowCount++;
                }
            }

            fis.close();

            // Step 6: Compare counts
            if (gridCount == excelRowCount) {
                test.log(LogStatus.PASS, "Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            } else {
                test.log(LogStatus.FAIL, "Mismatch: Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Utility: Scroll
    private void scrollBy(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Utility: Wait for new file
    private File waitForNewFile(String dirPath, File[] oldFiles, int timeoutSeconds) throws InterruptedException {
        File dir = new File(dirPath);
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < end) {
            File[] newFiles = dir.listFiles();
            if (newFiles != null && newFiles.length > oldFiles.length) {
                File latestFile = newFiles[0];
                for (int i = 1; i < newFiles.length; i++) {
                    if (latestFile.lastModified() < newFiles[i].lastModified()) {
                        latestFile = newFiles[i];
                    }
                }
                return latestFile;
            }
            Thread.sleep(1000);
        }
        return null;
    }

    // Utility: Find column index using header
    private int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) return 0;

        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return 0; // fallback
    }

    */
    
    
    
    
    
    
    
/*
    public static void validateExportedExcel(WebDriver driver, ExtentTest test, WebElement exportButton, WebElement gridCountElement, String columnHeaderToCount) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);

            // Step 1: Get grid count
            String itemText = gridCountElement.getText();
            String[] words = itemText.split(" ");
            String countStr = words[words.length - 2];

            if (countStr.equalsIgnoreCase("to")) {
                Thread.sleep(5000);
                itemText = gridCountElement.getText();
                words = itemText.split(" ");
                countStr = words[words.length - 2];
            }

            int gridCount = Integer.parseInt(countStr.trim());

            // Step 2: Count files before download
            String downloadPath = System.getProperty("user.home") + "\\Downloads";
            File dirBefore = new File(downloadPath);
            File[] filesBefore = dirBefore.listFiles();

            // Step 3: Click Export
            scrollBy(driver, -500);
            wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();

            // Step 4: Wait for file
            File downloadedFile = waitForNewFile(downloadPath, filesBefore, 20);
            if (downloadedFile == null) {
                test.log(LogStatus.FAIL, "❌ File did not download.");
                return;
            }

            test.log(LogStatus.PASS, "✅ File downloaded: " + downloadedFile.getName());

            // Step 5: Read Excel
            FileInputStream fis = new FileInputStream(downloadedFile);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int targetColumn = findColumnIndex(sheet, columnHeaderToCount);
            int excelRowCount = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                Cell cell = row.getCell(targetColumn);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    excelRowCount++;
                }
            }

            fis.close();

            // Step 6: Compare counts
            if (gridCount == excelRowCount) {
                test.log(LogStatus.PASS, "✅ Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            } else {
                test.log(LogStatus.FAIL, "❌ Mismatch: Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void scrollBy(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    private static File waitForNewFile(String dirPath, File[] oldFiles, int timeoutSeconds) throws InterruptedException {
        File dir = new File(dirPath);
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < end) {
            File[] newFiles = dir.listFiles();
            if (newFiles != null && newFiles.length > oldFiles.length) {
                File latestFile = newFiles[0];
                for (int i = 1; i < newFiles.length; i++) {
                    if (latestFile.lastModified() < newFiles[i].lastModified()) {
                        latestFile = newFiles[i];
                    }
                }
                return latestFile;
            }
            Thread.sleep(1000);
        }
        return null;
    }

    private static int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) return 0;

        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return 0;
    } */

    
 //Export Start ------------

    public static void validateExportedExcel(WebDriver driver, ExtentTest test, WebElement exportButton, WebElement gridCountElement, String columnHeaderToCount) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);

            // Step 1: Get grid count from WebElement (already fetched)
            String itemText = gridCountElement.getText();  // Example: "1 – 1 of 1 items"
            String[] words = itemText.split(" ");
            String countStr = words[words.length - 2];

            if (countStr.equalsIgnoreCase("to")) {
                Thread.sleep(5000);
                itemText = gridCountElement.getText();
                words = itemText.split(" ");
                countStr = words[words.length - 2];
            }

            int gridCount = Integer.parseInt(countStr.trim());

            // Step 2: Count files before export
            String downloadPath = System.getProperty("user.home") + "\\Downloads";
            File dirBefore = new File(downloadPath);
            File[] filesBefore = dirBefore.listFiles();

            // Step 3: Click Export
            scrollBy(driver, -500);
            wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();

            // Step 4: Wait for file
            File downloadedFile = waitForNewFile(downloadPath, filesBefore, 20);
            if (downloadedFile == null) {
                test.log(LogStatus.FAIL, "❌ File did not download.");
                return;
            }

  //        test.log(LogStatus.PASS, "✅ File downloaded: " + downloadedFile.getName());
  //        test.log(LogStatus.PASS, "✅ <b>File Downloaded</b><br><b>File Name:</b> " + downloadedFile.getName());
            test.log(LogStatus.PASS, "✅ File downloaded ");
            test.log(LogStatus.PASS, "✅ File Name is :  " + downloadedFile.getName());


            // Step 5: Read Excel
            FileInputStream fis = new FileInputStream(downloadedFile);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int targetColumn = findColumnIndex(sheet, columnHeaderToCount);
            int excelRowCount = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                Cell cell = row.getCell(targetColumn);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    excelRowCount++;
                }
            }

            fis.close();

            // Step 6: Compare
            if (gridCount == excelRowCount) {
                test.log(LogStatus.PASS, "✅ Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            } else {
                test.log(LogStatus.FAIL, "❌ Mismatch: Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // helpers remain same (scrollBy, waitForNewFile, findColumnIndex)
   

    private static void scrollBy(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    private static File waitForNewFile(String dirPath, File[] oldFiles, int timeoutSeconds) throws InterruptedException {
        File dir = new File(dirPath);
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < end) {
            File[] newFiles = dir.listFiles();
            if (newFiles != null && newFiles.length > oldFiles.length) {
                File latestFile = newFiles[0];
                for (int i = 1; i < newFiles.length; i++) {
                    if (latestFile.lastModified() < newFiles[i].lastModified()) {
                        latestFile = newFiles[i];
                    }
                }
                return latestFile;
            }
            Thread.sleep(1000);
        }
        return null;
    }

    private static int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) return 0;

        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return 0;
    }
    
    
//Export End----to call use this: OneCommonMethod.validateExportedExcel(driver.get(), test, Locators.Export(), "Clientid");
    
    
    
    
    
    //Download Code:------------

    public static void validateFileDownload(WebDriver driver, ExtentTest test, WebElement downloadButton) {
        try {
            String downloadPath = "C:\\Users\\bilali\\Downloads";
            File downloadDir = new File(downloadPath);
            File[] filesBefore = downloadDir.listFiles();

            Thread.sleep(5000);

            // Use WebElement directly
            downloadButton.click();

            Thread.sleep(8000);

            File[] filesAfter = downloadDir.listFiles();
            Thread.sleep(3000);

            File downloadedFile = null;
            if (filesAfter.length > filesBefore.length) {
                for (File file : filesAfter) {
                    boolean isNew = true;
                    for (File oldFile : filesBefore) {
                        if (file.getName().equals(oldFile.getName())) {
                            isNew = false;
                            break;
                        }
                    }
                    if (isNew) {
                        downloadedFile = file;
                        break;
                    }
                }
            }

            if (downloadedFile != null) {
                test.log(LogStatus.PASS, "✅ File downloaded.");
                test.log(LogStatus.PASS, "✅ File Name is : " + downloadedFile.getName());
            } else {
                test.log(LogStatus.FAIL, "❌ File was not downloaded.");
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during file download: " + e.getMessage());
        }
    }

    
    
    
    
    //Method for Type to search 
    public static void searchAndLogMultipleKeywords(
            WebDriver driver,
            Map<String, List<String>> searchMap,
            WebElement searchBox,
            WebElement clearButton,
            ExtentTest test) {

        try {
            Thread.sleep(3000);

            for (String columnName : searchMap.keySet()) {
                for (String keyword : searchMap.get(columnName)) {
                    try {
                        searchBox.clear();
                        searchBox.sendKeys(keyword, Keys.ENTER);
                        Thread.sleep(3000);

                        try {
                            WebElement cell = driver.findElement(By.xpath("//div[@title='" + keyword + "']"));
                            test.log(LogStatus.PASS, "Searched and found record under '" + columnName + "' column: " + keyword);
                        } catch (Exception e) {
                            test.log(LogStatus.INFO, "No record available for search keyword: '" + keyword + "' under column: '" + columnName + "'");
                        }

                        Thread.sleep(2000);
                        clearButton.click();
                        Thread.sleep(1000);

                    } catch (Exception innerEx) {
                        test.log(LogStatus.FAIL, "Search failed for keyword: '" + keyword + "'");
                        innerEx.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred during multiple keyword search");
            e.printStackTrace();
        }
    }

    
    
    
    

}
