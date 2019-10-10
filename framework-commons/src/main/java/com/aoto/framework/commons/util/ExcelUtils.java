/*
 * 版权信息：Copyright (c) 2016, Aoto. All rights reserved.
 * 文件编号：ExcelUtils.java
 * 文件名称：ExcelUtils.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2016年2月15日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 *
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class ExcelUtils
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param dataset Collection<T>
     * @param filename String
     * @param <T> T
     */
    public static <T> void exportExcel(Collection<T> dataset, String filename)
    {
        exportExcel("银行业务统计1", null, dataset, filename, "yyyy-MM-dd");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param headers String[]
     * @param dataset Collection<T>
     * @param filename String
     * @param <T> T
     */
    public static <T> void exportExcel(String[] headers, Collection<T> dataset, String filename)
    {
        exportExcel("银行业务统计", headers, dataset, filename, "yyyy-MM-dd");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param title String
     * @param headers String[]
     * @param dataset Collection<T>
     * @param filename String
     * @param <T> T
     */
    public static <T> void exportExcel(String title, String[] headers, Collection<T> dataset, String filename)
    {
        exportExcel(title, headers, dataset, filename, "yyyy-MM-dd");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param headers String[]
     * @param dataset Collection<T>
     * @param filename String
     * @param pattern String
     * @param <T> T
     */
    public static <T> void exportExcel(String[] headers, Collection<T> dataset, String filename, String pattern)
    {
        exportExcel("银行业务统计2", headers, dataset, filename, pattern);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title    表格标题名
     * @param headers  表格属性列名数组
     * @param dataset  需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                 javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param filename 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern  如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     * @param <T>  T
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws IOException
     */
    public static <T> void exportExcel(String title, String[] headers, Collection<T> dataset, String filename,
                                       String pattern)
    {
        HSSFWorkbook workbook = null;
        OutputStream out = null;

        try
        {
            // 声明一个工作薄
            workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(title);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(NumberEnum.NUMBER_15.getNum());
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 生成一个字体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) NumberEnum.NUMBER_12.getNum());
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

            // // 声明一个画图的顶级管理器
            // HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            // // 定义注释的大小和位置,详见文档
            // HSSFComment comment = patriarch.createComment(new
            // HSSFClientAnchor(0,
            // 0, 0, 0, (short) 4, 2, (short) 6, 5));
            // // 设置注释内容
            // comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
            // // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
            // comment.setAuthor("leno");

            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            int colIndex;
            while (it.hasNext())
            {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                colIndex = 0;
                for (int i = 0; i < fields.length; i++)
                {
                    Field field = fields[i];
                    if (!Modifier.isStatic(field.getModifiers())) {
                        HSSFCell cell = row.createCell(colIndex);
                        cell.setCellStyle(style2);
                        String fieldName = field.getName();
                        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                        Class<?> tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName, new Class[]
                                {});
                        Object value = getMethod.invoke(t, new Object[]
                                {});
                        // 判断值的类型后进行强制类型转换
                        String textValue = null;

                        if (value != null) {
                            textValue = value.toString();
                        }

                        // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                        if (textValue != null)
                        {
                            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                            Matcher matcher = p.matcher(textValue);
                            if (matcher.matches())
                            {
                                // 是数字当作double处理
                                cell.setCellValue(Double.parseDouble(textValue));
                            }
                            else
                            {
                                HSSFRichTextString richString = new HSSFRichTextString(textValue);
                                HSSFFont font3 = workbook.createFont();
                                font3.setColor(HSSFColor.BLUE.index);
                                richString.applyFont(font3);
                                cell.setCellValue(richString);
                            }
                        }
                        colIndex++;
                    }
                }
            }

            out = new FileOutputStream(filename);
            workbook.write(out);
        }
        catch (Exception e)
        {
            LOGGER.error("exportExcel error", e);
        }
        finally
        {
            if (null != out)
            {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("out.close error", e);
                }
            }

            if (null != workbook)
            {
                try
                {
                    workbook.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("workbook.close error", e);
                }
            }
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:file 需要上传的文件 path 文件路径 list 读取excel后将值存放在此 list中 headers = {
     *           "机构代码","机构名称","父机构代码","地址" ,"联系电话"}; maxSize 文件限制大小
     *
     * @author zongwj
     * @param list List<List<? extends Object>>
     * @param headers String[]
     * @param filename String
     * @return String
     */
    public static String importExcel(List<List<? extends Object>> list, String[] headers, String filename)
    {
        return readExcelToList(filename, list, headers);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:file 需要上传的文件 path 文件路径 list 读取excel后将值存放在此 list中 headers = {
     *           "机构代码","机构名称","父机构代码","地址" ,"联系电话"}; maxSize 文件限制大小
     *
     * @author zongwj
     * @param list List<List<? extends Object>>
     * @param headers String[]
     * @param filename String
     * @return String
     */
    public static String importHousingExcel(List<List<? extends Object>> list, String[] headers, String filename)
    {
        return readHousingExcelToList(filename, list, headers);
    }


    /**
     * [简要描述]:<br/>
     * [详细描述]:path 文件路径 list 读取excel后将值存放在此 list中 headers = {
     *           "机构代码","机构名称","父机构代码","地址" };
     *
     * @author zongwj
     * @param path String
     * @param list List<List<? extends Object>>
     * @param headers String[]
     * @return String
     */
    public static String readHousingExcelToList(String path, List<List<? extends Object>> list, String[] headers)
    {
        Workbook workbook = null;
        InputStream in = null;

        try
        {
            in = new FileInputStream(path);
            String ext = FilenameUtils.getExtension(StringUtils4Aoto.trim(path));

            if ("xls".equals(ext))
            {
                workbook = new HSSFWorkbook(in);
            }
            else
            {
                // workbook = new XSSFWorkbook(is);
                workbook = new HSSFWorkbook(in);
            }

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++)
            {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null)
                {
                    return "文件不能为空";
                }

                if (sheet.getLastRowNum() > Constants.EXCEL_SHEET_LINE_MAX)
                {
                    return "文件不能超过1000行数据,请分批导入";
                }

                // 循环行Row
                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++)
                {
                    List<String> rowList = new ArrayList<String>();
                    Row row = sheet.getRow(rowNum);
                    if (row == null)
                    {
                        return "第" + (rowNum + 1) + "行不能为空行";
                    }

                    for (int cellNum = 0; cellNum < headers.length; cellNum++)
                    {
                        rowList.add(getValue(row.getCell(cellNum)));
                    }

                    list.add(rowList);
                }
            }
        }
        catch (Exception e)
        {
            LOGGER.error("readExcelToList error", e);
            return "readExcelToList error";
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("in.close error", e);
                }
            }

            if (null != workbook)
            {
                try
                {
                    workbook.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("workbook.close error", e);
                }
            }
        }

        return null;
    }


    /**
     * [简要描述]:<br/>
     * [详细描述]:path 文件路径 list 读取excel后将值存放在此 list中 headers = {
     *           "机构代码","机构名称","父机构代码","地址" };
     *
     * @author zongwj
     * @param path String
     * @param list List<List<? extends Object>>
     * @param headers String[]
     * @return String
     */
    public static String readExcelToList(String path, List<List<? extends Object>> list, String[] headers)
    {
        Workbook workbook = null;
        InputStream in = null;

        try
        {
            in = new FileInputStream(path);
            String ext = FilenameUtils.getExtension(StringUtils4Aoto.trim(path));

            if ("xls".equals(ext))
            {
                workbook = new HSSFWorkbook(in);
            }
            else
            {
                // workbook = new XSSFWorkbook(is);
                workbook = new HSSFWorkbook(in);
            }

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++)
            {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null)
                {
                    return "文件不能为空";
                }

                if (sheet.getLastRowNum() > Constants.EXCEL_SHEET_LINE_MAX)
                {
                    return "文件不能超过1000行数据,请分批导入";
                }

                // 循环行Row
                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++)
                {
                    List<String> rowList = new ArrayList<String>();
                    Row row = sheet.getRow(rowNum);
                    if (row == null)
                    {
                        return "第" + (rowNum + 1) + "行不能为空行";
                    }

                    for (int cellNum = 0; cellNum < headers.length; cellNum++)
                    {
                        rowList.add(getValue(row.getCell(cellNum)));
                    }

                    list.add(rowList);
                }
            }
        }
        catch (Exception e)
        {
            LOGGER.error("readExcelToList error", e);
            return "readExcelToList error";
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("in.close error", e);
                }
            }

            if (null != workbook)
            {
                try
                {
                    workbook.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("workbook.close error", e);
                }
            }
        }

        return null;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:解决excel类型问题，获得数值
     *
     * @author zongwj
     * @param cell Cell
     * @return String
     */
    private static String getValue(Cell cell)
    {
        String value = "";
        if (null == cell)
        {
            return value;
        }
        switch (cell.getCellType())
        {
            // 数值型
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    // 如果是date类型则 ，获取该cell的date值
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = format.format(date);
                }
                else
                {// 纯数字
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    // 解决1234.0 去掉后面的.0
                    if (null != value && !"".equals(value.trim()))
                    {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1]))
                        {
                            value = item[0];
                        }
                    }
                }
                break;
            // 字符串类型
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().toString();
                break;
            // 公式类型
            case HSSFCell.CELL_TYPE_FORMULA:
                // 读公式计算值
                value = String.valueOf(cell.getNumericCellValue());
                if (value.equals("NaN"))
                {// 如果获取的数据值为非法值,则转换为获取字符串
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值
            case HSSFCell.CELL_TYPE_BLANK:
                value = "";
                // LogUtil.getLogger().error("excel出现空值");
                break;
            // 故障
            case HSSFCell.CELL_TYPE_ERROR:
                value = "";
                // LogUtil.getLogger().error("excel出现故障");
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim()))
        {
            value = "";
        }
        return value;
    }
}
