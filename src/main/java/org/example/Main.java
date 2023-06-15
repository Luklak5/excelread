package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Main
{

    public static void main(String[] args) throws IOException, InvalidFormatException
    {
        if(args.length == 0)
        {
            System.out.println("Please input file to read as an argument!");
            return;
        }
        File file = new File(args[0]);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        for(int i = 0; i < rowCount;i++)
        {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(1);
            String cellValue;
            int number;
            cellValue = cell.getStringCellValue();
            try {
                number = Integer.parseInt(cellValue);
                if(isPrime(number))
                {
                    System.out.println(number);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    public static boolean isPrime(int number)
    {
        if(number <= 1)
        {
            return false;
        }
        for(int i = 2; i < number;i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

}